package com.kingmao.dynamic.apple.service.impl;

import com.kingmao.dynamic.apple.dao.AppleMapper;
import com.kingmao.dynamic.apple.entity.Apple;
import com.kingmao.dynamic.apple.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QX
 * @date 2020/4/29
 */
@Service
public class AppleServiceImpl implements AppleService {

    @Autowired
    private AppleMapper appleMapper;

    @Override
    public List<Apple> getAll() {
        return appleMapper.getAll();
    }

    @Override
    public Apple getById(Integer id) {
        return appleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(Apple apple) {
        return appleMapper.insert(apple);
    }
}
