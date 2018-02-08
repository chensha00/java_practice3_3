package service;/**
 * Created by Administrator on 2018/1/29.
 */

import common.util.JdbcUtils;
import dao.BuyGoodsDao;
import dao.BuyGoodsDaoImpl;
import entity.BuyGoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxiang
 * @ClassName BuyGoodsServiceImpl
 * @Description 类描述
 * @date 2018/1/29
 */
public class BuyGoodsServiceImpl implements BuyGoodsService {
    static BuyGoodsDao buyGoodsDao=new BuyGoodsDaoImpl();
    /**
     * @Title: deleteBuyGoodsByIds
     * @Description: 实现删除买的物品的方法
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */

    @Override
    public Integer deleteBuyGoodsByIds(Long[] ids) throws SQLException {
        Connection connection= JdbcUtils.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement=null;
        Integer rows=null;
        try{
            connection.setAutoCommit(false);
            rows = buyGoodsDao.deleteBuyGoodsByIds(ids, connection, preparedStatement);
            if(rows.doubleValue() == 0){
                System.out.println("删除失败！");
            }else {
                System.out.println("删除成功！");
            }
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//出现异常，事物回滚
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //JdbcUtils.release(connection,preparedStatement);                        //关闭连接
            return  rows;  //返回结果
        }
    }

    /**
     * @Title: updateBuyGoods
     * @Description: 实现更新买的物品的方法
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public Integer updateBuyGoods(BuyGoods goods) throws SQLException {
        Connection  connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        Integer rows=null;
        try{
            connection.setAutoCommit(false);
            rows = buyGoodsDao.updateBuyGoods(goods, connection, preparedStatement);
            if(rows.doubleValue() == 0){
                System.out.println("删除失败！");
            }else {
                System.out.println("删除成功！");
            }
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//出现异常，事物回滚
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //JdbcUtils.release(connection,preparedStatement);//关闭连接
        }
        return rows;
    }

    /**
     * @Title: insertBuyGoods
     * @Description: 实现增加买的物品的方法
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public Integer insertBuyGoods(BuyGoods goods) throws SQLException {
        Connection connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        Integer rows=null;
        try{
            connection.setAutoCommit(false);
            rows= buyGoodsDao.inertBuyGoods(goods, connection, preparedStatement);

        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//出现异常，事物回滚
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    /**
     * @Title: findBuyGoodsById
     * @Description: 实现查找买的物品的方法(按Id)
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public BuyGoods findBuyGoodsById(Long id) throws SQLException {
        Connection connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        String respond=null;//返回给用户的字符串
        BuyGoods result=null;
        try{
            connection.setAutoCommit(false);
             result = buyGoodsDao.findBuyGoodsById(id, connection, preparedStatement);

            if(result == null){
                respond = "查询失败！";
            }else {
                respond = "查询成功！";
            }
            System.out.println(respond);   //输出查询是否成功
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//出现异常，事物回滚
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();                //提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
           // JdbcUtils.release(connection,preparedStatement);//关闭连接
        }
       return result;                           //返回查询的信息给用户

    }

    /**
     * @Title: findBuyGoodsByCondtion
     * @Description: 实现查找买的物品的方法(按内容)
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public List<BuyGoods> findBuyGoodsByCondtion(Map<String, String> stringObjectMap) throws SQLException{
        Connection connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        List<BuyGoods> result=null;
        try{
            connection.setAutoCommit(false);
            result= buyGoodsDao.findBuyGoodsByCondtion( stringObjectMap, connection, preparedStatement);

        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//出现异常，事物回滚
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

