<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>注册页面</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <form action="student/addStudent" method="post">
            <table cellspacing="0" border="1px">
                <tr>
                    <th>name</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>age</th>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <th>email</th>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <th>提交</th>
                    <td><input type="submit" value="点击注册"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
