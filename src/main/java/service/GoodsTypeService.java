package service;

import entity.GoodsType;

import java.util.List;
import java.util.Map;

/**
 * @author xiaogaoqing
 * @InterfaceName GoodsTypeService
 * @Description 接口描述
 * @date 2018/1/29
 */
public interface GoodsTypeService {
    /**
     * @Title: deleteGoodsTypeById
     * @Description: 删除一行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  id 主键id
     * @return  返回收影响的行数
     * @throws
     *
     */
    public void deleteGoodsTypeById(Long id);

    /**
     * @Title: deleteGoodsTypeByIds
     * @Description: 删除多行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  ids 主键id
     * @return  返回收影响的行数
     * @throws
     *
     */
    public void  deleteGoodsTypeByIds(Long[] ids);

    /**
     * @Title: saveOrUpdateGoodsType
     * @Description: 添加或更新数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  goodsType
     * @return  返回收影响的行数
     * @throws
     *
     */
    public void saveOrUpdateGoodsType(GoodsType goodsType);

    /**
     * @Title: findGoodsTypeById
     * @Description: 查询数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  id 主键
     * @return  返回查询的对象
     * @throws
     *
     */
    public GoodsType findGoodsTypeById(Long id);



    /**
     * @Title: findGoodsTypeByCondtionForPage
     * @Description: 带分页功能的查询多条数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  stringObjectMap *******按照对应的数据表来写，应该是传入一个Map集合，根据集合里的对象查数据
     * @param startRows 开始行
     * @param size 要显示多少条信息的大小
     * @return  返回查询的对象的集合
     * @throws
     *
     */
    public void findGoodsTypeByCondtionForPage(Map<String,Object> stringObjectMap, Integer startRows, Integer size);
}
