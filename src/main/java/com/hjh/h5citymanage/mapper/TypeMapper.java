package com.hjh.h5citymanage.mapper;

import com.hjh.h5citymanage.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:45
 */
@Mapper
public interface TypeMapper {
    public List<Type> getTypes();
}
