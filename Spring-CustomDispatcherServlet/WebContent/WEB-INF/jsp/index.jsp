<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

   <body bgcolor="#DDDDDD">
<h2>Spring MVC DispatcherServlet Example</h2>
        <table align="center" style="font-weight:bold;">
            <tr>
                <td>Student Name </td>
                <td>${name}</td>
            </tr>
            <tr>
                <td>Age </td>
                <td>${age}</td>
            </tr>
            <tr>
                <td>Branch </td>
                <td>${email}</td>
            </tr>

        </table>

    </body>
</html>
