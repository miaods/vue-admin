package com.liu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.model.entity.BmsPost;
import com.liu.model.entity.BmsTag;

import java.util.List;

/**
 * @author liumiao
 * @create 2021-10-16-17:33
 */
public interface IBmsTagService extends IService<BmsTag> {
    /**
     * 插入标签
     *
     * @param tags
     * @return
     */
    List<BmsTag> insertTags(List<String> tags);
    /**
     * 获取标签关联话题
     *
     * @param topicPage
     * @param id
     * @return
     */
    Page<BmsPost> selectTopicsByTagId(Page<BmsPost> topicPage, String id);
}
