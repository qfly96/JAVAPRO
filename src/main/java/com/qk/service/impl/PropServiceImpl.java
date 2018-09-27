package com.qk.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.qk.mapper.PropsMapper;
import com.qk.model.Props;
import com.qk.service.PropService;

@Service
public class PropServiceImpl implements PropService{
	private static final String SUCCESS="SUCCESS";
	private static final String ERROR="ERROR";
	@Autowired
	private PropsMapper pm;
	@Autowired
	private Gson gson;
	
	public String insertProp(String propsName,String propsRole,String propsLevel,String propsDescribe) {
			Props p = new Props();
			p.setPropsId(UUID.randomUUID().toString());
			p.setPropsName(propsName);
			p.setPropsRole(propsRole);
			p.setPropsLevel(propsLevel);
			p.setPropsDescribe(propsDescribe);		
		try {
			return pm.insert(p)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Override
	public List<Props> selectAllProps() {
				
		return pm.selectAllProps();
	}
	
	@Override
	public String removeProp(String propsId) {
		try {
			return pm.deleteByPrimaryKey(propsId)>0?SUCCESS:ERROR;
		} catch (Exception e) {			
			return ERROR;
		}
	}
	
	@Override
	public String getAllPropByJson() {
		
		return gson.toJson(pm.selectAllProps());
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public String removePropByCheckedAjax(String[] ids) {
		try {
			int count = 0;
			for (int i = 0; i < ids.length; i++) {
				count += pm.deleteByPrimaryKey(ids[i].replaceAll("/", ""));
			}
			return count == ids.length?SUCCESS:ERROR;
		} catch (Exception e) {			
			return ERROR;
		}
	}
}
