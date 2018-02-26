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
 * @Description OrderInfoDaoʵ��
 * @date 2018/1/29/029
 */
public class OrderInfoDaoImpl implements OrderInfoDao {
    /**
         * @Title: saveOrUpdateOrderById
         * @Description: ����ID��ӻ��߸��¶���
         * @author zhengxin
         * @date 2018/1/29/029
         * @param orderInfo,connection,preparedStatement,dataSourceUtils
         * @return  rows ��Ӱ�������
         * @throws  SQLException
         *
         */
    @Override
    public Integer saveOrUpdateOrderById(OrderInfo orderInfo, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)  throws SQLException {
        Integer rows=0;
        if (orderInfo.getId()==null){
            preparedStatement=connection.prepareStatement("INSERT INTO order_info(ID,ORDER_NUM,ORDER_STATUS,BUYER_USER_ACCOUNT_ID,STORE_ID,GOODS_INFO,GOODS_SUM_MONEY,ORDER_TIME,DELIVER_TIME,SUCCESS_TIME,IS_CANCELLATION)VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?)");

            // �������
            preparedStatement.setString(1,orderInfo.getOrderNum());
            //����״̬
            preparedStatement.setByte(2,orderInfo.getOrderStatus());
            //�����Ϣ
            preparedStatement.setLong(3,orderInfo.getBuyerUserAccountId());
            //������Ϣ
            preparedStatement.setLong(4,orderInfo.getStoreId());
            //��Ʒ��Ϣ
            preparedStatement.setString(5,orderInfo.getGoodsInfo());
            //������Ʒ�ܽ��
            preparedStatement.setDouble(6,orderInfo.getGoodsSumMoney());
            //�µ�ʱ��
            preparedStatement.setString(7,new DataConvertService().dateyMdHms(orderInfo.getOrderTime()));
            //���׳ɹ�ʱ��
            preparedStatement.setString(8,new DataConvertService().dateyMdHms(orderInfo.getSuccessTime()));
            //����ʱ��
            preparedStatement.setString(9,new DataConvertService().dateyMdHms(orderInfo.getDeliverTime()));
            //�����Ƿ�����
            preparedStatement.setBoolean(10,orderInfo.getCancellation());

            rows=preparedStatement.executeUpdate();
            connection.commit();
            // ��������
            dataSourceUtils.backConnection(connection);
            preparedStatement.close();
            System.out.println("������");
        }else if(orderInfo.getId()!=null){
            preparedStatement=connection.prepareStatement("UPDATE order_info SET ORDER_NUM=?,ORDER_STATUS=?,BUYER_USER_ACCOUNT_ID=?,STORE_ID=?,GOODS_INFO=?,GOODS_SUM_MONEY=?,ORDER_TIME=?,DELIVER_TIME=?,SUCCESS_TIME=?,IS_CANCELLATION=? WHERE ID =?");

            // �������
            preparedStatement.setString(1,orderInfo.getOrderNum());
            //����״̬
            preparedStatement.setByte(2,orderInfo.getOrderStatus());
            //�����Ϣ
            preparedStatement.setLong(3,orderInfo.getBuyerUserAccountId());
            //������Ϣ
            preparedStatement.setLong(4,orderInfo.getStoreId());
            //��Ʒ��Ϣ
            preparedStatement.setString(5,orderInfo.getGoodsInfo());
            //������Ʒ�ܽ��
            preparedStatement.setDouble(6,orderInfo.getGoodsSumMoney());
            //�µ�ʱ��
            preparedStatement.setString(7,new DataConvertService().dateyMdHms(orderInfo.getOrderTime()));
            //���׳ɹ�ʱ��
            preparedStatement.setString(8,new DataConvertService().dateyMdHms(orderInfo.getSuccessTime()));
            //����ʱ��
            preparedStatement.setString(9,new DataConvertService().dateyMdHms(orderInfo.getDeliverTime()));
            //�����Ƿ�����
            preparedStatement.setBoolean(10,orderInfo.getCancellation());
            //����ID
            preparedStatement.setLong(11,orderInfo.getId());

            rows=preparedStatement.executeUpdate();
//        JdbcUtils.release();
            connection.commit();
            // ��������
            dataSourceUtils.backConnection(connection);
            preparedStatement.close();
            System.out.println("���£�");
        }
        return rows;
    }
    /**
     * @Title: deleteOrderById
     * @Description: ����IDɾ��
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id,connection,preparedStatement,dataSourceUtils
     * @return  rows ��Ӱ�������
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
     * @Description: ����ID����
     * @author zhengxin
     * @date 2018/1/29/029
     * @param id,connection,preparedStatement,dataSourceUtils
     * @return  orderInfo ����
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
     * @Description: ����ID����ɾ��
     * @author zhengxin
     * @date 2018/1/29/029
     * @param integers,connection,preparedStatement,dataSourceUtils
     * @return  rowsSum ��Ӱ�������
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
     * @Description: ��������ѯ
     * @author zhengxin
     * @date 2018/1/29/029
     * @param stringObjectMap,connection,preparedStatement,dataSourceUtils
     * @return  orderInfoList ��������
     * @throws  SQLException
     *
     */
    @Override
    public List<OrderInfo> findOrderByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<OrderInfo> orderInfoList=new ArrayList<OrderInfo>();
        String key="";
        String value="";
        //ȡ��map�еļ�ֵ��
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
        // ��������
        dataSourceUtils.backConnection(connection);

        return orderInfoList;
    }
}
