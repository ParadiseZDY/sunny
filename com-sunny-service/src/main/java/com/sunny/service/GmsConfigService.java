package com.sunny.service;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.sunny.dao.GmsConfigDao;
import com.sunny.domain.GmsConfig;
import com.sunny.rpc.IGmsConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * 
 * 
 * @author zhao.dy
 * @date 2018-04-16 12:20
 **/
@Service
public class GmsConfigService implements IGmsConfigService {

	private static Logger logger = LoggerFactory.getLogger(GmsConfigService.class);

	@Resource
	private GmsConfigDao gmsConfigDao;

	private LoadingCache<String,List<GmsConfig>> loadingCache;

	@PostConstruct
	public void init() {
		loadingCache = CacheBuilder.newBuilder()
				.maximumSize(10000).recordStats().expireAfterWrite(2, TimeUnit.MINUTES).build(new CacheLoader<String, List<GmsConfig>>() {
			@Override
			public List<GmsConfig> load(String key) throws Exception {
				logger.info("get from cache...");
				return gmsConfigDao.selectByObjectList(new GmsConfig());
			}
		});
	}

	@Override
	public List<GmsConfig> getListFromCache(GmsConfig gmsConfig){
		List<GmsConfig> configList;
		try {
			configList = loadingCache.get("all");
			if (CollectionUtils.isEmpty(configList)){
				logger.info("loadingCache.status={}", JSON.toJSONString(loadingCache.stats()));
				configList = gmsConfigDao.selectByObjectList(gmsConfig);
			}
		} catch (ExecutionException e) {
			logger.error("getListFromCache.error={}",e);
			configList = Lists.newArrayList();
		}
		return configList;
	}

	@Override
	public GmsConfig selectByPrimaryKey(Integer id) {
		return gmsConfigDao.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return gmsConfigDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(GmsConfig gmsConfig) {
		return gmsConfigDao.insertSelective(gmsConfig);
	}

	@Override
	public int updateByPrimaryKeySelective(GmsConfig gmsConfig) {
		return gmsConfigDao.updateByPrimaryKeySelective(gmsConfig);
	}

	@Override
	public int updateByPrimaryKey(GmsConfig gmsConfig) {
		return gmsConfigDao.updateByPrimaryKey(gmsConfig);
	}

	@Override
	public Long selectObjectListPageTotal(GmsConfig gmsConfig) {
		return gmsConfigDao.selectObjectListPageTotal(gmsConfig);
	}

	@Override
	public List<GmsConfig> selectObjectListPage(GmsConfig gmsConfig) {
		return gmsConfigDao.selectObjectListPage(gmsConfig);
	}

	@Override
	public List<GmsConfig> selectByObjectList(GmsConfig gmsConfig){
		return gmsConfigDao.selectByObjectList(gmsConfig);
	}

}
