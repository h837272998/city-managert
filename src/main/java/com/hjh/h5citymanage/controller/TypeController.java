package com.hjh.h5citymanage.controller;

import com.hjh.h5citymanage.pojo.Type;
import com.hjh.h5citymanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-14 16:33
 */
@RestController
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public List<Type> getTypes() {
        return typeService.getTypes();

    }
}
