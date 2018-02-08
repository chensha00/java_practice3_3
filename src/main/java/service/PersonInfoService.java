package service; /**
 * @Project: java_practice - 副本
 * @Package service
 * @author jiangxiangwen
 * @date 2018/1/29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */



import entity.PersonInfo;

import java.util.List;
import java.util.Map;

/**
 * @author jiangxiangwen
 * @ClassName PersonInfoService
 * @Description 人员信息service层接口
 * @date 2018/1/29
 */
public interface PersonInfoService {

    /**
     * @Title: deleteTestById
     * @Description: 删除一行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id    主键id
     * @return  返回收影响的行数
     */
    public Integer deletePersonInfoById(Long id);

    /**
     * @Title: deleteTestByIds
     * @Description: 删除多行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param ids 主键id集合
     * @return 返回收影响的行数
     */
    public Integer deletePersonInfoByIds(Long[] ids);

    /**
     * @Title: saveOrUpdateTest
     * @Description: 添加或更新数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param personInfo 人员信息
     * @return 返回收影响的行数
     */
    public Integer saveOrUpdatePersonInfo(PersonInfo personInfo);

    /**
     * @Title: findTestById
     * @Description: 查询数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id 主键id
     * @return 返回查询的对象
     */
    public PersonInfo findPersonInfoById(Integer id);

    /**
     * @Title: findTestByCondtionForPage
     * @Description: 带分页功能的查询多条数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param stringObjectMap    查询数据的键值对
     * @return 返回查询的对象的集合
     */
    public List<PersonInfo> findPersonInfoByCondtionForPage(Map<String,String> stringObjectMap);
}