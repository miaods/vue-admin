package com.liu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.model.entity.BmsTip;

/**
 * @author liumiao
 * @create 2021-10-16-9:02
 */

public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}
