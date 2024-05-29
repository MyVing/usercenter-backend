package com.ving.usercenter.service;
import java.util.Date;

import com.ving.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @Author ving
 * @Date 2024/1/26 19:08
 */

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("dogVing");
        user.setUserAccount("123");
        user.setAvatarUrl("https://p.qqan.com/up/2021-1/16099110527325895.jpg");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "ving";
        String userPassword = "";
        String checkPassword = "123456";
        String schoolCode = "312200463";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,schoolCode);
        Assertions.assertEquals(-1,result);
        userAccount = "vi";
        result = userService.userRegister(userAccount,userPassword,checkPassword,schoolCode);
        Assertions.assertEquals(-1,result);
        userAccount = "ving";
        userPassword = "123456";
        result = userService.userRegister(userAccount,userPassword,checkPassword,schoolCode);
        Assertions.assertEquals(-1,result);
        userAccount = " v i n g";
        userPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword,schoolCode);
        Assertions.assertEquals(-1, result);
        checkPassword = "123456789";
        result = userService.userRegister(userAccount,userPassword,checkPassword,schoolCode);
        Assertions.assertEquals(-1,result);
        userAccount = "dogVing";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword,schoolCode);
        Assertions.assertEquals(-1,result);
        userAccount = "ving";
        result = userService.userRegister(userAccount,userPassword,checkPassword,schoolCode);
        Assertions.assertEquals(-1,result);

    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1L);
        user.setUsername("testVing");
        user.setUserAccount("123");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        user.setUserStatus(0);
        boolean res = userService.updateById(user);
        Assertions.assertTrue(res);


    }

}