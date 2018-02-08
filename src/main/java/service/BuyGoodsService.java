package service;/**
 * Created by Administrator on 2018/1/29.
 */

import common.util.DataSourceUtils;
import dao.BuyGoodsDao;
import entity.BuyGoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
     * @Description: 购买表的查询方法(按Id)
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public BuyGoods findBuyGoodsById(Long id)  throws SQLException;

    /**
     * @Title: findBuyGoodsById
     * @Description: 购买表的查询方法(按内容)
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public List<BuyGoods> findBuyGoodsByCondtion(Map<String, String> stringObjectMap) throws SQLException;

    }

