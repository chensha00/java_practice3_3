package service;/**
 * Created by Administrator on 2018/1/29.
 */


import entity.BuyGoods;



import java.sql.SQLException;


/**
 * @author zhouxiang
 * @InterfaceName BuyGoodsService
 * @Description 接口描述
 * @date 2018/1/29
 */
public interface BuyGoodsService {
    /**
     * @Title: deleteGoodsByIds
     * @Description: 购买表的删除方法
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public Integer deleteBuyGoodsByIds(Long[] ids)throws SQLException;
    /**
     * @Title: updateBuyGoods
     * @Description: 购买表的更新方法
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public Integer updateBuyGoods(BuyGoods goods)throws SQLException;
    /**
     * @Title: insertBuyGoods
     * @Description: 购买表的增加方法
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public Integer insertBuyGoods(BuyGoods goods)throws SQLException;
    /**
     * @Title: findBuyGoodsById
     * @Description: 购买表的查询方法
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public BuyGoods findBuyGoodsById(Long id)  throws SQLException;

}

