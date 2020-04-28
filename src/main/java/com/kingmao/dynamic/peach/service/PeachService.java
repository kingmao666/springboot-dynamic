package com.kingmao.dynamic.peach.service;

import com.kingmao.dynamic.peach.entity.Peach;

import java.util.List;

/**
 * @author QX
 * @date 2020/4/28
 */
public interface PeachService {

    List<Peach> getAll();
    Peach getById(Integer id);
    int insert(Peach apple);
}
