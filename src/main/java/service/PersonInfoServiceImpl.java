package service; /**
 * @Project: java_practice - 副本
 * @Package service
 * @author jiangxiangwen
 * @date 2018/1/29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.DataSourceUtils;
import dao.PersonInfoDao;
import dao.PersonInfoDaoImpl;
import entity.PersonInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author jiangxiangwen
 * @ClassName PersonInfoServiceImpl
 * @Description 人员信息service层接口实现
 * @date 2018/1/29
 */
public class PersonInfoServiceImpl implements PersonInfoService {
    static PersonInfoDao personInfoDao=new PersonInfoDaoImpl();
    /**
     * @param id 主键id
     * @return 返回收影响的行数
     * @Title: deleteTestById
     * @Description: 删除一行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     */
    @Override
    public Integer deletePersonInfoById(Long id) {
        // mysql连接语句
        Connection connection = null;
        // 预编译的sql操作语言
        PreparedStatement preparedStatement = null;
        // 创建自定义连接池对象
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        Integer rows = null;
        try {
            // 从连接池中取出连接对象
            connection = dataSourceUtils.getConnection();
            // 将连接对象的自动提交设为false
            connection.setAutoCommit(false);
            // 调用dao层的方法，并返回受影响的行数
             rows = personInfoDao.deletePersonInfoById(id, connection, preparedStatement,dataSourceUtils);
        } catch (SQLException e) {
            try {
                // 异常时,事物回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                // 关闭预编译的操作指令
                preparedStatement.close();
                // 关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 返回受影响的行数
        return rows;
    }

    /**
     * @param ids 主键id集合
     * @return 返回收影响的行数
     * @Title: deleteTestByIds
     * @Description: 删除多行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     */
    @Override
    public Integer deletePersonInfoByIds(Long[] ids) {
        // mysql连接语句
        Connection connection = null;
        // 预编译的sql操作语言
        PreparedStatement preparedStatement = null;
        // 创建自定义连接池对象
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        Integer rows = null;
        try {
            // 从连接池中取出连接对象
            connection = dataSourceUtils.getConnection();
            // 将连接对象的自动提交设为false
            connection.setAutoCommit(false);
            // 调用dao层的方法，并返回受影响的行数
            rows = personInfoDao.deletePersonInfoByIds(ids, connection, preparedStatement,dataSourceUtils);
        } catch (SQLException e) {
            try {
                // 异常时,事物回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                // 关闭预编译的操作指令
                preparedStatement.close();
                // 关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 返回受影响的行数
        return rows;
    }

    /**
     * @param personInfo 人员信息
     * @return 返回收影响的行数
     * @Title: saveOrUpdateTest
     * @Description: 添加或更新数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     */
    @Override
    public Integer saveOrUpdatePersonInfo(PersonInfo personInfo) {
        // mysql连接语句
        Connection connection = null;
        // 预编译的sql操作语言
        PreparedStatement preparedStatement = null;
        // 创建自定义连接池对象
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        Integer rows = null;
        try {
            // 从连接池中取出连接对象
            connection = dataSourceUtils.getConnection();
            // 将连接对象的自动提交设为false
            connection.setAutoCommit(false);
            // 调用dao层的方法，并返回受影响的行数
            rows = personInfoDao.saveOrUpdatePersonInfo(personInfo, connection, preparedStatement,dataSourceUtils);
        } catch (SQLException e) {
            try {
                // 异常时,事物回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                // 关闭预编译的操作指令
                preparedStatement.close();
                // 关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 返回受影响的行数
        return rows;
    }

    /**
     * @param id 主键id
     * @return 返回查询的对象
     * @Title: findTestById
     * @Description: 查询数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     */
    @Override
    public PersonInfo findPersonInfoById(Integer id) {
        // mysql连接语句
        Connection connection = null;
        // 预编译的sql操作语言
        PreparedStatement preparedStatement = null;
        // 创建自定义连接池对象
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        PersonInfo personInfo = null;
        try {
            // 从连接池中取出连接对象
            connection = dataSourceUtils.getConnection();
            // 调用dao层的方法，并返回受影响的行数
            personInfo = personInfoDao.findPersonInfoById(id, connection, preparedStatement,dataSourceUtils);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭预编译的操作指令
                preparedStatement.close();
                // 关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        // 返回PersonInfo对象
        return personInfo;
    }

    /**
     * @param stringObjectMap 查询数据的键值对
     * @return 返回查询的对象的集合
     * @Title: findTestByCondtionForPage
     * @Description: 带分页功能的查询多条数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     */
    @Override
    public List<PersonInfo> findPersonInfoByCondtionForPage(Map<String, String> stringObjectMap) {
        // 声明mysql连接
        Connection connection = null;
        // 声明预编译的sql操作
        PreparedStatement preparedStatement = null;
        // 创建自定义连接池对象
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        // 声明list集合
        List<PersonInfo> personInfoList = null;
        try {
            // 从连接池中取出连接对象
            connection = dataSourceUtils.getConnection();
            // 调用dao层的方法，并返回受影响的行数
            personInfoList = personInfoDao.findPersonInfoByCondtionForPage(stringObjectMap, connection, preparedStatement,dataSourceUtils);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭预编译的操作指令
                preparedStatement.close();
                // 关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personInfoList;
    }
}

