package com.sunny.service;

import com.sunny.dao.GmsConfigDao;
import com.sunny.domain.GmsConfig;
import com.sunny.rpc.IGmsConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 
 * 
 * @author zhao.dy
 * @date 2018-04-16 12:20
 **/
@Service("gmsConfigService")
public class GmsConfigServiceImpl implements IGmsConfigService {

	private static Logger logger = LoggerFactory.getLogger(GmsConfigServiceImpl.class);

	@Resource
	private GmsConfigDao gmsConfigDao;

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
