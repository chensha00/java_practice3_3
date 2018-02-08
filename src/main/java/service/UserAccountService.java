package service;

import entity.UserAccount;
import tool.NameException;
import tool.PasswordException;

/**
 * @author wujunnan
 * @ClassName UserAccountService
 * @Description 用户服务层接口
 * @date 2018/1/30
 */
public interface UserAccountService {
    /**
     * @Title: login
     * @Description: 登录方法接口
     * @author WuJunNan
     * @return 返回一个用户
     * @param userName 用户名
     * @param passWord 密码
     */
    UserAccount login(String userName,String passWord)
            throws NameException, PasswordException;
    /**
     * @Title: register
     * @Description: 注册方法接口
     * @author WuJunNan
     * @return 返回一个用户
     * @param userName 用户名
     * @param passWord 密码
     */
    UserAccount register(String userName,String passWord,String repeatPwd)
            throws NameException,PasswordException;
}