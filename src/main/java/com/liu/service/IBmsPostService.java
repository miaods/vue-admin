package com.liu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.model.dto.CreateTopicDTO;
import com.liu.model.entity.BmsPost;
import com.liu.model.entity.UmsUser;
import com.liu.model.vo.PostVO;

import java.util.List;
import java.util.Map;

/**
 * @author liumiao
 * @create 2021-10-16-17:01
 */
public interface IBmsPostService extends IService<BmsPost> {

    /**
     * 获取首页话题列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);
    /**
     * 发布
     *
     * @param dto
     * @param user
     * @return
     */
    BmsPost create(CreateTopicDTO dto, UmsUser user);

    /**
     * 查看话题详情
     *
     * @param id
     * @return
     */
    Map<String, Object> viewTopic(String id);
    /**
     * 获取随机推荐10篇
     *
     * @param id
     * @return
     */
    List<BmsPost> getRecommend(String id);
    /**
     * 关键字检索
     *
     * @param keyword
     * @param page
     * @return
     */
    Page<PostVO> searchByKey(String keyword, Page<PostVO> page);
}
