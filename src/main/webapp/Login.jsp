<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: WuJuNan
  Date: 2018/1/30
  Time: 17:00
--%>
<html>
<head>
    <meta charset="UTF-8">
    <!--引入样式文件-->
    <link href="css/Login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/Login.js"></script>
    <title>用户登录</title>
</head>
<body>
    <!--添加背景音乐-->
    <audio src="music/login.wav" autoplay="autoplay" loop="loop"></audio></br>
    <form action="login.do" method="post">
        <div>
            <table>
                <tr>
                    <td colspan="3"><h2>登录</h2></td>
                </tr>
                <tr>
                    <td title="用户名">帐 号</td>
                    <td><input type="text" name="userName" id="userName" value="" title="请输入用户名"></td>
                    <td width="150px">
                        <% String loginError1 = (String)request.getAttribute("loginErrorOne"); %>
                        <span><%=loginError1==null ? "" : loginError1%></span>
                    </td>
                </tr>
                <tr>
                    <td title="密码">密 码</td>
                    <td><input type="password" name="passWord" id="passWord" value="" title="请输入密码"></td>
                    <td>
                        <% String loginError2 = (String)request.getAttribute("loginErrorTwo"); %>
                        <span><%=loginError2==null ? "" : loginError2%></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="checkbox" name="remember" value="" id="remember">记住密码</td>
                    <td>
                        <% String loginError3 = (String)request.getAttribute("loginErrorThree"); %>
                        <span><%=loginError3==null ? "" : loginError3%></span>
                    </td>
                </tr>
                <tr class="login2">
                    <td> <button type="submit">登 录</button></td>
                    <td><button type="button" onclick="register()">注 册</button></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
