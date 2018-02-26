<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.StoreGoods" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: wujiancheng
  Date: 2018/1/30 0030
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="" %>--%>
<% StoreGoods storeGoods= (StoreGoods) request.getAttribute("1");%>
<html>
<head>
    <title>购买商品页面</title>
    <link href="../css/StoreGoods.css " rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>

    </head>
<body>
<form action="/Buy.htm" method="post">
<%--< c:forEach item="${seller}" var="seller">--%>
    <%--<div><img src="images/popo%20(2).jpg">--%>
<%--设置图片和文字位置浮动--%>
<div class="subject">
    <div class="main">
        <%
            //链接
            Connection conn = null;
            //接口
            PreparedStatement ps = null;
            //结果
            ResultSet rs = null;
            try {
//                List<StoreGoods> userList = new ArrayList<>();
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
//                req.setAttribute("userList", userList);
//                req.getRequestDispatcher("StoreGoods.jsp").forward(req, resp);
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
        %>
        <div>
            <div class="float_left">
                <%--图片引用和大小--%>
                <img src="../images/vaida.jpg" width="350px" height="418px" /></div>
        </div>
        <p class="margin"></p>
        <div class="float_left">
            <div class="float_right">
                <div>
                    <div>
                        <%--商品购买详情--%>
                        <h1 class="margin2" >
                            <div id="page">Welcome</div>
                        </h1>
                    </div>
                    <div>
                        <b style="color: red" class="margin3" >
                            急件降急降！
                        </b>
                    </div>
                    <div>
                        <dl><dt class="margin3">运费:</dt></dl>
                        <div>
                            <span class="margin4">北上广</span>至
                            <span><span role="button" tabindex="1">&nbsp;成都</span></span>
                            <div>
                                <b><span class="margin3">快递: 0.00 </span></b>
                            </div>
                        </div>
                    </div>
                    <ul>
                        <li><span class="margin3">月销量:</span><span class="tm-count">22.0</span></li>
                        <li ><span class="margin3">累计评价:</span><span class="tm-count">35.0</span></li>
                    </ul>
                    <dl>
                        <dt class="margin3">颜色分类</dt>
                        <dd>
                            <ul>
                                <li>
                                    <a >
                                        <span class="margin4">男款白色</span>
                                    </a>
                                </li>
                                <li>
                                    <a >
                                        <span class="margin4">男款黑色</span>
                                    </a>
                                </li>
                            </ul>
                        </dd>
                    </dl>
                    <div>
                        <dt class="margin3">数量:</dt>
                        <%--<input class="margin3" maxlength="8" title="请输入购买量:" value="5"  type="text">--%>
                        <div class="know">
                            <input id="min"  class="margin3" type="button" value="-" />
                            <input id="text_box" name="StoreGoodsNumber" type="text" value="${item.value.quantity }" style="width:50px;" />
                            <input id="add"  type="button" value="+" /></td>
                            <span class="unit">件</span></span>
                            <em style="display: inline;" id="reptorpay" class="margin3">库存:   ${shop.GOODS_NUM} 件</em>
                        </div>

                        <div>
                            <div>
                                <a href="../jsp/the_shopping_cart.jsp" rel="nofollow" data-addfastbuy="true" title="点击此按钮，到下一步确认购买信息。" class="margin3">立即购买<span class="ensureText">确认</span></a>
                            </div>
                            <%--<div><a rel="nofollow"><i></i>加入购物车<span class="ensureText">确认</span></a></div>--%>
                            <%--<div><a rel="nofollow"><i></i>加入购物车</a></div>--%>
                            <button class="btn" type="button" name="购物车" style="background-color: red" class="margin4" ><a href="../jsp/the_shopping_cart.jsp" style="text-decoration: none">添加到购物车</a></button>
                            <button class="btn" type="button" name="购买" style="background-color: red" class="margin3"><a href="../jsp/the_shopping_cart.jsp" style="text-decoration: none">立即购买</a> </button>
                        </div>
                            <dl>
                                <dt class="margin3">服务承诺</dt>
                                <dd>
                                    <ul>
                                        <li class="margin4"><a href="http://www.baidu.com" target="_blank" >
                                            三包服务</a></li><li class="margin4"><a href="http://www.taobao.com" target="_blank" >
                                        正品保证</a></li><li class="margin4"><a href="http://www.taobao.com" target="_blank">
                                        极速退款</a></li><li class="margin4"><a href="http://www.baidu.com"  target="_blank">
                                        赠运费险</a></li><li class="margin4"><a href="http://www.baidu.com" target="_blank" >
                                        七天无理由退换</a></li>
                                    </ul>
                                </dd>
                            </dl>
                            <em class="margin3">支付方式</em>
                            <em style="display: inline;" title="显示所有信息" ></em>
                            <div >
                                <a target="_blank" href="http://www.baidu.com" class="margin4">信用卡</a>
                                <a href="../jsp/Payment.jsp" target="_blank" class="margin3" >快捷支付 <s style="background: url(images/vaida.jpg);"></s></a>
                                <a href="http://www.baidu.com" target="_blank" class="margin3">蚂蚁花呗 <s style="background: url(images/vaida.jpg);"></s></a>
                                <a href="http://www.baidu.com" target="_blank" class="margin3">余额宝 <s style="background: url(images/vaida.jpg);"></s></a>
                        </div>
                    </div>
                </div>
            </div>
            </p>
        </div>
    </div>
</div>
</form>
</body>
</html>
