package service;

import common.util.DataSourceUtils;
import dao.StoreDao;
import dao.StoreDaoImpl;
import entity.Store;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author xiaogaoqing
 * @ClassName StoreServiceImpl
 * @Description 类描述
 * @date 2018/1/29
 */
public class StoreServiceImpl implements StoreService {
    static StoreDao storeDao=new StoreDaoImpl();

    /**
     * @Title: deleteStoreById
     * @Description: 实现删除一条商品数据
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param id 传入一个要删除的id
     */
    public void  deleteStoreById(Long id) {
        //定义数据库连接
        Connection connection=null;
        //定义预编译的SQL语句
        PreparedStatement preparedStatement=null;
        //定义新的连接池
        DataSourceUtils dataSource=new DataSourceUtils();
        //定义新的变量接收dao层受影响的行数
        Integer rows=null;

        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //rows接收dao层返回的受影响的行数并输出
            rows=storeDao.deleteStoreById(id,connection,preparedStatement,dataSource);
            System.out.println(rows);

        } catch (SQLException e) {
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * @Title: deleteStoreById
     * @Description: 实现删除多条商品类型数据
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param ids 传入一个要删除的id数组
     */
    public void deleteStoreByIds(Long[] ids) {

        //定义数据库连接
        Connection connection=null;
        //定义预编译的SQL语句
        PreparedStatement preparedStatement=null;
        //定义新的连接池
        DataSourceUtils dataSource=new DataSourceUtils();
        //定义新的变量接收dao层受影响的行数
        Integer rows=null;
        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //rows接收dao层返回的受影响的行数并输出
            rows=storeDao.deleteStoreByIds(ids,connection,preparedStatement,dataSource);
            System.out.println(rows);

        } catch (SQLException e) {
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    /**
     * @Title: saveOrUpdateStore
     * @Description: 实现添加更新商铺数据
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param store 传入一个要更新的商品类型数据
     */
    public void saveOrUpdateStore(Store store) {
        //定义数据库连接
        Connection connection=null;
        //定义预编译的SQL语句
        PreparedStatement preparedStatement=null;
        //定义新的连接池
        DataSourceUtils dataSource=new DataSourceUtils();
        //定义新的变量接收dao层受影响的行数
        Integer rows=null;
        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //rows接收dao层返回的受影响的行数并输出
            rows=storeDao.saveOrUpdateStore(store,connection,preparedStatement,dataSource);
            System.out.println(rows);

        } catch (SQLException e) {
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    /**
     * @Title: findStoreById
     * @Description: 根据ID实现商品类型数据查询
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param id 传入一个查询的ID
     */
    public Store findStoreById(Long id) {
        //定义数据库连接
        Connection connection= null;
        // 定义预编译sql语句
        PreparedStatement preparedStatement = null;
        //定义新的连接池
        DataSourceUtils dataSource = new DataSourceUtils();
        try {
            connection=dataSource.getConnection();
            return storeDao.findStoreById(id,connection,preparedStatement,dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void  findStoreByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) {

    }
}