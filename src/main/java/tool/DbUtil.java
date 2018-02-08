package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author wujunnan
 * @ClassName DbUtil
 * @Description �������ݿ⹤����
 * @date 2018/1/22
 */
public class DbUtil {
    //Mysql����
    private static String driver = "com.mysql.cj.jdbc.Driver";
    //���ӵ�ַ
    private static String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    //���ݿ�����
    private static String user = "root";
    //���ݿ�����
    private static String pwd = "123456";
    /**
     * ��ȡ���ݿ�����
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,user,pwd);
        return conn;
    }
    /**
     * �ر����ݿ�����
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