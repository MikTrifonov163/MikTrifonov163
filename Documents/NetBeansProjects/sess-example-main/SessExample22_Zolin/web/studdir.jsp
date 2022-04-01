<%-- 
    Document   : studdir
    Created on : 31 мар. 2022 г., 20:02:15
    Author     : Trifonov
--%>

<<%@page import="beans.Stud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Справочник Студетнов</title>
    </head>
    <body>
        <%request.setCharacterEncoding("UTF-8");%>

        <jsp:useBean id="studDir" class="beans.StudDir" scope="session" />

        <c:if test="${!empty param.findstr}" var="val" scope="session">
            ${studDir.setFindStr(param.findstr)}
            ${studDir.fill(sessionScope.DataSource)}
        </c:if>

        <h1>Справочник Студетнов</h1>
        <!-- форма поиска -->
        <form action="studdir.jsp" method="get">
            <table>
                <tr>
                    <td align="left">Поиск:&nbsp;<input type="text" name="findstr" value="" /></td>
                    <td align="left"><input type="submit" value="Найти"></td>
                </tr>
            </table>
        </form><hr/>
        <form action="#" method="get">
            <table>
                <tr>
                    <td align="left"><input type="submit" value="Выбрать..." formMethod="get" formAction="exam.jsp"/></td>
                    <td align="left"><input type="submit" name="create" value="Создать..." formMethod="get" formAction="stud.jsp"/></td>
                </tr>
            </table>
        </form>
        <hr/>
        <table border="1">
            <th>()</th><th>Имя</th><th>Фамилия</th><th>ред</th><th>del</th>
                <c:forEach var="stud" items="${studDir.studs}" >
                    <jsp:useBean id="stud" class="beans.Stud" scope="page" />
                <tr>
                    <td><input type="radio" name="rbt" value="${stud.studId}" /></td>
                    <td>${stud.firstName}</td>
                    <td>${stud.lastName}</td>
                    <td><a href="stud.jsp?id=${stud.studId}">Изменить</a></td>
                    <td><a href="studDel?id=${stud.studId}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>

</html>
