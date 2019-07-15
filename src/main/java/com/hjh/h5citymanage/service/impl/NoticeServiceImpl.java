package com.hjh.h5citymanage.service.impl;

import com.hjh.h5citymanage.mapper.NoticeMapper;
import com.hjh.h5citymanage.pojo.Notice;
import com.hjh.h5citymanage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:51
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNotices() {
        return noticeMapper.getNotices();
    }

    @Override
    public Notice getNoticeById(int id) {
        return noticeMapper.getNoticeById(id);
    }

    @Override
    public List<Notice> getNoticesIsPublish() {
        return noticeMapper.getNoticesIsPublish();
    }

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public boolean setPublishStatusIsZore(List number) {
        int count = noticeMapper.setPublishStatusIsZore(number);
        boolean f = true;
        if (count != number.size()) {
            f = false;
            throw new IllegalArgumentException("修改不完全，事务回滚");

        }
        return f;
    }

    @Override
    public void delete(int id) {
        noticeMapper.delete(id);
    }

    @Override
    public void updataNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }
}
