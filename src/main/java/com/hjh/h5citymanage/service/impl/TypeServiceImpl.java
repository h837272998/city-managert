package com.hjh.h5citymanage.service.impl;

import com.hjh.h5citymanage.mapper.TypeMapper;
import com.hjh.h5citymanage.pojo.Type;
import com.hjh.h5citymanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:51
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> getTypes() {
        return typeMapper.getTypes();
    }
}
