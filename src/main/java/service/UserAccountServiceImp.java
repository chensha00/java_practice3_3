package service;

import common.util.DataSourceUtils;
import dao.UserAccountDao;
import dao.UserAccountDaoImp;
import entity.OrderInfo;
import entity.UserAccount;
import tool.NameException;
import tool.PasswordException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author wujunnan
 * @ClassName UserAccountServiceImp
 * @Description 类描述
 * @date 2018/1/30
 */
public class UserAccountServiceImp implements UserAccountService{
    private UserAccountDao userAccountDao = new UserAccountDaoImp();
    /**
     * @Title: login
     * @Description: 实现业务层登录方法
     * @author WuJunNan
     * @return 返回一个用户
     * @param userName 用户名
     * @param passWord 密码
     */
    @Override
    public UserAccount login(String userName, String passWord) throws NameException, PasswordException {
        if (userName==null||userName.trim().isEmpty()){
            System.out.println("用户名不能为空");
        }
        if (passWord==null||passWord.trim().isEmpty()){
            System.out.println("密码不能为空");
        }
        //调用userAccountDao，根据用户名查找用户
        UserAccount userAccount = userAccountDao.findByName(userName);
        //判断用户是否存在
        if (userAccount==null){
            System.out.println("用户不存在");
        }
        //验证密码
        if (userAccount.getUserAccountPassWord().equals(passWord)){
            return userAccount;
        }else{
            System.out.println("密码错误");
            return null;
        }
    }
    /**
     * @Title: register
     * @Description: 注册方法接口
     * @author WuJunNan
     * @return 返回一个用户
     * @param userName 用户名
     * @param passWord 密码
     */
    @Override
    public UserAccount register(String userName, String passWord,String repeatPwd) throws NameException, PasswordException {
        //调用dao层的用户名查询方法,返回一个用户对象
        UserAccount userAccount = userAccountDao.findByName(userName);
        //用户名与传入的参数对比,如果相等就提示用户帐号已被注册
        if (userAccount!=null || userName==userAccount.getUserAccountName()){
            throw new NameException("帐号已被注册");
        }
        //检测格式
        if(userName==null||userName.trim().isEmpty()){
            throw new NameException("用户名为空");
        }
        //判断密码
        if(passWord==null||passWord.trim().isEmpty()){
            throw new PasswordException("密码为空");
        }
        if (repeatPwd==passWord){
            //创建新用户
            userAccount = new UserAccount(userName,passWord);
            //调用addDao插入数据库
            userAccountDao.addUser(userAccount);
            System.out.println("注册成功");
            //返回新用户
        }
        return userAccount;
    }

    @Override
    public List<UserAccount> findUserAccountByCondtion(Map<String, String> stringObjectMap){
        // 空的连接
        Connection connection=null;
        // 预编译的sql操作语言
        PreparedStatement preparedStatement=null;
        // 创建自定义连接池对象
        DataSourceUtils dataSource = new DataSourceUtils();
        // 设置受影响的行数
        Integer rows=null;

        try {
            // 从连接池中拿到一个连接对象
            connection=dataSource.getConnection();

            // 调用dao层的orderInfo的实现类，传入一个订单，一个连接，一个操作对象
            return userAccountDao.findUserAccountByCondtion(stringObjectMap, connection, preparedStatement,dataSource);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}