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

    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username,String password);
}
