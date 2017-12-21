<%--
  Created by IntelliJ IDEA.
  User: Arnold
  Date: 2017/12/11
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC的数据类型转换</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="resources/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="resources/json2.js"></script>

</head>
<body>
<form action="register" method="post">
    日期类型：<input type="text" name="birthday" /> <br><br>
    整数类型：<input type="text" name="total" /> <br><br>
    百分数类型：<input type="text" name="discount" /><br><br>
    货币类型：<input type="text" name="money" /><br><br>
    <input type="submit" value="提交" />
</form>
</body>
</html>
