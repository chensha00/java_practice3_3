package dao;

import common.util.DataSourceUtils;
import entity.UserAccount;
import tool.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author wujunnan
 * @ClassName UserDao
 * @Description 类描述
 * @date 2018/1/30
 */
public interface UserAccountDao {
    /**
     * @Title: findByName
     * @Description: 实现根据用户名查询用户
     * @author WuJunNan
     * @param userName 用户名
     * @return 返回用户信息
     */
    UserAccount findByName(String userName);
    /**
     * @Title: addUser
     * @Description: 实现添加用户
     * @author WuJunNan
     * @param userAccount 用户
     */
    void addUser(UserAccount userAccount);

    List<UserAccount> findUserAccountByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSource) throws SQLException;
}