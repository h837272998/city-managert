package com.hjh.h5citymanage.mapper;

import com.hjh.h5citymanage.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:45
 */
@Mapper
public interface NoticeMapper {
    public List<Notice> getNotices();

    public Notice getNoticeById(int id);

    public List<Notice> getNoticesIsPublish();

    public int setPublishStatusIsZore(List number);

    public void delete(int id);

    public void updateNotice(Notice notice);

    public void addNotice(Notice notice);
}
