package com.hjh.h5citymanage.manage.controller;

import com.hjh.h5citymanage.pojo.Notice;
import com.hjh.h5citymanage.pojo.Type;
import com.hjh.h5citymanage.service.NoticeService;
import com.hjh.h5citymanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-13 13:35
 */
@RestController
public class ManageController {

    @GetMapping("/manager")
    public ModelAndView getManage() {
        return new ModelAndView("admin/manager");
    }

    @GetMapping("getTopView")
    public ModelAndView getTopView() {
        return new ModelAndView("admin/top");
    }

    @GetMapping("getLeftView")
    public ModelAndView getLeftView() {
        return new ModelAndView("admin/left");
    }

    @GetMapping("getNoticeView")
    public ModelAndView getNoticeView() {
        return new ModelAndView("admin/notice");
    }

    @Autowired
    NoticeService noticeService;

    @Autowired
    TypeService typeService;

    @GetMapping("editNoticeView/{id}")
    public ModelAndView getEditNoticeView(@PathVariable(value = "id") int id, Model m) {
        ModelAndView mv = new ModelAndView("admin/updateNotice");
        Notice notice = noticeService.getNoticeById(id);
        List<Type> types = typeService.getTypes();
        m.addAttribute("notice", notice);
        m.addAttribute("types", types);
        return mv;
    }

    @GetMapping("getAddNoticeView")
    public ModelAndView getAddNoticeView() {
        ModelAndView mv = new ModelAndView("admin/addNotice");
        return mv;
    }
}
