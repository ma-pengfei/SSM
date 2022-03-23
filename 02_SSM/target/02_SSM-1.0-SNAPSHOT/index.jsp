<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>学生信息管理系统</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <p>SSM整合</p>
        <img src="images/Ori3.png" alt="图片已丢失" width="500px">
        <table>
            <tr>
                <th><a href="addStudent.jsp">学生注册</a></th>
                <th><a href="listStudent.jsp">浏览学生</a></th>
            </tr>
        </table>
    </div>
</body>
</html>
