<%-- 
    Document   : add-book-checker
    Created on : 15 avr. 2015, 10:28:56
    Author     : monbailly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Récapitulatif</title>
    </head>
 
    <body>
        <center>
            <h1>Récapitulatif de vos saisies</h1>
        </center>
       
        <p>
            <%
                // Récupération des paramètres
                String titre = request.getParameter("titre");
                String auteur = request.getParameter("auteur");
                String parution = request.getParameter("parution");
                boolean erreur = false;
                
                // Affichage des paramètres (et vérification)
                if(titre.isEmpty()){
                    erreur = true;
                    out.println("Veuillez saisir le titre du livre.");
                } else {
                    out.println("Titre saisi : " + titre);
                }
                
                out.println("<br/><br/>");
                
                if(auteur.isEmpty()){
                    erreur = true;
                    out.println("Veuillez indiquer l'auteur du livre.");
                } else {
                    out.println("Auteur saisie : " + auteur);
                }
                
                out.println("<br/><br/>");
                
                if(parution.isEmpty()){
                    erreur = true;
                    out.println("Veuillez indiquer la date de parution.");
                } else {
                    out.println("Date de parution saisie : " + parution);
                }
                
                
                // On affiche le résultat (saisie correcte ou non) et on affiche un lien
                if(erreur){
                    out.println("Saisie incorrecte, veuillez remplir tout les champs.");
                    out.println("<br/></br>");
                                    
                    out.println("<a href=\"go-back.html\">Réessayer</a>");
                } else {
                    out.println("<br/></br>");
                    out.println("Saisie validée.");
                }
                
                out.println("<br/></br>");            
                out.println("<a href=\"index.html\">Retour à l'accueil</a>");
            %>
            
            
            
        </p>
    </body>
</html>
