package com.hjh.h5citymanage.controller;

import com.hjh.h5citymanage.pojo.Type;
import com.hjh.h5citymanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-12 10:26
 */
@RestController
public class IndexController {

    @GetMapping("/home")
    public ModelAndView getHome(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    @Autowired
    TypeService typeService;

    @GetMapping("/hjh")
    public List<Type> egsag() {
        return typeService.getTypes();
    }
}
