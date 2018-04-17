package com.sunny.rpc;

import com.sunny.domain.GmsConfig;

import java.util.List;

/**
 * 
 * 
 * @author zhao.dy
 * @date 2018-04-16 12:20
 **/
public interface IGmsConfigService {

	public GmsConfig selectByPrimaryKey(Integer id);

	public int deleteByPrimaryKey(Integer id);

	public int insertSelective(GmsConfig gmsConfig);

	public int updateByPrimaryKeySelective(GmsConfig gmsConfig);

	public int updateByPrimaryKey(GmsConfig gmsConfig);

	public Long selectObjectListPageTotal(GmsConfig gmsConfig);

	public List<GmsConfig> selectObjectListPage(GmsConfig gmsConfig);

	public List<GmsConfig> selectByObjectList(GmsConfig gmsConfig);

}
