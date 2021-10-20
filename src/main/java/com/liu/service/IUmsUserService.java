package com.liu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.model.dto.LoginDTO;
import com.liu.model.dto.RegisterDTO;
import com.liu.model.entity.UmsUser;
import com.liu.model.vo.ProfileVO;
import org.springframework.stereotype.Repository;

/**
 * @author liumiao
 * @create 2021-10-16-10:19
 */
public interface IUmsUserService extends IService<UmsUser> {
    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    UmsUser executeRegister(RegisterDTO dto);
    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    UmsUser getUserByUsername(String username);
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);
    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);
}
