package dao;

import common.util.DataSourceUtils;
import entity.OrderInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author zhengxin
 * @InterfaceName OrderInfoDao
 * @Description OrderInfoDao接口
 * @date 2018/1/29/029
 */
public interface OrderInfoDao {
    /**
     * @Title: saveOrUpdateOrderById
     * @Description: 插入或修改
     * @author zhengxin
     * @date 2018/1/29/029
     * @param orderInfo
     * @return Integer
     * @throws SQLException
     *
     */
    public Integer saveOrUpdateOrderById(OrderInfo orderInfo, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException;
    /**
     * @Title: deleteOrderById
     * @Description: 删除
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id
     * @return  Integer 受影响的行ID
     * @throws SQLException
     *
     */
    public Integer deleteOrderById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException;
    /**
     * @Title: findOrderById
     * @Description: 方法
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id
     * @return  OrderInfo
     * @throws SQLException
     *
     */
    public OrderInfo findOrderById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException;
    /**
     * @Title: deleteOrderByIds
     * @Description: 按多个ID删除
     * @author zhengxin
     * @date 2018/1/29/029
     * @param integers ID数组
     * @return  Integer
     * @throws SQLException
     *
     */
    public Integer deleteOrderByIds(Integer[] integers, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException;
    /**
     * @Title: findTestByCondtion
     * @Description: 条件查询
     * @author zhengxin
     * @date 2018/1/29/029
     * @param stringObjectMap
     * @return OrderInfo
     *
     */
    public List<OrderInfo> findOrderByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException;

}
