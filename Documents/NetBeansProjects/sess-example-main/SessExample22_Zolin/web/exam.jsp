<%-- 
    Document   : exam
    Created on : 31 мар. 2022 г., 18:10:42
    Author     : Trifonov
--%>
<%@page import="beans.Exam"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование экзамена</title>
    </head>
    <body>
        <form action='#' method="post">
            <jsp:useBean id="exam" class="beans.Exam" scope="page" />

            <c:if test="${empty param.create}" >
                <br/>
            </c:if> 
            <c:if test="${empty param.rbt}" >
                ${exam.subject.setCon(sessionScope.DataSource, param.rbt)}
            </c:if> 

            <table>
                <c:choose>
                    <c:when test="${empty param.create}">
                        <tr> <th colspan="2" align="center">Редактирование экзамена </th> </tr> 
                            </c:when>
                            <c:otherwise>
                        <tr> <th colspan="2" align="center">Новый экзамен </th> </tr> 
                            </c:otherwise>
                        </c:choose>
                <tr>
                    <td align="right">Студент:</td> 
                    <td align="left" ><div name="stud" style="border: 1px black solid; height: 20px; width: 200px;">${exam.stud.lastName}</div> </td>
                    <td><input type="submit" name='studsel' value='Выбрать' formMethod="get" formAction=""/></td> 
                </tr> 
                <tr>
                    <td align="right">Дисципл:</td> 
                    <td align="left" ><div name="subject" style="border: 1px black solid; height: 20px; width: 200px;">${exam.subject.name}</div></td>
                    <td><input type="submit" name="subsel" value='Выбрать' formMethod="get" formAction="subdir.jsp"/></td> 
                        <%
                            Exam ex = (Exam) session.getAttribute("exam");
                            System.out.println("" + ex.getSubject().getName());

                        %>
                </tr>
                <tr>
                    <td align="right">Дата:</td> 
                    <td align="left" ><input type="text" name='date' value='${exam.examDate.toString()}' /> </td>

                </tr> 
                <tr>
                    <td align="right">Оценка:</td> 
                    <td align="left" ><input type="text" name='date' value='${exam.mark}' /> </td>

                </tr> 
                <tr>
                    <td align="right"><input type="submit" name='save' value='Сохранить' formMethod="post" formAction="subsave"/></td> 
                    <td align="left"><input type="submit" name='cancel' value='Отмена' formMethod="post" formAction="exam.jsp"/></td>
                </tr>   
            </table>
            <input type="hidden" name="subid" value="${exam.subject.subjectId}" />
           <!-- <input type="hidden" name="id" value="${param.id}" />-->
        </form>

    </body>
</html>
