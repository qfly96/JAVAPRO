package com.qk.mapper;

import java.util.List;

import com.qk.model.Props;

public interface PropsMapper {
    int deleteByPrimaryKey(String propsId);

    int insert(Props record);

    int insertSelective(Props record);

    Props selectByPrimaryKey(String propsId);

    int updateByPrimaryKeySelective(Props record);

    int updateByPrimaryKey(Props record);
    
    List<Props> selectAllProps();
}