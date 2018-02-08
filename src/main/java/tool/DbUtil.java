package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author wujunnan
 * @ClassName DbUtil
 * @Description 连接数据库工具类
 * @date 2018/1/22
 */
public class DbUtil {
    //Mysql驱动
    private static String driver = "com.mysql.cj.jdbc.Driver";
    //连接地址
    private static String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    //数据库名称
    private static String user = "root";
    //数据库密码
    private static String pwd = "123456";
    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,user,pwd);
        return conn;
    }
    /**
     * 关闭数据库连接
     * @param conn
     * @throws Exception
     */
    public void close(PreparedStatement ps,Connection conn) throws Exception{
        if (ps!=null){
            ps.close();
            if (conn!=null){
                conn.close();
            }
        }
    }
}