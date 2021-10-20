package com.liu.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.liu.common.api.ApiResult;
import com.liu.model.dto.LoginDTO;
import com.liu.model.dto.RegisterDTO;
import com.liu.model.entity.UmsUser;
import com.liu.service.IBmsPostService;
import com.liu.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.liu.jwt.JwtUtil.USER_NAME;

/**
 * @author liumiao
 * @create 2021-10-16-10:32
 */
@RestController
@RequestMapping("/ums/user")
public class UmsUserController {

    @Resource
    private IUmsUserService iUmsUserService;
    @Resource
    private IBmsPostService iBmsPostService;

/*注册*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        UmsUser user = iUmsUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        return ApiResult.success(map);
    }

/*登录*/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = iUmsUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

/*登录成功展示主页*/
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<UmsUser> getUser(@RequestHeader(value = USER_NAME) String userName) {
       // System.out.println("哈哈哈哈"+userName);
        UmsUser user = iUmsUserService.getUserByUsername(userName);
        return ApiResult.success(user);

    }

/*退出登录*/
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult<Object> logOut() {
        return ApiResult.success(null, "注销成功");
    }

}
