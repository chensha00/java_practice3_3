package common.util;/********************************************************************
 /**
 * @Project: test_maven
 * @Package jdbc
 * @author guohongjin
 * @date 2017/8/28 22:14
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;

/**
 * @author guohongjin
 * @ClassName JdbcPoolMain
 * @Description 类描述
 * @date 2017/8/28
 */
public class JdbcPoolMain {

    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new DataSourceUtils();
        ResultSet set=null;
//        Field field=new Field();
//        field.get()
//        Date date=new Date()
        try {
            // 2.从池子中获取连接
            conn = dataSource.getConnection();
//            String sql = "insert into tbl_user values(null,?,?)";
            //3.必须在自定义的connection类中重写prepareStatement(sql)方法
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "吕布1");
//            pstmt.setString(2, "貂蝉1");
            pstmt = conn.prepareStatement("SELECT NAME  FROM test WHERE  ID=?");
            Statement statement=conn.createStatement();

//            statement.execute()
//            pstmt.execute();
            pstmt.setLong(1,1l);

            set=pstmt.executeQuery();
            conn.setAutoCommit(false);



            conn.commit();

            conn.rollback();

//            set.getString()
//            int rows = pstmt.executeUpdate();
//            if (rows > 0) {
//                System.out.println("添加成功!");
//            } else {
//                System.out.println("添加失败!");
//            }
//            ResultSet rs = null;
//            try {
//                //接收查询数据
////                rs=stmt.executeQuery();
////            stmt.executeUpdate("");
//                //提交事务
////                connection.commit();

////            stmt.executeUpdate("");executeUpdate
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            try {
                while (set.next()) {
//                    String name = set.getString("NAME");
                    String name = set.getString(1);
//                rs.
                    System.out.println("name is:"+ name);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, pstmt, set);
        }
    }
}
