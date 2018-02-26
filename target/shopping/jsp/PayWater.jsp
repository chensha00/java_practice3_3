<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="login_style/Paywater.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/Login.js"></script>
    <title>shoppingPayWater</title>
</head>
<body>
<div>
<h2> 谢谢您的打赏，支付成功！</h2>
<hr/>
<br>
</div>
<div class="mainpage">
    <div style="width: 700px" >
<table border="0">
      <tr>
          <td width="200px"><p>流水编号:</p></td>
          <td width="500px"><%=request.getParameter("payWaterNumber")%></td>
      </tr>
      <tr>
          <td><p>账户名称:</p></td>
          <td><%=request.getParameter("userAccountName")%></td>
      </tr>
      <tr>
          <td><p>交易时间:</p></td>
          <td><%=request.getParameter("transactionTime")%></td>
      </tr>
      <tr>
          <td><p>当前状态:</p></td>
          <td>支付成功</td>
      </tr>
    <tr>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td style="height:90px"><p>交易金额</p></td>
        <td><h1 style="font-size: 65px">¥<%=request.getParameter("transactionAmount")%></h1></td>
    </tr>
    <tr>
        <td style="height:50px"><p >距离小目标还有多少？</p></td>
        <td><h1 style="font-size:25px">¥1000000000-<%=request.getParameter("transactionAmount")%></h1></td>
    </tr>
</table>
    </div>
    <div style="width: 700px; float: right">
    <img src="img/paywater.jpg"  >
    </div>
</div>
<div>
    <br>
    <br>
    <br>
    <button type="button" onclick="register()">返回首页继续挑选</button>
</div>



</body>
</html>
