package dao;

import common.util.DataConvertService;
import common.util.DataSourceUtils;
import entity.OrderInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author zhengxin
 * @ClassName OrderInfoDaoImpl
 * @Description OrderInfoDao实现
 * @date 2018/1/29/029
 */
public class OrderInfoDaoImpl implements OrderInfoDao {
    /**
         * @Title: saveOrUpdateOrderById
         * @Description: 根据ID添加或者更新订单
         * @author zhengxin
         * @date 2018/1/29/029
         * @param orderInfo,connection,preparedStatement,dataSourceUtils
         * @return  rows 受影响的行数
         * @throws  SQLException
         *
         */
    @Override
    public Integer saveOrUpdateOrderById(OrderInfo orderInfo, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)  throws SQLException {
        Integer rows=0;
        if (orderInfo.getId()==null){
            preparedStatement=connection.prepareStatement("INSERT INTO order_info(ID,ORDER_NUM,ORDER_STATUS,BUYER_USER_ACCOUNT_ID,STORE_ID,GOODS_INFO,GOODS_SUM_MONEY,ORDER_TIME,DELIVER_TIME,SUCCESS_TIME,IS_CANCELLATION)VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?)");

            // 订单编号
            preparedStatement.setString(1,orderInfo.getOrderNum());
            //订单状态
            preparedStatement.setByte(2,orderInfo.getOrderStatus());
            //买家信息
            preparedStatement.setLong(3,orderInfo.getBuyerUserAccountId());
            //卖家信息
            preparedStatement.setLong(4,orderInfo.getStoreId());
            //商品信息
            preparedStatement.setString(5,orderInfo.getGoodsInfo());
            //购买商品总金额
            preparedStatement.setDouble(6,orderInfo.getGoodsSumMoney());
            //下单时间
            preparedStatement.setString(7,new DataConvertService().dateyMdHms(orderInfo.getOrderTime()));
            //交易成功时间
            preparedStatement.setString(8,new DataConvertService().dateyMdHms(orderInfo.getSuccessTime()));
            //发货时间
            preparedStatement.setString(9,new DataConvertService().dateyMdHms(orderInfo.getDeliverTime()));
            //订单是否作废
            preparedStatement.setBoolean(10,orderInfo.getCancellation());

            rows=preparedStatement.executeUpdate();
            connection.commit();
            // 回收连接
            dataSourceUtils.backConnection(connection);
            preparedStatement.close();
            System.out.println("新增：");
        }else if(orderInfo.getId()!=null){
            preparedStatement=connection.prepareStatement("UPDATE order_info SET ORDER_NUM=?,ORDER_STATUS=?,BUYER_USER_ACCOUNT_ID=?,STORE_ID=?,GOODS_INFO=?,GOODS_SUM_MONEY=?,ORDER_TIME=?,DELIVER_TIME=?,SUCCESS_TIME=?,IS_CANCELLATION=? WHERE ID =?");

            // 订单编号
            preparedStatement.setString(1,orderInfo.getOrderNum());
            //订单状态
            preparedStatement.setByte(2,orderInfo.getOrderStatus());
            //买家信息
            preparedStatement.setLong(3,orderInfo.getBuyerUserAccountId());
            //卖家信息
            preparedStatement.setLong(4,orderInfo.getStoreId());
            //商品信息
            preparedStatement.setString(5,orderInfo.getGoodsInfo());
            //购买商品总金额
            preparedStatement.setDouble(6,orderInfo.getGoodsSumMoney());
            //下单时间
            preparedStatement.setString(7,new DataConvertService().dateyMdHms(orderInfo.getOrderTime()));
            //交易成功时间
            preparedStatement.setString(8,new DataConvertService().dateyMdHms(orderInfo.getSuccessTime()));
            //发货时间
            preparedStatement.setString(9,new DataConvertService().dateyMdHms(orderInfo.getDeliverTime()));
            //订单是否作废
            preparedStatement.setBoolean(10,orderInfo.getCancellation());
            //订单ID
            preparedStatement.setLong(11,orderInfo.getId());

            rows=preparedStatement.executeUpdate();
//        JdbcUtils.release();
            connection.commit();
            // 回收连接
            dataSourceUtils.backConnection(connection);
            preparedStatement.close();
            System.out.println("更新：");
        }
        return rows;
    }
    /**
     * @Title: deleteOrderById
     * @Description: 根据ID删除
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id,connection,preparedStatement,dataSourceUtils
     * @return  rows 受影响的行数
     * @throws  SQLException
     *
     */
    @Override
    public Integer deleteOrderById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException{
        preparedStatement=connection.prepareStatement("DELETE FROM order_info WHERE ID=?");
        preparedStatement.setLong(1,id);
        Integer rows=preparedStatement.executeUpdate();
        connection.commit();
//        connection.close();
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);
        return rows;
    }
    /**
     * @Title: findOrderById
     * @Description: 根据ID查找
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id,connection,preparedStatement,dataSourceUtils
     * @return  orderInfo 订单
     * @throws  SQLException
     *
     */
    @Override
    public OrderInfo findOrderById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        OrderInfo orderInfo=new OrderInfo();
        preparedStatement=connection.prepareStatement("SELECT ID,ORDER_NUM,ORDER_STATUS,BUYER_USER_ACCOUNT_ID,STORE_ID,GOODS_INFO,GOODS_SUM_MONEY,ORDER_TIME,DELIVER_TIME,SUCCESS_TIME,IS_CANCELLATION FROM order_info WHERE ID=?");
        preparedStatement.setLong(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){
            orderInfo.setId(resultSet.getLong("ID"));
            orderInfo.setOrderNum(resultSet.getString("ORDER_NUM"));
            orderInfo.setOrderStatus(resultSet.getByte("ORDER_STATUS"));
            orderInfo.setBuyerUserAccountId(resultSet.getLong("BUYER_USER_ACCOUNT_ID"));
            orderInfo.setStoreId(resultSet.getLong("STORE_ID"));
            orderInfo.setGoodsInfo(resultSet.getString("GOODS_INFO"));
            orderInfo.setGoodsSumMoney(resultSet.getDouble("GOODS_SUM_MONEY"));
            orderInfo.setOrderTime(resultSet.getDate("ORDER_TIME"));
            orderInfo.setSuccessTime(resultSet.getDate("SUCCESS_TIME"));
            orderInfo.setDeliverTime(resultSet.getDate("DELIVER_TIME"));
            orderInfo.setCancellation(resultSet.getBoolean("IS_CANCELLATION"));
        }
//        connection.close();
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);
        return orderInfo;
    }
    /**
     * @Title: deleteOrderById
     * @Description: 根据ID批量删除
     * @author zhengxin
     * @date 2018/1/29/029
     * @param integers,connection,preparedStatement,dataSourceUtils
     * @return  rowsSum 受影响的行数
     * @throws  SQLException
     *
     */
    @Override
    public Integer deleteOrderByIds(Integer[] integers, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        Integer rowsSum=0;
        for (int id:integers){
            preparedStatement=connection.prepareStatement("DELETE FROM order_info WHERE ID=?");
            preparedStatement.setLong(1,id);
            Integer rows=preparedStatement.executeUpdate();
            rowsSum=rowsSum+rows;
            connection.commit();
//        connection.close();
            preparedStatement.close();
            dataSourceUtils.backConnection(connection);
        }
        return rowsSum;
    }
    /**
     * @Title: findOrderByCondtion
     * @Description: 按条件查询
     * @author zhengxin
     * @date 2018/1/29/029
     * @param stringObjectMap,connection,preparedStatement,dataSourceUtils
     * @return  orderInfoList 订单集合
     * @throws  SQLException
     *
     */
    @Override
    public List<OrderInfo> findOrderByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<OrderInfo> orderInfoList=new ArrayList<OrderInfo>();
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
        preparedStatement=connection.prepareStatement("SELECT ID,ORDER_NUM,ORDER_STATUS,BUYER_USER_ACCOUNT_ID,STORE_ID,GOODS_INFO,GOODS_SUM_MONEY,ORDER_TIME,DELIVER_TIME,SUCCESS_TIME,IS_CANCELLATION FROM order_info WHERE "+key+"="+value);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            OrderInfo orderInfo=new OrderInfo();
            orderInfo.setId(resultSet.getLong("ID"));
            orderInfo.setOrderNum(resultSet.getString("ORDER_NUM"));
            orderInfo.setOrderStatus(resultSet.getByte("ORDER_STATUS"));
            orderInfo.setBuyerUserAccountId(resultSet.getLong("BUYER_USER_ACCOUNT_ID"));
            orderInfo.setStoreId(resultSet.getLong("STORE_ID"));
            orderInfo.setGoodsInfo(resultSet.getString("GOODS_INFO"));
            orderInfo.setGoodsSumMoney(resultSet.getDouble("GOODS_SUM_MONEY"));
            orderInfo.setOrderTime(resultSet.getDate("ORDER_TIME"));
            orderInfo.setSuccessTime(resultSet.getDate("SUCCESS_TIME"));
            orderInfo.setDeliverTime(resultSet.getDate("DELIVER_TIME"));
            orderInfo.setCancellation(resultSet.getBoolean("IS_CANCELLATION"));
            orderInfoList.add(orderInfo);
        }
//        connection.close();
        preparedStatement.close();
        // 回收连接
        dataSourceUtils.backConnection(connection);

        return orderInfoList;
    }
}
