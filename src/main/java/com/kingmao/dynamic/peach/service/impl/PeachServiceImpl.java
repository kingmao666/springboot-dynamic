package com.kingmao.dynamic.peach.service.impl;

import com.kingmao.dynamic.peach.dao.PeachMapper;
import com.kingmao.dynamic.peach.entity.Peach;
import com.kingmao.dynamic.peach.service.PeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QX
 * @date 2020/4/28
 */
@Service
public class PeachServiceImpl implements PeachService {
    @Autowired
    private PeachMapper peachMapper;
    @Override
    public List<Peach> getAll() {
        return peachMapper.getAll();
    }

    @Override
    public Peach getById(Integer id) {
        return peachMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Peach apple) {
        return peachMapper.insert(apple);
    }
}
