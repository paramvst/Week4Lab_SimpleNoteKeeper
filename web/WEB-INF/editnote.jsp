<%-- 
    Document   : editnote
    Created on : 27-Sep-2022, 2:47:40 PM
    Author     : param
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2> View Note </h2>
        
        <form method="post"  action="note">
            Title: <input type="text" name="formattedTitle" value="${note.title}">
            <br><br>
            <div>
            <div style="float: left">Contents: </div>
            <textarea name="formattedContents" row="500" cols="50">${note.contents}</textarea>
            </div>
            <input type="submit" value="Save">
        </form>
        
        <a href="note?edit">Edit</a>
    </body>
</html>
