<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: WuJuNan
  Date: 2018/1/30
  Time: 16:58
--%>
<html>
<head>
    <meta charset="UTF-8">
    <link href="login_style/Register.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/Register.js"></script>
    <title>用户注册</title>
</head>
<body>
    <form action="register.do" method="post">
        <div>
            <table>
                <tr>
                    <td colspan="3"><h2>用户注册</h2></td>
                </tr>
                <tr>
                    <td width="50px" title="请输入用户名">帐 号</td>
                    <td width="150px"><input type="text" name="userName" value="" id="userName"></td>
                    <td width="150px">
                        <% String error1 = (String)request.getAttribute("registerErrorOne"); %>
                        <span><%=error1==null ? "" : error1%></span>
                    </td>
                </tr>
                <tr>
                    <td title="请输入用户名">密 码</td>
                    <td><input type="password" name="passWord" value="" id="passWord"></td>
                    <td>
                        <% String error2 = (String)request.getAttribute("registerErrorTwo"); %>
                        <span><%=error2==null ? "" : error2%></span>
                    </td>
                </tr>
                <tr>
                    <td title="请输入用户名">重 复</td>
                    <td><input type="password" name="repeatPwd" value="" id="repeatPwd"></td>
                    <td>
                        <% String error3 = (String)request.getAttribute("registerErrorThree"); %>
                        <span><%=error3==null ? "" : error3%></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="checkbox" name="remember" value=<""> id="remember">我接受用户协议</td>
                    <td>
                        <% String error4 = (String)request.getAttribute("registerErrorFour"); %>
                        <span><%=error4==null ? "" : error3%></span>
                    </td>
                </tr>
                <tr>
                    <td><button type="submit">注册</button></td>
                    <td><button type="reset">重置</button></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
