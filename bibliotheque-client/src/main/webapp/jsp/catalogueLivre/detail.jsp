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

        em
        {
            color : gray;
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
        #cadreLivre
        {
            width: 100%;
            height: 435px;
            border: darkgray 1px solid;
        }
        #cadreInfoDispo{
            border: darkgray 1px solid;
        }
        #cadreBtn
        {
            display: flex;
            justify-content: space-around;
        }
        span
        {
            color: dodgerblue;
        }

    </style>
</head>
<body>
<header>
    <%@ include file="../_include/header.jsp"%>
</header>

</div>

<div id="page">
    <div id="bottom" >
        <div id="cadrePret" class="col-9">
            <label class="form-check-label" id="labelRecherche"> Détails du livre </label>
            <div class="col-12 container bg-light" id="cadreLivre">
                <section class="row">
                <div  class="col-3" style="margin-top: 15px;text-align: center">
                <img  src="../image/<s:property value="illustration.url"/>" class="border border-secondary" style="height: 400px"
                     alt="<s:property value="illustration.description"/>">
                </div>
                <div class="col-5" style="margin-top: 20px;text-align: center">
                    <p style="text-align: center;font-size: 1.2em"><em>Informations sur le produit</em></p>
                    <p><em>Titre :  </em><s:property value="livre.titre"/></p>
                    <p><em>Auteur :  </em><s:property value="livre.auteur"/></p>
                    <p><em>Editeur :  </em><s:property value="livre.editeur"/></p>
                    <p><em>Catégorie :  </em><s:property value="categorie.nom"/></p>
                    <p><em>Langue :  </em><s:property value="livre.langue"/></p>
                    <p><em>Date de parution :  </em><s:property value="livre.dateDeCreation"/></p>
                    <p><em>ISBN-13 :  </em><s:property value="livre.isbn"/></p>
                </div>
                <div class="col-4 border-left" style="margin-top: 20px;">
                    <p style="text-align: center;font-size: 1.2em"><em>Résumé du livre</em></p>
                    <div class="border border-info" style="overflow:auto;height: 300px;padding: 10px;font-style: italic"><s:property value="livre.resume"/></div>
                </div>
                </section>
            </div>
            <div class="col-12 container " id="cadreBtn">
                <button type="button" class="btn btn-outline-info" id="btnDispo" style="font-size:0.7em;margin: 15px">
                    Voir la disponiblité du livre dans les bibliothèques
                </button>
            </div>
            <div class="col-12 container" id="cadreInfoDispo" style="padding-top: 15px;">
                <s:iterator value="livreList" status="list">
                    <s:if test="%{#list.count == 1}">
                        <p style="display: flex;justify-content: space-around"><em style="width: 250px">Bibliothèque de la gare :</em>
                        <span><s:property value="nbreDispo"/></span>
                            livres disponibles
                            <s:if test="reservable && nbreDispo == 0">
                                <s:if test="#session.user">
                                    <s:a action="editResa"  class="btn btn-outline-info">
                                        <s:param name="livreId" value="id"/>
                                        <s:param name="bibliothequeId" value="1"/>
                                        Réserver </s:a>
                                </s:if>
                                <s:else><s:a action="login"  class="btn btn-outline-info"> Réserver </s:a></s:else>
                            </s:if>
                            <s:else>
                                <button type="button" class="btn btn-outline-info" disabled> Réserver </button>
                            </s:else>
                        </p>
                    </s:if>
                    <s:elseif test="%{#list.count == 2}">
                        <p style="display: flex;justify-content: space-around"><em style="width: 250px">Bibliothèque du centre ville :</em> <span><s:property value="nbreDispo"/></span>
                            livres disponibles
                            <s:if test="reservable && nbreDispo == 0">
                                <s:if test="#session.user">
                                    <s:a action="editResa"  class="btn btn-outline-info">
                                        <s:param name="livreId" value="id"/>
                                        <s:param name="bibliothequeId" value="2"/>
                                        Réserver </s:a>
                                </s:if>
                                <s:else><s:a action="login"  class="btn btn-outline-info"> Réserver </s:a></s:else>
                            </s:if>
                            <s:else>
                                <button type="button" class="btn btn-outline-info" disabled> Réserver </button>
                            </s:else>
                        </p>
                    </s:elseif>
                    <s:elseif test="%{#list.count == 3}">
                        <p style="display: flex;justify-content: space-around"><em style="width: 250px">Bibliothèque du port marchand :</em> <span><s:property value="nbreDispo"/></span>
                            livres disponibles
                            <s:if test="reservable && nbreDispo == 0">
                                <s:if test="#session.user">
                                    <s:a action="editResa"  class="btn btn-outline-info">
                                        <s:param name="livreId" value="id"/>
                                        <s:param name="bibliothequeId" value="3"/>
                                        Réserver </s:a>
                                </s:if>
                                <s:else><s:a action="login"  class="btn btn-outline-info"> Réserver </s:a></s:else>
                            </s:if>
                            <s:else>
                                <button type="button" class="btn btn-outline-info" disabled> Réserver </button>
                            </s:else>
                        </p>
                    </s:elseif>
                </s:iterator>
            </div>
            <em id="legende" style="font-size: 0.6em;color: gray">
            Pour réserver ces conditions doivent être remplies : <br/>
            - Aucun prêt en cours sur ce livre. <br/>
            - Aucune réservation en cours sur ce livre. <br/>
            - Le nombre de réservation limite n'est pas dépassé pour le livre dans la bibliothèque.
            </em>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(function() {
        $("#cadreInfoDispo").hide();
        $("#legende").hide();
    });

    $("#btnDispo").click(function() {
        $("#cadreInfoDispo").slideDown();
        $("#legende").show();
        $("#btnDispo").hide();
        $("html, body").animate({ scrollTop: $(document).height() }, 1000);
    });
</script>
</body>
</html>