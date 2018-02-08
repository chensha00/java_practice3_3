package entity;
/**
 * @Project: java_practice
 * @Package entity
 * @author jiangxiangwen
 * @date 2018/1/28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author jiangxiangwen
 * @ClassName Person
 * @Description 人
 * @date 2018/1/28
 */
public class PersonInfo{

    /**
     * id  主键
     */
    private Long id;

    /**
     * userAccountId 用户账户id
     */
    private Long userAccountId;

    /**
     * idEntityCard 身份证号
     */
    private String idEntityCard;

    /**
     * name 姓名
     */
    private String name;

    /**
     *buyerOrSeller 买家或买家的标记 0- 买家 1-卖家
     */
    private Byte buyerOrSeller;

    /**
     * age 年龄
     */
    private Integer age;

    /**
     * sex 性别 0 -男，1 -女
     */
    private Byte sex;


    /**
     * @Title: Person
     * @Description: 构造函数
     * @author jiangxiangwen
     * @date 2018/1/28
     */
    public PersonInfo() {

    }

    /**
     * @Title: Person
     * @Description: 构造函数
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id id 主键
     * @param userAccountId 用户账户id  外键
     * @param idEntityCard 身份证号码
     * @param name 用户的真实姓名
     * @param buyerOrSeller 买家或买家的标记 0- 买家 1-卖家
     * @param age 年龄
     * @param sex 性别 0 -男，1 -女
     */
    public PersonInfo(Long id, Long userAccountId, String idEntityCard, String name, Byte buyerOrSeller, Integer age, Byte sex) {
        this.id = id;
        this.userAccountId = userAccountId;
        this.idEntityCard = idEntityCard;
        this.name = name;
        this.buyerOrSeller = buyerOrSeller;
        this.age = age;
        this.sex = sex;
    }

    /**
     * get 和 set 方法
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getIdEntityCard() {
        return idEntityCard;
    }

    public void setIdEntityCard(String idEntityCard) {
        this.idEntityCard = idEntityCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getBuyerOrSeller() {
        return buyerOrSeller;
    }

    public void setBuyerOrSeller(Byte buyerOrSeller) {
        this.buyerOrSeller = buyerOrSeller;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
}
