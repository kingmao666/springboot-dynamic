package com.kingmao.dynamic.apple.dao;

import com.kingmao.dynamic.apple.entity.Apple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface AppleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apple record);

    int insertSelective(Apple record);

    Apple selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apple record);

    int updateByPrimaryKey(Apple record);

    List<Apple> getAll();
}