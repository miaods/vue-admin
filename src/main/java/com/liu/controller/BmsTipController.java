package com.liu.controller;

import com.liu.common.api.ApiResult;
import com.liu.model.entity.BmsTip;
import com.liu.service.IBmsTipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liumiao
 * @create 2021-10-16-9:14
 */

/*每日一句*/

@RestController
@RequestMapping("tip")
public class BmsTipController extends BaseController {
    @Resource
    private IBmsTipService bmsTipService;

    @GetMapping("/today")
    public ApiResult<BmsTip> getRandomTip() {
        BmsTip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }
}
