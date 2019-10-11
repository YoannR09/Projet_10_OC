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
    <%@ include file="./_include/head.jsp"%>
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
        #cadrePret
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
            font-size: 1.5em;
            margin: 10px;
            font-weight: bold;
        }
        #cadreCategorie
        {
            width: 100%;
            border: darkgray 1px solid;
            text-align: center;
        }
        #cadreUnique
        {
            margin: 10px;
        }

        #cadreUnique:hover
        {
            background-color: gray;
        }

    </style>
</head>
<body>
<header>
    <%@ include file="./_include/header.jsp"%>
</header>

</div>

<div id="page">
    <div id="bottom" >
        <div id="cadrePret" class=" col-xl-10 col-lg-12 col-md-12 col-sm-12">
            <label class="form-check-label" id="labelRecherche"> Nos  catégories </label>
            <div class="col-12 container bg-light" id="cadreCategorie">
                <section class="row "  style="display: flex;justify-content: space-around">
                    <s:iterator value="categorieList" status="list">
                        <div class="card col-2 text-white bg-dark" id="cadreUnique" style="padding-top: 10px">
                            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner" style="height: 100%">
                                    <s:if test="%{#list.count == 1}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre1.jpg"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre2.jpg"
                                                 alt="Second slide">
                                        </div>
                                    </s:if>
                                    <s:elseif test="%{#list.count == 2}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre3.jpg"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 3}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre4.jpg"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre5.jpg"
                                                 alt="Second slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 4}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre6.jpg"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 5}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre7.jpg"
                                                 alt="First slide">
                                        </div>
                                    <section/>
                                    <section class="row "  style="display: flex;justify-content: space-around">
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 6}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre8.jpg"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 7}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre9.jpg"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre10.jpg"
                                                 alt="Second slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 8}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre11.jpg"
                                                 alt="First slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 9}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre12.jpg"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre13.jpg"
                                                 alt="Second slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre14.jpg"
                                                 alt="Third slide">
                                        </div>
                                    </s:elseif>
                                    <s:elseif test="%{#list.count == 10}">
                                        <div class="carousel-item active" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre15.jpg"
                                                 alt="First slide">
                                        </div>
                                        <div class="carousel-item" style="width: 100%;height: 100%">
                                            <img class="d-block w-100" src="./image/livre16.jpg"
                                                 alt="Second slide">
                                        </div>
                                    </s:elseif>
                                </div>
                            </div>
                            <div style="width: 100%;margin-top: 10px">
                                <s:a action="doRechercheLivreCategorie" class="btn btn-outline-info text-center" style="font-size: 0.8em;font-weight: bold;width: 100%;height: 50px;margin-bottom:10px"><s:property value="nom"/><s:param value="id" name="categorieId"/></s:a>
                            </div>
                        </div>
                    </s:iterator>
                </section>
            </div>
        </div>
    </div>
</div>
<s:if test="hasActionMessages()">
<div class="modal fade" id="popUpAdresse" tabindex="-1" role="dialog" aria-labelledby="popUpAdresse" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document" >
        <div class="modal-content" style="border-left: deepskyblue 4px solid ">
            <div class="modal-body">
                <div class="col-12 container" id="cadreInfoDispo">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <em id="messageModal" style="color:black;font-weight: 900;"><s:actionmessage/></em>
                </div>
            </div>
        </div>
    </div>
</div>
</s:if>
<button type="button" id="btnModal" class="btn btn-outline-info" data-toggle="modal" data-target="#popUpAdresse" style="font-size:0.7em;margin: 15px">
</button>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(function() {
        $('#btnModal').hide();
            $('#btnModal').click();
    });
</script>
</html>