package com.hjh.h5citymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjh.h5citymanage.pojo.Notice;
import com.hjh.h5citymanage.pojo.User;
import com.hjh.h5citymanage.service.NoticeService;
import com.hjh.h5citymanage.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-12 16:07
 */
@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notices")
    public PageInfo<Notice> getNotices(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(start, size, "id desc");
        List<Notice> notices = noticeService.getNotices();

        PageInfo<Notice> page = new PageInfo<>(notices, 3); //navigatepages表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @GetMapping("/noticesIsPublish")
    public List<Notice> getNoticesPublish() {
        List<Notice> notices = noticeService.getNoticesIsPublish();
        return notices;
    }

    @PostMapping("/notices")
    public ResultBean updataNoticePublish(@RequestBody Map map) {
        int lenght = (int) map.get("length");
        List number = new ArrayList();
        for (int i = 0; i < lenght; i++) {
            number.add(map.get(i + ""));
        }
        boolean f = noticeService.setPublishStatusIsZore(number);
        if (f) {
            return new ResultBean<>();
        }
        return new ResultBean<>("更新数据失败。");
    }

    @GetMapping("/notices/{id}")
    public ModelAndView getCategory(@PathVariable("id") int id, Model m) throws Exception {
        Notice notice = noticeService.getNoticeById(id);
        m.addAttribute("notice", notice);
        ModelAndView modelAndView = new ModelAndView("city_info");
//        modelAndView.getModel().put()
        return modelAndView;
    }

    @DeleteMapping("/notices/{id}")
    public ResultBean delete(@PathVariable("id") int id, Model m) throws Exception {
        noticeService.delete(id);
        return new ResultBean<>();
    }

    @PutMapping("/notices/{id}")
    public ResultBean update(@RequestBody Notice notice) {
        noticeService.updataNotice(notice);
        return new ResultBean();
    }

    @PostMapping("/notice")
    public ResultBean addNotice(@RequestBody Notice notice, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        notice.setUser(user);
        noticeService.addNotice(notice);
        return new ResultBean<>();
    }
}
