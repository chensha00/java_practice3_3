package entity;

/**
 * @author xiaogaoqing
 * @ClassName GoodsType
 * @Description 类描述
 * @date 2018/1/28
 */
public class GoodsType {
    /**
     * Id 主键
     */
    private  Long id;
    /**
     * TypeName 类型名称
     */
    private  String typeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public GoodsType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public GoodsType(String typeName) {
        this.typeName = typeName;
    }
    public GoodsType(){

    }
}