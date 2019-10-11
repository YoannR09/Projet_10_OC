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

        #btnRecherche
        {
            margin-right: 10px;
        }
        #cadrePret
        {
            margin-top: 50px;
        }
        #bottom
        {
            display: flex;
            justify-content: space-around;
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
<div id="page">

    <div id="barreDeRecherche" class="bg-light">
        <s:form id="formulaire" action="rechercheAbonne" >
            <div class="input-group">
                <input id="textLivreUnique" name="livreUniqueId" type="text" class="form-control" value="<s:property value="livreUniqueId"/>" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textEmail" name="email" type="text" class="form-control" placeholder="Email" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textPseudo" name="pseudo" type="text" class="form-control" placeholder="Pseudo" aria-label="Recipient's username" aria-describedby="basic-addon2" >
                <input id="textNom" name="nom" type="text" class="form-control" placeholder="Nom" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input id="textPrenom" name="prenom" type="text" class="form-control" placeholder="Prénom" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <div>
                    <button type="submit" value="Rechercher" id="btnRecherche" class="btn btn-outline-info">Rechercher</button>
                </div>
            </div>
        </s:form>
    </div>
    <div id="bottom">
        <div id="cadrePret" class="col-9" >
            <label class="form-check-label" id="labelRecherche"> Ma recherche d'abonnés </label>
            <em id="message" class="text-info"><s:actionmessage/></em>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">Adresse mail</th>
                    <th scope="col">Pseudo</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="abonneList">
                    <tr>
                        <td><s:property value="email"/></td>
                        <td><s:property value="pseudo"/></td>
                        <td><s:property value="nom"/></td>
                        <td><s:property value="prenom"/></td>
                        <td id="tdBtnSelectionner"><s:a action="addPretLivreUnique" class="btn btn-info" style="font-size:0.6em;"><i class="fas fa-arrow-alt-circle-right"></i><s:param name="livreUniqueId" value="livreUniqueId"/><s:param name="abonneId" value="id"/> </s:a></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(function() {
        $('#textLivreUnique').hide();
    });
</script>
</body>
</html>

