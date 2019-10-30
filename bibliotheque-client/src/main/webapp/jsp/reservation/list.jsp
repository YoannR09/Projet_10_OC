<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: El-ra
  Date: 17/06/2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp"%>
    <style type="text/css">
        *
        {
            font-family: "Microsoft YaHei UI Light";
        }
        #bloc
        {
            margin: 20px;
            text-align: center;
        }

        em
        {
            color : white;
        }
        #barreDeRecherche
        {
            width: 100%;
            margin-top: 50px;
            height: 60px;
            padding-top: 10px;
            border: 1px gray solid;
            display: flex;
            justify-content: center;
        }
        #textCodeISBN,#textEditeur,#textTitre,#textEmail,#textNom,#textPrenom,#textPseudo
        {
            margin-left: 5px;
            margin-right: 5px;
        }
        #selectBibliotheque
        {
            margin-left: 10px;
            margin-right: 10px;
        }
        #btnRecherche
        {
            margin-right: 10px;
        }
        #cadreResaDispo
        {
            margin-top: 50px;
            margin-bottom: 20px;
        }
        #cadreResaNonDispo
        {
            margin-top: 50px;
            margin-bottom: 20px;
        }
        #labelRecherche
        {
            float: left;
            font-size: 1.3em;
            margin: 10px;
            font-weight: bold;
        }
        #tableau
        {
            border: 1px gray solid;
        }
        tr,td
        {
            text-align: center;
        }

        #tdBtnRenouv,#tdBtnSuppr, #thBtnRenouv,#thBtnSuppr
        {
            border-left: 1px solid darkgray;
            border-right: 1px solid darkgray;
            background-color: whitesmoke;
        }
        #labelInfo
        {
            float: right;
            font-size: 1.1em;
            margin-top: 15px;
        }
        #message
        {
            float: right;
            font-size: 1.1em;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<header>
    <%@ include file="../_include/header.jsp"%>
</header>
<div id="page" class="col-12" style="display: flex;justify-content: space-around;">
    <div id="bottom">
        <div id="cadreResaDispo" class="col-12" >
            <label class="form-check-label" id="labelRecherche"> Réservation en cours disponible au prêt </label>
            <em id="message" class="text-info"><s:actionmessage/></em>
            <s:if test="listResaDispo.empty">
                <label class="form-check-label" id="labelInfo"><em style="color: darkgray">Aucune réservation en cours</em></label>
            </s:if>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">Titre du livre</th>
                    <th scope="col">ISBN</th>
                    <th scope="col">Bibliothèque</th>
                    <th scope="col" id="thBtnRenouv"> Commencer le prêt </th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="listResaDispo">
                    <tr>
                        <td><s:property value="livre.titre"/></td>
                        <td><s:property value="livre.isbn"/></td>
                        <td><s:property value="bibliotheque.nom"/></td>
                        <td><s:a action="addPretResa" class="btn btn-info" style="font-size:0.6em;">
                            <i class="fas fa-arrow-alt-circle-right"></i>
                            <s:param name="reservationId" value="id"/>
                            <s:param name="livreUniqueId" value="livreUniqueId"/>
                            <s:param name="abonneId" value="abonneId"/>
                        </s:a></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div id="cadreResaNonDispo" class="col-12" >
            <label class="form-check-label" id="labelRecherche"> Réservation en attente </label>
            <em id="message" class="text-info"><s:actionmessage/></em>
            <s:if test="listResaNonDispo.empty">
                <label class="form-check-label" id="labelInfo"><em style="color: darkgray">Aucune réservation en cours</em></label>
            </s:if>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">Titre du livre</th>
                    <th scope="col">ISBN</th>
                    <th scope="col">Bibliothèque</th>
                    <th scope="col">Position dans la file</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="listResaNonDispo">
                    <tr>
                        <td><s:property value="livre.titre"/></td>
                        <td><s:property value="livre.isbn"/></td>
                        <td><s:property value="bibliotheque.nom"/></td>
                        <td><s:property value="position"/></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

