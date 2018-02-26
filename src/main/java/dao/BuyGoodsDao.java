package dao;/**
 * Created by Administrator on 2018/1/29.
 */

import common.util.DataSourceUtils;
import entity.BuyGoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxiang
 * @InterfaceName BuyGoodsDao
 * @Description 卖商品的接口
 * @date 2018/1/29
 */
public interface BuyGoodsDao {
    //通过ID批量删除商品
    public  Integer deleteBuyGoodsByIds(Long[] id, Connection connection, PreparedStatement preparedStatement)throws SQLException;
    //添加商品
    public Integer inertBuyGoods(BuyGoods buyGoods,Connection connection,PreparedStatement preparedStatement)throws SQLException;
 //更新商品信息
    public Integer updateBuyGoods(BuyGoods buyGoods, Connection connection, PreparedStatement preparedStatement) throws SQLException;
    //通过条件查询商品信息
    public BuyGoods findBuyGoodsById(Long id, Connection connection, PreparedStatement preparedStatement)  throws SQLException;


    List<BuyGoods> findBuyGoodsByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSource) throws SQLException;
}
