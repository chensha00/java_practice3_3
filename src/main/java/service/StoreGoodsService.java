package service;/********************************************************************
 /**
 * @Project: task001
 * @Package service
 * @author wujiancheng
 * @date 2018/1/28 0029 0:45
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import entity.StoreGoods;

import java.sql.SQLException;

/**
 * @author wujiancheng
 * @InterfaceName StoreGoodsService
 * @Description ��Ʒ
 * @date 2018/1/28 0029
 */
public interface StoreGoodsService {
    /**
     * @Title: deleteStoreGoodsById
     * @Description: ɾ����Ʒ����
     * @author wujiancheng
     * @date 2018/1/28
     * @param ID ����һ��Ҫɾ����id
     */
    public void deleteStoreGoodsById(Long ID);
    /**
     * @Title: addStoreGoods
     * @Description: ������Ʒ����
     * @author wujiancheng
     * @date 2018/1/22
     * @param storeGoods ����һ��Ҫ��ӵ���Ʒ����
     */
    public void addStoreGoods(StoreGoods storeGoods);
    /**
     * @Title: updateStoreGoodsById
     * @Description: �޸���Ʒ����
     * @author wujiancheng
     * @date 2018/1/22
     * @param storeGoods ����һ��Ҫ�޸ĵ���Ʒ����
     */
    public void updateStoreGoodsById(StoreGoods storeGoods) throws SQLException;
    /**
     * @Title: findStoreGoodsById
     * @Description: ��ѯ��Ʒ����
     * @author wujiancheng
     * @date 2018/1/22
     * @return ������Ʒ����
     * @param ID ����һ��Ҫ��ѯ��id
     */
    public StoreGoods findStoreGoodsById(Long ID);
}
