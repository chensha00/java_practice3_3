package dao;/**
 * Created by Administrator on 2018/1/29.
 */

import common.util.DataSourceUtils;
import entity.BuyGoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author zhouxiang
 * @ClassName BuyGoodsDaoImpl
 * @Description ������
 * @date 2018/1/29
 */
public class BuyGoodsDaoImpl implements BuyGoodsDao {

    /**
     * @Title: deleteBuyGoodsByIds
     * @Description: ��д������ɾ������
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    @Override
    public Integer deleteBuyGoodsByIds(Long[] ids, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        for(Long id:ids){
            preparedStatement=connection.prepareStatement("DELETE FROM BUY_GOODS WHERE ID=?;");
            preparedStatement.setLong(1,id);
        }
        Integer operatedRows=preparedStatement.executeUpdate();
        connection.commit();
        return operatedRows;
    }


    /**
     * @Title: inertBuyGoods
     * @Description: ��д���������ӷ���
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */

    @Override
    public Integer inertBuyGoods(BuyGoods buyGoods, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        Integer rows=null;
        preparedStatement=connection.prepareStatement("INSERT INTO BUY_GOODS(USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID," +
                "GOODS_NUM,BUY_GOODS_DATE)VALUES(?,?,?,?,?);");
        preparedStatement.setLong(1, buyGoods.getUserAccountID());
        preparedStatement.setLong(2, buyGoods.getOrderInfoID());
        preparedStatement.setLong(3, buyGoods.getStoreID());
        preparedStatement.setDouble(4, buyGoods.getGoodsNum());
        java.sql.Date sqlDate=new java.sql.Date(buyGoods.getBuyGoodsDate().getTime());
        preparedStatement.setDate(5,sqlDate);
        rows=preparedStatement.executeUpdate();
        connection.commit();
        return rows;
    }
    /**
     * @Title: updateBuyGoods
     * @Description: ��д�����ĸ��·���
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */

    @Override
    public Integer updateBuyGoods(BuyGoods buyGoods, Connection connection, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE BUY_GOODS SET USER_ACCOUNT_ID=?,ORDER_INFO_ID=?,STORE_ID=?,GOODS_NUM=?,BUY_GOODS_DATE=?;");
      //  preparedStatement.setLong((int)1,buyGoods.getID());
        preparedStatement.setLong(1, buyGoods.getUserAccountID());
        preparedStatement.setLong(2, buyGoods.getOrderInfoID());
        preparedStatement.setLong(3, buyGoods.getStoreID());
        preparedStatement.setDouble(4, buyGoods.getGoodsNum());
        java.sql.Date sqlDate=new java.sql.Date(buyGoods.getBuyGoodsDate().getTime());
        preparedStatement.setDate(5,sqlDate);
        Integer rows=null;
        rows=preparedStatement.executeUpdate();
        connection.commit();
        return rows;
    }

    /**
     * @Title: findBuyGoodsById
     * @Description: ��д�����Ĳ�ѯ����
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    @Override
    public BuyGoods findBuyGoodsById(Long id, Connection connection, PreparedStatement preparedStatement)  throws SQLException{
        //�½�һ��goodstype����
        BuyGoods buyGoods=new BuyGoods();
        //����SQL.
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID,GOODS_NUM,BUY_GOODS_DATE  FROM BUY_GOODS WHERE  ID=?");
        //�����ݷ���SQL���
        preparedStatement.setLong(1,id);
        //��÷��صĲ�ѯ�����
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            //����
            buyGoods.setID(resultSet.getLong("ID"));
        }
        //�ر�Ԥ����
        preparedStatement.close();

        return null;

}

    /*****************************************
     public List<BuyGoods> findBuyGoodsByOrderId(Long orderId, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<BuyGoods> buyGoodsList=new ArrayList<BuyGoods>();
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID,GOODS_NUM,BUY_GOODS_DATE FROM buy_goods WHERE ORDER_INFO_ID=?");
        preparedStatement.setLong(1,orderId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            BuyGoods buyGoods=new BuyGoods();
            //id
            buyGoods.setID(resultSet.getLong("ID"));
            //����˻�id
            buyGoods.setUserAccountID(resultSet.getLong("USER_ACCOUNT_ID"));
            //������Ϣid
            buyGoods.setOrderInfoID(resultSet.getLong("ORDER_INFO_ID"));
            //�̵���Ʒid
            buyGoods.setStoreID(resultSet.getLong("STORE_ID"));
            //��Ʒ����
            buyGoods.setGoodsNum(resultSet.getDouble("GOODS_NUM"));
            //��������
            buyGoods.setBuyGoodsDate(resultSet.getDate("BUY_GOODS_DATE"));

            //��ӵ�����
            buyGoodsList.add(buyGoods);
        }
//        connection.close();
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);


        return buyGoodsList;
    }
     ***********************/

    /**
     * @Title: findBuyGoodsByCondtion
     * @Description: 重写找到BuyGoods内容的方法
     * @author zhouxiang
     * @date 2018/02/02
     */
    @Override
    public List<BuyGoods> findBuyGoodsByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<BuyGoods> userAccountList=new ArrayList<BuyGoods>();
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
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID,GOODS_NUM,BUY_GOODS_DATE FROM BUY_GOODS WHERE "+key+"="+value);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            BuyGoods user=new BuyGoods();
            user.setID(resultSet.getLong("ID"));
            user.setUserAccountID(resultSet.getLong("USER_ACCOUNT_ID"));
            user.setOrderInfoID(resultSet.getLong("ORDER_INFO_ID"));
            user.setStoreID(resultSet.getLong("STORE_ID"));
            user.setGoodsNum(resultSet.getDouble("GOODS_NUM"));
            user.setBuyGoodsDate(resultSet.getDate("BUY_GOODS_DATE"));
            userAccountList.add(user);
        }
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);

        return userAccountList;
    }

}

