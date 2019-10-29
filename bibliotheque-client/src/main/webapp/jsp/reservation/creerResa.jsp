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

        em
        {
            color : white;
        }


        #cadrePret
        {
            margin-top: 50px;
            margin-bottom: 20px;
        }
        #cadreResa
        {
            margin-top: 50px;
        }
        #bottom
        {
            display: flex;
            justify-content: space-around;
        }

        #tableau
        {
            border: 1px gray solid;
        }
        tr,td
        {
            text-align: center;
        }
        #label
        {
            float: left;
            font-size: 1.3em;
            margin: 10px;
            font-weight: bold;
        }
        #labelResa
        {
            float: left;
            font-size: 1.3em;
            margin: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<header>
    <%@ include file="../_include/header.jsp"%>
</header>
<div id="page">
    <div id="bottom">
        <div id="cadrePret" class="col-7" >
            <label class="form-check-label" id="label"> Les exemplaires en cours de prêt </label>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">Numéro interne</th>
                    <th scope="col">Date de restitution</th>
                    <th scope="col">Prolongable</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="pretList">
                    <s:if test="plusTot">
                        <tr style="border : 2px solid orange">
                            <td><s:property value="livreUnique.numero"/></td>
                            <td><s:property value="dateRestitution"/></td>
                            <td>
                                <s:if test="prolongation">Non</s:if>
                                <s:else>Oui</s:else>
                            </td>
                        </tr>
                    </s:if>
                    <s:else>
                        <tr>
                            <td><s:property value="livreUnique.numero"/></td>
                            <td><s:property value="dateRestitution"/></td>
                            <td>
                                <s:if test="prolongation">Non</s:if>
                                <s:else>Oui</s:else>
                            </td>
                        </tr>
                    </s:else>

                </s:iterator>
                </tbody>
            </table>
            <em id="legende" style="font-size: 0.6em;color: gray">
                Le retour le plus tot prévue dans la bibliothèque est encadré en orange
            </em>
        </div>
        <div id="cadreResa" class="col-3 card text-center" style="padding-bottom: 15px">
            <label class="form-check-label" id="labelResa"> Votre réservation </label>
            <div style="width: 100%" class="card-body">
                <p style="margin-top: 20px">Personne(s) dans la file : <s:property value="nbreFile"/></p>
                <p>Durée estimée : <s:property value="duree"/></p>
            </div>
            <div>
            <s:a action="reserver"  class="btn btn-outline-info">
                <s:param name="livreId" value="livreId"/>
                <s:param name="bibliothequeId" value="bibliothequeId"/>
                Valider la réservation </s:a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

