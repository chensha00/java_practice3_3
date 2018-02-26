package dao; /**
 * @Project: java_practice
 * @Package dao
 * @author jiangxiangwen
 * @date 2018/1/29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.DataSourceUtils;
import entity.PersonInfo;
import entity.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author jiangxiangwen
 * @ClassName PersonInfoDaoImpl
 * @Description 类的描述
 * @date 2018/1/29
 */
public class PersonInfoDaoImpl implements PersonInfoDao {
    /**
     * @Title: deleteTestById
     * @Description: 删除一行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id    主键id
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return  返回收影响的行数
     * @throws SQLException
     */
    @Override
    public Integer deletePersonInfoById(Long id,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM PERSON_INFO WHERE ID=?");
        // 设置id
        preparedStatement.setLong(1,id);
        // 执行SQL语句，得到受影响的函数
        int rows=preparedStatement.executeUpdate();
        // 提交
        connection.commit();
        // 关闭预编译语句
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);
        // 返回受影响的行
        return rows;
    }

    /**
     * @Title: deleteTestByIds
     * @Description: 删除多行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param ids 主键id集合
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return 返回收影响的行数
     * @throws SQLException
     */
    @Override
    public Integer deletePersonInfoByIds(Long[] ids,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException {
        // 声明收影响的行数
        Integer rows=null;
        // 根据ids的长度来循环执行删除语句
        for(int i=0;i<ids.length;i++) {
            // 设置要执行的sql
            preparedStatement = connection.prepareStatement("DELETE FROM PERSON_INFO WHERE ID=?");
            // 设置id字段的值
            preparedStatement.setLong(1, ids[i]);
            // 记录返回的行数
            rows += preparedStatement.executeUpdate();
            // 提交
            connection.commit();
        }
        // 关闭预编译语句
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);
        // 返回受影响的行
        return rows;
    }

    /**
     * @Title: saveOrUpdateTest
     * @Description: 添加或更新数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param personInfo 人员信息
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return 返回收影响的行数
     * @throws SQLException
     */
    @Override
    public Integer saveOrUpdatePersonInfo(PersonInfo personInfo, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        // 声明收影响的行数
        Integer rows=null;
        //判断传进来的personInfo对象的id是否为空，若为空执行添加语句，不为空执行更新语句
        if (personInfo.getId() == null){
            preparedStatement = connection.prepareStatement("INSERT INTO PERSON_INFO(USER_ACCOUNT_ID,IDENTITY_CARD,NAME,AGE,SEX) VALUES (?,?,?,?,?)");
        // 用户账户id
        preparedStatement.setLong(1, personInfo.getUserAccountId());
        // 用户的身份证号
        preparedStatement.setString(2, personInfo.getIdEntityCard());
        // 用户的名字
        preparedStatement.setString(3, personInfo.getName());
        // 用户的年龄
        preparedStatement.setInt(4, personInfo.getAge());
        // 用户的性别
        preparedStatement.setByte(5, personInfo.getSex());
        // 返回受影响的行数
         rows = preparedStatement.executeUpdate();
        }else{
            preparedStatement=connection.prepareStatement("UPDATE PERSON_INFO SET USER_ACCOUNT_ID=?,IDENTITY_CARD=?,`NAME`=?,AGE=?,SEX=? WHERE ID=?");
            // 用户账户id
            preparedStatement.setLong(1, personInfo.getUserAccountId());
            // 用户的身份证号
            preparedStatement.setString(2, personInfo.getIdEntityCard());
            // 用户的名字
            preparedStatement.setString(3, personInfo.getName());
            // 用户的年龄
            preparedStatement.setInt(4, personInfo.getAge());
            // 用户的性别
            preparedStatement.setByte(5, personInfo.getSex());
            // id
            preparedStatement.setLong(6,personInfo.getId());
            // 返回受影响的行数
            rows = preparedStatement.executeUpdate();
        }
        // 提交
        connection.commit();
        // 关闭预编译语句
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);
        // 返回受影响的行
        return rows;

    }

    /**
     * @Title: findTestById
     * @Description: 查询数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id 主键id
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return 返回查询的对象
     * @throws SQLException
     */
    @Override
    public PersonInfo findPersonInfoById(Integer id,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException {
        PersonInfo personInfo=new PersonInfo();
        // 数据库连接操作
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,IDENTITY_CARD,NAME,AGE,SEX FROM PERSON_INFO WHERE ID=?");
        // 设置根据ID查询人员
        preparedStatement.setLong(1,id);
        //执行查询语句
        ResultSet resultSet=preparedStatement.executeQuery();

        //遍历resultSet的值
        while (resultSet.next()) {
            // id 主键
            personInfo.setId(resultSet.getLong("ID"));
            // 账户表的id  外键
            personInfo.setUserAccountId(resultSet.getLong("USER_ACCOUNT_ID"));
            // 身份证号
            personInfo.setIdEntityCard(resultSet.getString("IDENTITY_CARD"));
            // 姓名
            personInfo.setName(resultSet.getString("NAME"));
            // age 年龄
            personInfo.setAge(resultSet.getInt("AGE"));
            // sex 性别 0 -男，1 -女
            personInfo.setSex(resultSet.getByte("SEX"));
        }
        // 关闭预编译的操作
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);

        return personInfo;
    }

    /**
     * @Title: findTestByCondtionForPage
     * @Description: 带分页功能的查询多条数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param map       *******按照对应的数据表来写，应该是传入一个Map集合，根据集合里的对象查数据
     * @return 返回查询的对象的集合
     * @throws SQLException
     */
    @Override
    public List<PersonInfo> findPersonInfoByCondtionForPage(Map<String,String> map,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException {
        List<PersonInfo> personInfoList=new ArrayList<PersonInfo>();
        String key="";
        String value="";
        //取出map中的键值对
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            key=entry.getKey();
            value=entry.getValue();
        }
        // 数据库连接操作
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,IDENTITY_CARD,NAME,AGE,SEX FROM PERSON_INFO WHERE "+key+"="+value );

        //执行查询语句
        ResultSet resultSet=preparedStatement.executeQuery();

        //遍历resultSet的值
        while (resultSet.next()) {
            PersonInfo personInfo=new PersonInfo();
            // id 主键
            personInfo.setId(resultSet.getLong("ID"));
            // 账户表的id  外键
            personInfo.setUserAccountId(resultSet.getLong("USER_ACCOUNT_ID"));
            // 身份证号
            personInfo.setIdEntityCard(resultSet.getString("IDENTITY_CARD"));
            // 姓名
            personInfo.setName(resultSet.getString("NAME"));
            // age 年龄
            personInfo.setAge(resultSet.getInt("AGE"));
            // sex 性别 0 -男，1 -女
            personInfo.setSex(resultSet.getByte("SEX"));

            personInfoList.add(personInfo);
        }
        // 关闭预编译的操作
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);
        return personInfoList;
    }
}
