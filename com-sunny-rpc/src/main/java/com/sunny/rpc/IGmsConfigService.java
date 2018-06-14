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

	GmsConfig selectByPrimaryKey(Integer id);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(GmsConfig gmsConfig);

	int updateByPrimaryKeySelective(GmsConfig gmsConfig);

	int updateByPrimaryKey(GmsConfig gmsConfig);

	Long selectObjectListPageTotal(GmsConfig gmsConfig);

	List<GmsConfig> selectObjectListPage(GmsConfig gmsConfig);

	List<GmsConfig> selectByObjectList(GmsConfig gmsConfig);

}
