<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="service.*" %>
<%@ page import="entity.*" %><%--
  Created by IntelliJ IDEA.
  User: jiangxiangwen
  Date: 2018/1/30
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/myshopping_css.css" type="text/css">
    <title>My Shopping</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="body_div">

<%--左侧栏--%>
<div class="left_div float_left">
    <div class="logo_img">
        <img src="../images/shoppingLoge.png"/>
    </div>

</div>


<%--右侧栏--%>
<div class="right_div float_right">
<%--导航栏--%>
    <div class="nav">
        <%--导航栏左侧--%>
        <div class="left_nav float_left">

            <ul class="nav_div_ul">
                <li>MyShopping</li>
                <li><a href="#">首页</a></li>
                <li style="float: left"><a href="#">账户设置</a></li>
                <li><a>消息</a></li>
            </ul>
        </div>

        <%--导航栏右侧--%>
        <div class="right_nav float_right">
            <%--搜索框--%>
            <input type="text" name="search" value=""/>
            <button type="button">搜索</button>
        </div>
    </div>
<%--清楚浮动--%>
    <div class="clear"></div>


    <%--用户信息--%>
    <div class="user_info_div">

            <%--用户名--%>

            <h2> ${user.userAccountName}  <span class="user_register_date" > 注册日期： ${user.registerTime}</span></h2>

            <p>账户余额：${user.money}</p>

    </div>
<br/>

    <%--用户订单信息--%>
    <div class="user_order_info">
        <h3>我的订单</h3>
        <div>
            <%--获得订单的集合--%>
            <%--<%List<OrderInfo> list=(List<OrderInfo>) request.getAttribute("list");   %>--%>
            <div>
                <table class="order_info_table" cellpadding="0" cellspacing="0">
                    <tr>
                        <td>订单号</td>
                        <td>商品图片</td>
                        <td>商品名称</td>
                        <td>商品数量</td>
                        <td>收货人</td>
                        <td>金额</td>
                        <td>订单状态</td>
                    </tr>

                    <c:forEach items="${list}" var="order">
                    <tr>
                        <td>
                            ${order.orderNum}
                            <br/>
                            <span>${order.orderTime}</span>
                        </td>
                        <td>
                            <img src="..\images\vaida.jpg"alt="商品图片">
                        </td>
                        <td class="order_id" id="order_id">
                            ${order.id}
                        </td>
                        <td>
                                ${order.goodsInfo}
                        </td>
                        <td>
                                ${order.goodsInfo}
                        </td>
                        <td>
                                ${order.goodsSumMoney}
                        </td>
                        <td>
                            <c:if test="${order.orderStatus eq 1}">
                                        <a href="${pageContext.request.contextPath}/pay?orderid=${order.id}" style="margin-left:30%;">
                                                ${order.orderStatus}
                                        </a>
                            </c:if>
                            <c:choose>
                                <c:when test="${order.orderStatus ne 1}">
                                    ${order.orderStatus}
                                </c:when>

                            </c:choose>
                        </td>
                    </tr>

                    </c:forEach>
                </table>
            </div>

        </div>
    </div>

</div>


</div>
<script type="text/javascript">
    $(function () {
        $(".order_id").each(function () {
                var goodsid=$(this);
                var id=goodsid.text().trim();
                $.ajax({
                    type:"post",
                    dataType:"text",
                    url:"${pageContext.request.contextPath}/findGoods?i="+id,
                    contentType:"application/x-www-form-urlencoded",
                    success:function (x) {
                        goodsid.html(x);
                    }
                })
        }
        )
    })

</script>
</body>
</html>
