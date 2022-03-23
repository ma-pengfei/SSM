<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>查询结果</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            //当页面加载后，就获取数据
            loadStudentData();

            $("#btn").click(function (){
                loadStudentData();
            })
        })
        function loadStudentData(){
            $.ajax({
                url:"student/listStudent",
                type:"get",
                dataType:"json",
                success:function (data){
                    //清除旧有数据
                    $("#info").html("");
                    //显示新的数据
                    $.each(data,function (i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age +"</td>")
                            .append("<td>"+n.email+"</td>")
                            .append("<tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <input type="button" id="btn" value="查询">
    <table  border="1px">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>email</th>
        </tr>
        <tbody id="info">
        </tbody>
    </table>
</div>
</body>
</html>
