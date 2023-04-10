<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <html>

    <head>
        <title>Sample JSP Program</title>
    </head>

    <body>
        <form action="transfered"><br>
            <input type="text" name="debitid" placeholder="debitid" path="amount"><br>
            <input type="text" name="creditid" placeholder="creditid"><br>
            <input type="text" name="amount" placeholder="amount"><br>
            <br>

            <input type="submit" value="submit"><br>

        </form>
        <h1>Welcome to my JSP Program</h1>
        ${obj.money}
    </body>

    </html>