package service;

import common.util.DataSourceUtils;
import dao.OrderInfoDao;
import dao.OrderInfoDaoImpl;
import entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @author zhengxin
 * @ClassName OrderInfoServiceImpl
 * @Description OrderInfoService实现
 * @date 2018/1/29/029
 */
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    // 设置一个静态的OrderInfo
    static OrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
    /**
         * @Title: saveOrUpdateOrderById
         * @Description: 根据ID添加或者更新
         * @author zhengxin
         * @date 2018/1/29/029
         * @param orderInfo
         * @return rows 受影响的行数
         *
         */
    @Override
    public Integer saveOrUpdateOrderById(OrderInfo orderInfo) {
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
            connection= dataSource.getConnection();
            // 关闭自动提交
            connection.setAutoCommit(false);
            // 调用dao层的orderInfo的实现类
            rows=orderInfoDao.saveOrUpdateOrderById(orderInfo,connection,preparedStatement,dataSource);
            //打印收影响的行数
            System.out.println(rows);
        } catch (SQLException e) {
            try {
                //事物回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return rows;
    }
    /**
     * @Title: deleteOrderById
     * @Description: 根据ID删除
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id
     * @return rows 受影响的行数
     *
     */
    @Override
    public Integer deleteOrderById(Long id) {
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
            // 关闭自动提交
            connection.setAutoCommit(false);
            // 调用dao层的orderInfo的实现类
            rows = orderInfoDao.deleteOrderById(id, connection, preparedStatement,dataSource);
            //打印收影响的行数
            System.out.println(rows);
        } catch (SQLException e) {
            try {
                //事物回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return rows;
    }
    /**
     * @Title: findOrderById
     * @Description: 根据ID查找
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id
     * @return orderInfo 订单
     *
     */
    @Override
    public OrderInfo findOrderById(Long id) {
        // 空的连接
        Connection connection = null;
        // 预编译的sql操作语言
        PreparedStatement preparedStatement = null;
        // 创建自定义连接池对象
        DataSourceUtils dataSource = new DataSourceUtils();

        try {
            // 从连接池中拿到一个连接对象
            connection=dataSource.getConnection();
            // 关闭自动提交
            connection.setAutoCommit(false);
            // 调用dao层的orderInfo的实现类
            return orderInfoDao.findOrderById(id,connection,preparedStatement,dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * @Title: deleteOrderByIds
     * @Description: 根据ID批量删除
     * @author zhengxin
     * @date 2018/1/29/029
     * @param integers
     * @return rows 受影响的行数
     *
     */
    @Override
    public Integer deleteOrderByIds(Integer[] integers) {
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
            // 关闭自动提交
            connection.setAutoCommit(false);
            // 调用dao层的orderInfo的实现类
            rows = orderInfoDao.deleteOrderByIds(integers, connection, preparedStatement,dataSource);
            //打印收影响的行数
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
        return rows;
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
    public List<OrderInfo> findOrderByCondtion(Map<String, String> stringObjectMap) {
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
            // 关闭自动提交
            connection.setAutoCommit(false);
            // 调用dao层的orderInfo的实现类，传入一个订单，一个连接，一个操作对象
            return orderInfoDao.findOrderByCondtion(stringObjectMap, connection, preparedStatement,dataSource);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

}
