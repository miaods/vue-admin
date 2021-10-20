package com.liu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.model.entity.BmsTag;
import com.liu.model.entity.BmsTopicTag;

import java.util.List;
import java.util.Set;

/**
 * @author liumiao
 * @create 2021-10-16-17:03
 */

public interface IBmsTopicTagService extends IService<BmsTopicTag> {

    /**
     * 获取Topic Tag 关联记录
     *
     * @param topicId TopicId
     * @return
     */
    List<BmsTopicTag> selectByTopicId(String topicId);
    /**
     * 创建中间关系
     *
     * @param id
     * @param tags
     * @return
     */
    void createTopicTag(String id, List<BmsTag> tags);
    /**
     * 获取标签换脸话题ID集合
     *
     * @param id
     * @return
     */
    Set<String> selectTopicIdsByTagId(String id);
}
