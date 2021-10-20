package com.liu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.model.entity.BmsComment;
import com.liu.model.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liumiao
 * @create 2021-10-16-20:06
 */
public interface BmsCommentMapper extends BaseMapper<BmsComment> {

    /**
     * getCommentsByTopicID
     *
     * @param topicid
     * @return
     */
    List<CommentVO> getCommentsByTopicID(@Param("topicid") String topicid);
}


