<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <html>

    <head>
        <title>Sample JSP Program</title>
    </head>

    <body>
        <h2>User AccountID = ${obj1.accountId}</h2>
        <h2>ACCOUNT HOLDER = ${holdername}</h2>
        <h2>ACCOUNT BALANCE = ${obj1.money}</h2>


        <form action="home"><br>
            <input type="submit" value="menu"><br>
        </form>
        

    </body>

    </html>