<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<html>
    <head>
        <title>ログイン</title>
    </head>
    <body>
    <form:form modelAttribute="loginForm" action="doLogin" method="post">
        <form:label path="id">ID:</form:label>
        <form:input path="id" /><br>
        <form:label path="password">PASS:</form:label>
        <form:input path="password" /><br>
        <input type="submit" value="送信">
    </form:form>
    </body>
</html>
