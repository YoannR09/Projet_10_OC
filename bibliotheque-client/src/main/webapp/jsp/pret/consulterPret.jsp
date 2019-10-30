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

        #tdBtnRenouv,#tdBtnSuppr, #thBtnRenouv,#thBtnSuppr
        {
            border-left: 1px solid darkgray;
            border-right: 1px solid darkgray;
            background-color: whitesmoke;
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
        <s:form id="formulaire" action="recherchePret" >
            <div class="input-group">
                <label class="form-check-label" style="margin: 7px">Rechercher via : </label>
                <div class="col-auto" style="margin: 7px">
                    <div class="input-group mb-2">
                        <div class="form-check form-check-inline">
                            <input id="btnAbonne" class="form-check-input" type="radio" name="recherche"  value="option1">
                            <label   class="form-check-label" for="btnAbonne">Abonnées</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input  id="btnLivre" class="form-check-input" type="radio" name="recherche" value="option2" checked>
                            <label class="form-check-label" for="btnLivre">Livres</label>
                        </div>
                    </div>
                </div>
                <span id="recherche"><s:property value="recherche"/></span>
                <input id="textTitre" name="titre" type="text" class="form-control" placeholder="Titre" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span id="lastTitre"><s:property value="titre"/></span>
                <input id="textAuteur" name="auteur" type="text" class="form-control" placeholder="Auteur" aria-label="Recipient's username" aria-describedby="basic-addon2" >
                <span id="lastAuteur"><s:property value="auteur"/></span>
                <input id="textCodeISBN" name="isbn" type="text" class="form-control" placeholder="Code ISBN" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span id="lastIsbn"><s:property value="isbn"/></span>
                <input id="textEmail" name="email" type="text" class="form-control" placeholder="Email" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span id="lastEmail"><s:property value="email"/></span>
                <input id="textPseudo" name="pseudo" type="text" class="form-control" placeholder="Pseudo" aria-label="Recipient's username" aria-describedby="basic-addon2" >
                <span id="lastPseudo"><s:property value="pseudo"/></span>
                <input id="textNom" name="nom" type="text" class="form-control" placeholder="Nom" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span id="lastNom"><s:property value="nom"/></span>
                <input id="textPrenom" name="prenom" type="text" class="form-control" placeholder="Prénom" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span id="lastPrenom"><s:property value="prenom"/></span>
                <div class="input-group-append">
                    <select id="selectBibliotheque" name="bibliotheque" class="form-control ">
                        <option>Toutes les bibliothèques</option>
                        <option>Bibliotheque de la gare</option>
                        <option>Bibliotheque centre ville</option>
                        <option>Bibliotheque du port marchand</option>
                    </select>
                </div>
                <div>
                    <button type="submit" value="Rechercher" id="btnRecherche" class="btn btn-outline-info">Rechercher</button>
                </div>
            </div>
        </s:form>
    </div>
    <div id="bottom">
        <div id="cadrePret" class="col-9" >
            <label class="form-check-label" id="labelRecherche"> Ma recherche de prêts en cours</label>
            <em id="message" class="text-info"><s:actionmessage/></em>
            <table class="table" id="tableau">
                <thead>
                <tr>
                    <th scope="col">Pseudo</th>
                    <th scope="col">Titre du livre</th>
                    <th scope="col">ISBN</th>
                    <th scope="col">Numéro interne</th>
                    <th scope="col">Bibliothèque</th>
                    <th scope="col">Date d'emprunt</th>
                    <th scope="col">Date de réstitution</th>
                    <th scope="col" id="thBtnRenouv">Renouveler</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="pretList">
                    <tr>
                        <td><s:property value="abonne.pseudo"/></td>
                        <td> <s:property value="livreUnique.livre.titre"/></td>
                        <td><s:property value="livreUnique.livre.isbn"/></td>
                        <td><s:property value="livreUnique.numero"/></td>
                        <td><s:property value="bibliotheque.nom"/></td>
                        <td><s:property value="dateEmprunt"/></td>
                        <td><s:property value="dateRestitution"/></td>
                        <s:if test="prolongation">
                            <td id="tdBtnRenouv"><button type="button" class="btn btn-secondary" style="font-size:0.6em;" disabled><i class="fas fa-redo-alt"></i></button></td>
                        </s:if>
                        <s:else>
                            <s:if test="expire">
                                <td id="tdBtnRenouv"><button type="button" class="btn btn-secondary" style="font-size:0.6em;" disabled>
                                    <i class="fas fa-redo-alt"></i></button></td>
                            </s:if>
                            <s:else>
                                <td id="tdBtnRenouv"><s:a action="prolongationPret" class="btn btn-info" style="font-size:0.6em;">
                                    <s:param name="pretId" value="id" />
                                    <s:param name="recherche" value="recherche" />
                                    <s:param name="bibliotheque" value="bibliotheque" />
                                    <i class="fas fa-redo-alt"></i></i></s:a></td>
                            </s:else>
                        </s:else>
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
        var lastTitre = $("#lastTitre").text();
        var lastAuteur = $("#lastAuteur").text();
        var lastIsbn = $("#lastIsbn").text();
        var lastEmail = $("#lastEmail").text();
        var lastPseudo = $("#lastPseudo").text();
        var lastNom = $("#lastnom").text();
        var lastPrenom = $("#lastPrenom").text();
        $("#lastIsbn").hide();
        $("#lastTitre").hide();
        $("#lastAuteur").hide();
        $("#lastEmail").hide();
        $("#lastPseudo").hide();
        $("#lastNom").hide();
        $("#lastPrenom").hide();
        $("#recherche").hide();

        $('input[id=textTitre]').val(lastTitre);
        $('input[id=textAuteur]').val(lastAuteur);
        $('input[id=textCodeISBN]').val(lastIsbn);
        $('input[id=textEmail]').val(lastEmail);
        $('input[id=textPseudo]').val(lastPseudo);
        $('input[id=textPrenom]').val(lastPrenom);
        $('input[id=textNom]').val(lastNom);




         if ($("#recherche").text() == "abonne") {
             $('#textTitre').hide();
             $('#textAuteur').hide();
             $('#textCodeISBN').hide();
            $("#btnAbonne").click();
        }else {
             $('#textEmail').hide();
             $('#textPseudo').hide();
             $('#textNom').hide();
             $('#textPrenom').hide();
         }

        $("#btnAbonne").click(function() {
            $('#textEmail').show();
            $('#textPseudo').show();
            $('#textNom').show();
            $('#textPrenom').show();
            $('#textTitre').hide();
            $('#textAuteur').hide();
            $('#textCodeISBN').hide();
            $("input[id=textTitre]").val("");
            $("input[id=textAuteur]").val("");
            $("input[id=textCodeISBN]").val("");
        });
        $("#btnLivre").click(function() {
            $('#textEmail').hide();
            $('#textPseudo').hide();
            $('#textNom').hide();
            $('#textPrenom').hide();
            $('#textTitre').show();
            $('#textAuteur').show();
            $('#textCodeISBN').show();
            $("input[id=textEmail]").val("");
            $("input[id=textPseudo]").val("");
            $("input[id=textNom]").val("");
            $("input[id=textPrenom]").val("");
        });
    });
</script>

</body>
</html>
