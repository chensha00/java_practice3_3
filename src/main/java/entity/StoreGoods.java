package entity;/********************************************************************
 /**
 * @Project: task001
 * @Package entity
 * @author wujiancheng
 * @date 2018/1/29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author wujiancheng
 * @ClassName StoreGoods
 * @Description ��Ʒ��Ϣʵ��
 * @date 2018/1/29
 */
public class StoreGoods {
    /**
     * ����
     */
    private int ID;
    /**
     * ��������
     */
    private int STORE_ID;
    /**
     *��Ʒ����
     */
    private String GOODS_NAME;
    /**
     * ��Ʒ���
     */
    private double GOODS_NUM;
    /**
     * ��Ʒ�۸�
     */
    private double GOODS_PRICE;
    /**
     * ��Ʒ����
     */
    private int GOODS_TYPE_ID;
    /**
     * Ʒ��
     */
    private String BRAND;
    /**
     * ������ַ
     */
    private String PRODUCTION_ADDRESS;
    /**
     * �������� yyyy-MM-dd
     */
    private Date PRODUCED_DATE;
    /**
     * ������
     */
    private int SHELF_LIFE;
    /**
     * ���������� 1-�� 2-�� 3-��
     */
    private String  SHELF_LIFE_TYPE;

    public StoreGoods(int ID, int STORE_ID, String GOODS_NAME, double GOODS_NUM, double GOODS_PRICE, int GOODS_TYPE_ID, String BRAND, String PRODUCTION_ADDRESS, Date PRODUCED_DATE, int SHELF_LIFE, String SHELF_LIFE_TYPE) {
        this.ID = ID;
        this.STORE_ID = STORE_ID;
        this.GOODS_NAME = GOODS_NAME;
        this.GOODS_NUM = GOODS_NUM;
        this.GOODS_PRICE = GOODS_PRICE;
        this.GOODS_TYPE_ID = GOODS_TYPE_ID;
        this.BRAND = BRAND;
        this.PRODUCTION_ADDRESS = PRODUCTION_ADDRESS;
        this.PRODUCED_DATE = PRODUCED_DATE;
        this.SHELF_LIFE = SHELF_LIFE;
        this.SHELF_LIFE_TYPE = SHELF_LIFE_TYPE;
    }
     public StoreGoods() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSTORE_ID() {
        return STORE_ID;
    }

    public void setSTORE_ID(int STORE_ID) {
        this.STORE_ID = STORE_ID;
    }

    public String getGOODS_NAME() {
        return GOODS_NAME;
    }

    public void setGOODS_NAME(String GOODS_NAME) {
        this.GOODS_NAME = GOODS_NAME;
    }

    public double getGOODS_NUM() {
        return GOODS_NUM;
    }

    public void setGOODS_NUM(double GOODS_NUM) {
        this.GOODS_NUM = GOODS_NUM;
    }

    public double getGOODS_PRICE() {
        return GOODS_PRICE;
    }

    public void setGOODS_PRICE(double GOODS_PRICE) {
        this.GOODS_PRICE = GOODS_PRICE;
    }

    public int getGOODS_TYPE_ID() {
        return GOODS_TYPE_ID;
    }

    public void setGOODS_TYPE_ID(int GOODS_TYPE_ID) {
        this.GOODS_TYPE_ID = GOODS_TYPE_ID;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getPRODUCTION_ADDRESS() {
        return PRODUCTION_ADDRESS;
    }

    public void setPRODUCTION_ADDRESS(String PRODUCTION_ADDRESS) {
        this.PRODUCTION_ADDRESS = PRODUCTION_ADDRESS;
    }

    public Date getPRODUCED_DATE() {
        return PRODUCED_DATE;
    }

    public void setPRODUCED_DATE(Date PRODUCED_DATE) {
        this.PRODUCED_DATE = PRODUCED_DATE;
    }

    public int getSHELF_LIFE() {
        return SHELF_LIFE;
    }

    public void setSHELF_LIFE(int SHELF_LIFE) {
        this.SHELF_LIFE = SHELF_LIFE;
    }

    public String getSHELF_LIFE_TYPE() {
        return SHELF_LIFE_TYPE;
    }

    public void setSHELF_LIFE_TYPE(String SHELF_LIFE_TYPE) {
        this.SHELF_LIFE_TYPE = SHELF_LIFE_TYPE;
    }
}
