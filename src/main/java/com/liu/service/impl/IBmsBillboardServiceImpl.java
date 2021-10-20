package com.liu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.mapper.BmsBillboardMapper;
import com.liu.model.entity.BmsBillboard;
import com.liu.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

/**
 * @author liumiao
 * @create 2021-10-15-22:42
 */

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper, BmsBillboard> implements IBmsBillboardService {
}
