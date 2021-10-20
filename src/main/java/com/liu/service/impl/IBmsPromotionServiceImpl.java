package com.liu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.mapper.BmsPromotionMapper;
import com.liu.model.entity.BmsPromotion;
import com.liu.service.IBmsPromotionService;
import org.springframework.stereotype.Service;

/**
 * @author liumiao
 * @create 2021-10-16-9:49
 */
@Service
public class IBmsPromotionServiceImpl extends ServiceImpl<BmsPromotionMapper, BmsPromotion>
                    implements IBmsPromotionService {
}
