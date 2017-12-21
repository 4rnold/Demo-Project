<%@page pageEncoding="utf-8"
        contentType="text/html;charset=utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试AnnotationFormatterFactory</title>
</head>
<body>
<h3>测试表单数据格式化</h3>
<%--@elvariable id="user" type="com.arnold.databinder.Formatter.OutputFormatterExample.model.User"--%>
<form:form modelAttribute="user" method="post" action="" >
    <table>
        <tr>
            <td>日期类型:</td>

            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td>整数类型:</td>
            <td><form:input path="total"/></td>
        </tr>
        <tr>
            <td>百分数类型:</td>
            <td><form:input path="discount"/></td>
        </tr>
        <tr>
            <td>货币类型:</td>
            <td><form:input path="money"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>