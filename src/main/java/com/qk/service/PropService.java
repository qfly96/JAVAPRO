package com.qk.service;

import java.util.List;

import com.qk.model.Props;

public interface PropService {
	/**
	 * 
	 * @param p
	 * @return "SUCCESS","ERROR"
	 */
	String insertProp(String propsName,String propsRole,String propsLevel,String propsDescribe);	
	/**
	 * 
	 * @return 所有的装备
	 */
	List<Props> selectAllProps();
	/**
	 * 
	 * @param propsId 装备id
	 * @return "SUCCESS","ERROR"
	 */
	String removeProp(String propsId);
	/**
	 * 
	 * @param ids id数组
	 * @return "SUCCESS","ERROR"
	 */
	String removePropByCheckedAjax(String[] ids);
	/**
	 * 
	 * @return json字符串
	 */
	String getAllPropByJson();
}
