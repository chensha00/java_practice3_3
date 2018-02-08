package common.util;/********************************************************************
 /**
 * @Project: test_maven
 * @Package jdbc
 * @author guohongjin
 * @date 2017/8/28 22:12
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author guohongjin
 * @ClassName JdbcUtils
 * @Description 类描述
 * @date 2017/8/28
 */
public class JdbcUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * 静态代码块加载配置文件信息
     */
    static {
        try {
            // 1.通过当前类获取类加载器
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            // 2.通过类加载器的方法获得一个输入流
            InputStream is = classLoader.getResourceAsStream("db.properties");
            // 3.创建一个properties对象
            Properties props = new Properties();
            // 4.加载输入流
            props.load(is);
            // 5.获取相关参数的值
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接方法
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源方法
     *
     * @param conn
     * @param pstmt
     * @param rs
     */
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
