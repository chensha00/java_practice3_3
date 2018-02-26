package dao;

import com.mysql.cj.api.mysqla.result.Resultset;
import common.util.DataSourceUtils;
import entity.OrderInfo;
import entity.UserAccount;
import tool.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    /**
     * @Title: findOrderByCondtion
     * @Description: 根据条件查询
     * @author zhengxin
     * @date 2018/1/29/029
     * @param stringObjectMap
     * @return List<OrderInfo>
     *
     */
    @Override
    public List<UserAccount> findUserAccountByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<UserAccount> userAccountList=new ArrayList<UserAccount>();
        String key="";
        String value="";
        //取出map中的键值对
        Set<Map.Entry<String, String>> set = stringObjectMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            key=entry.getKey();
            value=entry.getValue();
        }
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_NAME,USER_ACCOUNT_PASSWORD,PAYING_PASSWORD,MONEY,REGIST_TIME,IS_BUYER,IS_FREEZING,IS_LOST,IS_DELETE FROM user_account WHERE "+key+"="+value);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            UserAccount user=new UserAccount();
            user.setId(resultSet.getLong("ID"));
            user.setUserAccountName(resultSet.getString("USER_ACCOUNT_NAME"));
            user.setUserAccountPassWord(resultSet.getString("USER_ACCOUNT_PASSWORD"));
            user.setPayingPassWord(resultSet.getString("PAYING_PASSWORD"));
            user.setMoney(resultSet.getDouble("MONEY"));
            user.setRegisterTime(resultSet.getDate("REGIST_TIME"));
            user.setIsBuyer(resultSet.getByte("IS_BUYER"));
            user.setIsFreezing(resultSet.getByte("IS_FREEZING"));
            user.setIsLost(resultSet.getByte("IS_LOST"));
            user.setIsDelete(resultSet.getByte("IS_DELETE"));

            userAccountList.add(user);
        }
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);


        return userAccountList;
    }

}