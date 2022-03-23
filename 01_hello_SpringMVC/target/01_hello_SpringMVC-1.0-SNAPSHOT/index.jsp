<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc项目</p>
    <p><a href="test/first.do">发起some.do请求</a></p>
    <form action="test/second.do" method="post">
        <input type="text" name="username"/>
        <input type="submit" value="发起second.do请求"/>
    </form>

    <form action="test/third.do" method="post">
        username <input type="text" name="username"/><br>
        password <input type="text" name="password"/><br>
        age <input type="text" name="age"/><br>
        <input type="submit" value="发起third.do请求"/>
    </form>

    <form action="test/third.do" method="post">
        username <input type="text" name="username1"/><br>
        password <input type="text" name="password1"/><br>
        age <input type="text" name="age1"/><br>
        <input type="submit" value="发起third.do请求"/>
    </form>

    <form action="test/fourth.do" method="post">
        username <input type="text" name="username"/><br>
        password <input type="text" name="password"/><br>
        age <input type="text" name="age"/><br>
        <input type="submit" value="发起fourth.do请求"/>
    </form>

    <form action="returnString-view.do" method="post">
        username <input type="text" name="username"/><br>
        password <input type="text" name="password"/><br>
        age <input type="text" name="age"/><br>
        <input type="submit" value="发起fourth.do请求"/>
    </form>

    <form action="exception.do" method="post">
        name <input type="text" name="name"/><br>
        age <input type="text" name="age"/><br>
        <input type="submit" value="发起exception.do请求"/>
    </form>

    <img src="images/p1.jpg" alt="静态资源，不能访问">
</body>
</html>
