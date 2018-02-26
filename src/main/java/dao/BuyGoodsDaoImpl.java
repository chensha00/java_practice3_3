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
 * @Description 类描述
 * @date 2018/1/29
 */
public class BuyGoodsDaoImpl implements BuyGoodsDao {

    /**
     * @Title: deleteBuyGoodsByIds
     * @Description: 重写购买表的删除方法
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
     * @Description: 重写购买表的增加方法
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
     * @Description: 重写购买表的更新方法
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
     * @Description: 重写购买表的查询方法
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    @Override
    public BuyGoods findBuyGoodsById(Long id, Connection connection, PreparedStatement preparedStatement)  throws SQLException{
        //新建一个goodstype对象
        BuyGoods buyGoods=new BuyGoods();
        //更新SQL.
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID,GOODS_NUM,BUY_GOODS_DATE  FROM BUY_GOODS WHERE  ID=?");
        //将数据放入SQL语句
        preparedStatement.setLong(1,id);
        //获得返回的查询结果集
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            //主键
            buyGoods.setID(resultSet.getLong("ID"));
        }
        //关闭预编译
        preparedStatement.close();

        return null;

}



    public List<BuyGoods> findBuyGoodsByOrderId(Long orderId, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<BuyGoods> buyGoodsList=new ArrayList<BuyGoods>();
        preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID,GOODS_NUM,BUY_GOODS_DATE FROM buy_goods WHERE ORDER_INFO_ID=?");
        preparedStatement.setLong(1,orderId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            BuyGoods buyGoods=new BuyGoods();
            //id
            buyGoods.setID(resultSet.getLong("ID"));
            //买家账户id
            buyGoods.setUserAccountID(resultSet.getLong("USER_ACCOUNT_ID"));
            //订单信息id
            buyGoods.setOrderInfoID(resultSet.getLong("ORDER_INFO_ID"));
            //商店商品id
            buyGoods.setStoreID(resultSet.getLong("STORE_ID"));
            //商品数量
            buyGoods.setGoodsNum(resultSet.getDouble("GOODS_NUM"));
            //购买日期
            buyGoods.setBuyGoodsDate(resultSet.getDate("BUY_GOODS_DATE"));

            //添加到集合
            buyGoodsList.add(buyGoods);
        }
//        connection.close();
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);


        return buyGoodsList;
    }

    @Override
    public List<BuyGoods> findBuyGoodsByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSource) throws SQLException {
            List<BuyGoods> buyGoodsArrayList=new ArrayList<BuyGoods>();
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
            preparedStatement=connection.prepareStatement("SELECT ID,USER_ACCOUNT_ID,ORDER_INFO_ID,STORE_ID,GOODS_NUM,BUY_GOODS_DATE FROM buy_goods WHERE "+key+"="+value);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                BuyGoods buyGoods=new BuyGoods();
                buyGoods.setID(resultSet.getLong("ID"));
                buyGoods.setUserAccountID(resultSet.getLong("USER_ACCOUNT_ID"));
                buyGoods.setOrderInfoID(resultSet.getLong("ORDER_INFO_ID"));
                buyGoods.setStoreID(resultSet.getLong("STORE_ID"));
                buyGoods.setGoodsNum(resultSet.getDouble("GOODS_NUM"));
                buyGoods.setBuyGoodsDate(resultSet.getDate("BUY_GOODS_DATE"));

                buyGoodsArrayList.add(buyGoods);
            }
//        connection.close();
            preparedStatement.close();
            dataSource.backConnection(connection);


            return buyGoodsArrayList;
    }
}

