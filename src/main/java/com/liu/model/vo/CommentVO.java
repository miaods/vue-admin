package com.liu.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author liumiao
 * @create 2021-10-16-20:08
 */

@Data
public class CommentVO {

    private String id;

    private String content;

    private String topicId;

    private String userId;

    private String username;

    private Date createTime;

}