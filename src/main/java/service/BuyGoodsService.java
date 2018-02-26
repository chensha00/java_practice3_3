package service;/**
 * Created by Administrator on 2018/1/29.
 */


import entity.BuyGoods;



import java.sql.SQLException;


/**
 * @author zhouxiang
 * @InterfaceName BuyGoodsService
 * @Description �ӿ�����
 * @date 2018/1/29
 */
public interface BuyGoodsService {
    /**
     * @Title: deleteGoodsByIds
     * @Description: ������ɾ������
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public Integer deleteBuyGoodsByIds(Long[] ids)throws SQLException;
    /**
     * @Title: updateBuyGoods
     * @Description: �����ĸ��·���
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public Integer updateBuyGoods(BuyGoods goods)throws SQLException;
    /**
     * @Title: insertBuyGoods
     * @Description: ���������ӷ���
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public Integer insertBuyGoods(BuyGoods goods)throws SQLException;
    /**
     * @Title: findBuyGoodsById
     * @Description: �����Ĳ�ѯ����
     * @author zhouxiang
     * @date 2018/01/29
     * @throw SQLException
     */
    public BuyGoods findBuyGoodsById(Long id)  throws SQLException;

}

