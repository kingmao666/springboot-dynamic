package com.kingmao.dynamic.apple.service;

import com.kingmao.dynamic.apple.entity.Apple;

import java.util.List;

/**
 * @author QX
 * @date 2020/4/28
 */
public interface AppleService {

    List<Apple> getAll();
    Apple getById(Integer id);
    int insert(Apple apple);
}
