<%--
  Created by IntelliJ IDEA.
  User: El-ra
  Date: 28/06/2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <style type="text/css">
        #page {
            display: flex;
            justify-content: space-around;
        }
        em
        {
            color : white;
        }
        *
        {
            font-family: "Microsoft YaHei UI Light";
        }
        #cadreLogin
        {
            margin-top: 50px;
            margin-bottom: 20px;
        }
        #bottom
        {
            display: flex;
            justify-content: space-around;
            width: 100%;
        }
        #labelRecherche
        {
            left: 10px;
            font-size: 1.2em;
            margin: 10px;
            font-weight: bold;
        }
        #cadreLog
        {
            width: 100%;
            border: darkgray 1px solid;
            padding: 20px ;
        }


    </style>
</head>
<body>
<header>
    <%@ include file="../_include/header.jsp"%>
</header>

<div id="page">
    <div id="bottom" >

        <div id="cadreLogin" class="col-4">
            <label class="form-check-label" id="labelRecherche"> Un problème est survenu  </label>
            <div class="col-12 container bg-light" id="cadreLog">
                <s:actionmessage/>
            </div>
        </div>
    </div>
</div>
</body>
</html>