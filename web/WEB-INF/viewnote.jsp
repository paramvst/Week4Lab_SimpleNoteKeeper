<%-- 
    Document   : viewnote
    Created on : 27-Sep-2022, 2:47:29 PM
    Author     : param
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2> View Note </h2>
        
        <form method="post"  action="note">
            <p><b>Title:</b>[$Note.title]<br>
                <b>Contents:</b>[$Note.contents]
            </p>
        </form>
        
        <a href="note?edit">Edit</a>
    </body>
</html>
