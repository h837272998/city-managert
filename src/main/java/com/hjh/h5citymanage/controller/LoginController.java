package com.hjh.h5citymanage.controller;

import com.hjh.h5citymanage.pojo.User;
import com.hjh.h5citymanage.service.UserService;
import com.hjh.h5citymanage.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-12 9:39
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView getView(HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        if (sessoin.getAttribute("USER_SESSION") != null) {
            ModelAndView mv = new ModelAndView("home");
//            ModelAndView mv = new ModelAndView("login");
            return mv;
        }
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("/loginValidate")
    public Object loginValidate(@RequestBody User user, HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        User user2 = userService.getUserByName(user.getName());
        if (user2 == null) {
            return new ResultBean<>("账户不存在...");
        }
        User user1 = userService.loginValidate(user);
        if (user1 != null) {
            sessoin.setAttribute("USER_SESSION", user1);
            Map<String, String> map = new HashMap<>();
            map.put("url", "/home");
            return new ResultBean<Map>(map);

        } else {
            return new ResultBean<>("密码错误...");
        }
    }

    @RequestMapping(value = "/loginout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }

}
