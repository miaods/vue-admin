package com.liu.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.mapper.BmsTipMapper;
import com.liu.model.entity.BmsTip;
import com.liu.service.IBmsTipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liumiao
 * @create 2021-10-16-9:05
 */
@Slf4j
@Service
public class IBmsTipServiceImpl extends ServiceImpl<BmsTipMapper,BmsTip>
                   implements IBmsTipService{

    @Override
    public BmsTip getRandomTip() {
        BmsTip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        } catch (Exception e) {
            log.info("tip转化失败");
        }
        return todayTip;

    }
}
