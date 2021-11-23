package com.mic.controller;

import bo.UserBO;
import com.mic.pojo.Users;
import com.mic.service.UserService;
import com.mic.utils.FimJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/userIsExist")
    public FimJSONResult userIsExist(@RequestParam String username) {

        //1.判断用户名不能为空
        if (StringUtils.isBlank(username)) {
//            return  500;
//              return HttpStatus.INTERNAL_SERVER_ERROR;
            return FimJSONResult.errorMsg("用户名不能为空");
        }
        //2.查找注册的用户名是否存在
        boolean isExist = userService.queryUserIsExist(username);
        if (isExist) {
            return FimJSONResult.errorMsg("用户名已经存在");
        }
        //请求成功，用户名没有重复
        return FimJSONResult.ok();
    }

//    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public FimJSONResult regist(@RequestBody UserBO userBO) {

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return FimJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean isExist = userService.queryUserIsExist(username);
        if (isExist) {
            return FimJSONResult.errorMsg("用户名已经存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return FimJSONResult.errorMsg("密码长度不能少于6");
        }

        // 3. 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return FimJSONResult.errorMsg("两次密码输入不一致");
        }

        // 4. 实现注册
        Users userResult = userService.createUser(userBO);

//        userResult = setNullProperty(userResult);

//        CookieUtils.setCookie(request, response, "user",
//                JsonUtils.objectToJson(userResult), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return FimJSONResult.ok();
    }
}