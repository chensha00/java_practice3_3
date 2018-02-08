package service;

import entity.OrderInfo;

import java.util.List;
import java.util.Map;

/**
 * @author zhengxin
 * @InterfaceName OrderInfoService
 * @Description OrderInfoService接口
 * @date 2018/1/29/029
 */
public interface OrderInfoService {
    /**
         * @Title: saveOrUpdateOrderById
         * @Description: 插入或修改
         * @author zhengxin
         * @date 2018/1/29/029
         * @param orderInfo
         *
         */
    public Integer saveOrUpdateOrderById(OrderInfo orderInfo);
    /**
         * @Title: deleteOrderById
         * @Description: 按ID删除
         * @author zhengxin
         * @date 2018/1/29/029
         * @param id
         * @return  Integer 受影响的行ID
         *
         */
    public Integer deleteOrderById(Long id);
    /**
         * @Title: findOrderById
         * @Description: 按ID查找
         * @author zhengxin
         * @date 2018/1/29/029
         * @param id
         * @return  OrderInfo
         *
         */
    public OrderInfo findOrderById(Long id);
    /**
         * @Title: deleteOrderByIds
         * @Description: 按多个ID删除
         * @author zhengxin
         * @date 2018/1/29/029
         * @param integers ID数组
         *
         */
    public Integer deleteOrderByIds(Integer[] integers);
    /**
         * @Title: findTestByCondtion
         * @Description: 条件查询
         * @author zhengxin
         * @date 2018/1/29/029
         * @param stringObjectMap
         * @return OrderInfo
         *
         */
    public List<OrderInfo> findOrderByCondtion(Map<String, String> stringObjectMap);
}
