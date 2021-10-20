package com.liu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.model.entity.BmsBillboard;
import com.liu.model.entity.BmsTip;
import org.springframework.stereotype.Repository;

/**
 * @author liumiao
 * @create 2021-10-16-8:56
 */
@Repository
public interface BmsTipMapper extends BaseMapper<BmsTip> {

    BmsTip getRandomTip();
}
