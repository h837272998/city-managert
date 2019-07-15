package com.hjh.h5citymanage.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-27 20:04
 */
@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {

////获取当前请求的路径
//        String basePath = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort()+request.getContextPath();
//        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理
//        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
//            //告诉ajax我是重定向
//            response.setHeader("REDIRECT","REDIRECT");
//            //告诉ajax我重定向的路径
//            response.setHeader("CONTENTPATH", basePath+"/errorPage");
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        }else {
//            response.sendRedirect(request.getContextPath() + "/errorPage");
//        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("errorPage");
//        request.setAttribute("exception",e);
//        request.setAttribute("url",request.getRequestURL());
//        request.getRequestDispatcher("errorPage").forward(request,response);
        return mav;
    }
}
