<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30/030
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../css/Payment.css">
    <meta charset="UTF-8">
    <title>支付</title>
</head>
<body>

<div class="payImage">
    <img src="../images/payment.jpg" width="500px" height="400px">
</div>
<div class="info">
    <h2 align="center" >您正申请支付</h2>
    <div class="orderInfo" >
        <table border="1">
            <tr>
                <th>订单号：${order.orderNum}</th>
            </tr>
            <tr>
                <th> 收款方：${order.storeId}</th>
            </tr>
            <tr>
                <th>总金额：${order.goodsSumMoney}</th>
            </tr>
        </table>
    </div>
    <p></p>
    <div align="center" class="password">
        <form  id="payForm" name="payForm" action="" method="post">
            <input type="text" name="${account}" hidden>
            <h3>支付密码：<input type="password" name="${password}" required autofocus/> </h3>
            <input class="button" type="submit" name="submit" value="提交"/>
            <input class="button" type="reset" name="reset" value="重新输入"/>
        </form>
    </div>
</div>



</body>
</html>
