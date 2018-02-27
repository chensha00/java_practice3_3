package controler;

import org.apache.ibatis.jdbc.SQL;
import service.StoreGoodsService;
import service.StoreGoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StoreGoods extends HttpServlet {
    public  void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected static StoreGoodsServiceImpl storeGoodsService=new StoreGoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //链接
        Connection conn = null;
        //接口
        PreparedStatement ps = null;
        //结果
        ResultSet rs = null;
        try {
//            List<StoreGoods> userList = new ArrayList<>();
            //驱动获得链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1212/shop", "root", "123456");
            ps = conn.prepareStatement("INSERT INTO store_goods (GOODS_NAME ,GOODS_NUM ) VALUES (?,? )");
//            ps=conn.createStatement("insert");
            //执行命令
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("userName");
                String number = rs.getString("userNum");
//                User user = new User(name, number);
//                userList.add(user);
            }
//            req.setAttribute("userList", userList);
            req.getRequestDispatcher("StoreGoods.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(ps !=null){
                    ps.close();
                }
                if(conn !=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}


