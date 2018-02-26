package entity;

/**
 * @author xiaogaoqing
 * @ClassName StoreD
 * @Description 类描述
 * @date 2018/1/28
 */
public class Store {
    /**
     * Id 主键
     */
    private Long id;

    /**
     *StoreName 商品名称
     */
    private String storeName;

    /**
     *UserAccountId 卖家
     */
    private  Long userAccountId;

    //获取get和set方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }
    //获取构造方法
    public  Store(Long id,String storeName,Long userAccountId){
        this.id=id;
        this.storeName=storeName;
        this.userAccountId=userAccountId;
    }
    public Store(){
    }
    public  Store(String storeName,Long userAccountId){

    }

}