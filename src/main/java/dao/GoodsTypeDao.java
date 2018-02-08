package dao;

import common.util.DataSourceUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import domain.GoodsType;
/**
 * @author xiaogaoqing
 * @InterfaceName GoodsTypeDao
 * @Description 接口描述
 * @date 2018/1/28
 */
public interface GoodsTypeDao {
    /**
     * @Title: deleteGoodsTypeById
     * @Description: 删除一行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  id 主键id
     * @return  返回收影响的行数
     * @throws SQLException
     *
     */
    public Integer deleteGoodsTypeById(Long id, Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: deleteGoodsTypeByIds
     * @Description: 删除多行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  ids 主键id
     * @return  返回收影响的行数
     * @throws SQLException
     *
     */
    public Integer deleteGoodsTypeByIds(Long[] ids, Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;

    /**
     * @Title: saveOrUpdateGoodsType
     * @Description: 添加或更新数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  goodsType 要添加到数据库中的对象
     * @return  返回收影响的行数
     * @throws SQLException
     *
     */
    public Integer saveOrUpdateGoodsType(GoodsType goodsType,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;


    /**
     * @Title: findGoodsTypeById
     * @Description: 查询数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @return  返回查询的对象
     * @throws SQLException
     */
    public GoodsType findGoodsTypeById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)throws SQLException;


//    /**
//     * @Title: addgoods
//     * @Description: 添加商品类型数据
//     * @author xiaogaoqing
//     * @date 2018/1/29
//     * @return  goodsType
//     * @throws SQLException
//     */
//    public Integer addGoodsType(GoodsType goodsType,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;


    /**
     * @Title: findGoodsTypeByCondtion
     * @Description: 条件查询数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  stringObjectMap *******按照对应的数据表来写，应该是传入一个Map集合，根据集合里的对象查数据
     * @return  返回查询的对象的集合
     * @throws SQLException
     *
     */

    public List<GoodsType> findGoodsTypeByCondtion(Map<String,String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)throws SQLException;
}
