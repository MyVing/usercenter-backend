package com.ving.usercenter.service;

import com.ving.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务
 *
* @author ving
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-01-26 18:56:04
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param schoolCode  学号
     * @return 新用户id
     */
    long userRegister(String userAccount,String userPassword, String checkPassword,String schoolCode);

    /**
     * 用户登陆
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     *  根据用户名查询用户
     *
     * @param username
     * @return
     */
    List<User> searchUsers(String username,HttpServletRequest request);


    /**
     * 根据id删除用户
     *
     * @param id
     * @param request
     * @return
     */
    Boolean removeById(long id, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
