<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: xwszt
  Date: 2017/8/6
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
</head>
<body>
<div style="text-align:center;margin-top:360px;">
    <font style="color:green;font-weight:bold;font-size: 18px"><%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())%></font><br><br>
    <font style="color:red;font-weight:bold;font-size: 27px">每次刷新页面，如果时间是变动的，则说明该页面没有被缓存或缓存已经过期，否则则说明该页面已经被缓存。</font>
</div>
</body>

</body>
</html>