package com.mic.service;

import bo.UserBO;
import com.mic.pojo.Users;

public interface UserService {

    /**
     * 查询用户是否存在
     * @param name
     * @return
     */
    public boolean queryUserIsExist(String username);

    /**
     * 创建用户
     * @param userBo
     * @return
     */
    public Users createUser(UserBO userBo);
}
