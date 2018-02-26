package service;

import java.util.Map;
import  entity.Store;

/**
 * @author xiaogaoqing
 * @InterfaceName StoreService
 * @Description 接口描述
 * @date 2018/1/29
 */
public interface StoreService  {
    /**
     * @Title: deleteStoreById
     * @Description: 删除一行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  id 主键id
     * @return  返回收影响的行数
     * @throws
     *
     */
    public void deleteStoreById(Long id);

    /**
     * @Title: deleteStoreByIds
     * @Description: 删除多行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  ids 主键id
     * @return  返回收影响的行数
     * @throws
     *
     */
    public void  deleteStoreByIds(Long[] ids);

    /**
     * @Title: saveOrUpdateStore
     * @Description: 添加或更新数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  store
     * @return  返回收影响的行数
     * @throws
     *
     */
    public void saveOrUpdateStore(Store store);

    /**
     * @Title: findStoreById
     * @Description: 查询数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  id 主键
     * @return  返回查询的对象
     * @throws
     *
     */
    public Store findStoreById(Long id);



    /**
     * @Title: findStoreByCondtionForPage
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
    public void findStoreByCondtionForPage(Map<String,Object> stringObjectMap, Integer startRows, Integer size);
}

