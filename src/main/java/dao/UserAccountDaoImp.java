package dao;

import com.mysql.cj.api.mysqla.result.Resultset;
import entity.UserAccount;
import tool.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujunnan
 * @ClassName UserAccountDaoImp
 * @Description 类描述
 * @date 2018/1/30
 */
public class UserAccountDaoImp implements UserAccountDao{
    private static DbUtil dbUtil = new DbUtil();
    //定义一个接收用户数据的用户
    private UserAccount account = null;
    //定义数据库连接
    private Connection conn = null;
    //定义预编译
    private PreparedStatement ps = null;
    /**
     * @Title: findByName
     * @Description: 实现根据用户名查询用户
     * @author WuJunNan
     * @param userName 用户名
     * @return 返回用户信息
     */
    @Override
    public UserAccount findByName(String userName){
        try {
            //sql语句
            String sql = "SELECT USER_ACCOUNT_NAME,USER_ACCOUNT_PASSWORD FROM USER_ACCOUNT WHERE USER_ACCOUNT_NAME = ?";
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                //获取用户名
                String userAccountName = rs.getString("USER_ACCOUNT_NAME");
                //获取密码
                String userAccountPassword = rs.getString("USER_ACCOUNT_PASSWORD");
                account = new UserAccount(userAccountName,userAccountPassword);
            }
            //返回用户
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                //关闭数据库连接
                dbUtil.close(ps,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @Title: addUser
     * @Description: 实现添加用户
     * @author WuJunNan
     * @param userAccount 用户
     */
    @Override
    public void addUser(UserAccount userAccount) {
        try {
            //sql语句
            String sql = "INSERT INTO USER_ACCOUNT(USER_ACCOUNT_NAME,USER_ACCOUNT_PASSWORD) VALUES (?,?)";
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,userAccount.getUserAccountName());
            ps.setString(2,userAccount.getUserAccountPassWord());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭数据库连接
                dbUtil.close(ps,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}