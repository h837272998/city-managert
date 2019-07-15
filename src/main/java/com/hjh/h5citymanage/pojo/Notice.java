package com.hjh.h5citymanage.pojo;


import lombok.Data;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-12 9:34
 */
@Data
public class Notice {
    private int id;
    private String title;
    private String content;
    private String creatDate;
    private String publishDate;
    private int publishStatus;
    //    private int typeId;
//    private int userId;
    private User user;
    private Type type;
}
