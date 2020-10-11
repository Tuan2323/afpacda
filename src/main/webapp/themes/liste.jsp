<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PAS UNE GOUTTE DE JAVA DANS LES PAGES JSP MAIS PLUTOT ON UTILISE EL et JSTL</h1>
        <p>${2*2}</p>
        
        <p><a href="themes?action=1">Nouveau Thème</a></p>
        
        <table>
            <caption>list des thèmes</caption>
            <tr>
                <th>Libellé</th>
                <th></th>
                <th></th>
            </tr>
            
            
        
        <c:forEach var="theme" items="${requestScope.listeThemes}">
            
            <tr>
                <td>${theme.libelle}</td>
                <td><a href="themes?id=${theme.idTheme}&action=2">modifier</a></td>
                <td><a href="themes?id=${theme.idTheme}&action=3">supprimer</a></td>
            </tr>
            
        </c:forEach>
            
        </table>
        
    </body>
</html>
