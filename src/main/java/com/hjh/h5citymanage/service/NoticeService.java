package com.hjh.h5citymanage.service;


import com.hjh.h5citymanage.pojo.Notice;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:50
 */
public interface NoticeService {

    public List<Notice> getNotices();

    public Notice getNoticeById(int id);

    public List<Notice> getNoticesIsPublish();

    public boolean setPublishStatusIsZore(List number);

    public void delete(int id);

    public void updataNotice(Notice notice);

    public void addNotice(Notice notice);
}
