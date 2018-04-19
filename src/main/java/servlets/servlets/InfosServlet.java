package servlets.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import servlets.manager.UserLibrary;
import servlets.model.Raid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/infos")
public class InfosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Raid raid = UserLibrary.getInstance().getRaid();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<title>Raid HEI - Le Raid</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "<link rel=\"icon\" href=\"images/logo.png\">\n" +
                "<link rel=\"stylesheet\" href=\"css/genreal.css\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/normal.css\">\n" +
                "<link type=\"text/javascript\" src=\"js/script.js\">\n" +
                "<body>\n" +
                "\n" +
                "<!-- Navbar -->\n" +
                "<nav class=\"w3-top\">\n" +
                "  <div class=\"w3-bar w3-black w3-card\">\n" +
                "    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">LE RAID</button>     \n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"equipe\" class=\"w3-bar-item w3-button\">L'EQUIPE</a>\n" +
                "        <a href=\"lieu\" class=\"w3-bar-item w3-button\">LE LIEU</a>\n" +
                "        <a href=\"precedent\" class=\"w3-bar-item w3-button\">RAIDS PRECEDENTS</a>\n" +
                "        <a href=\"epreuves\" class=\"w3-bar-item w3-button\">EPREUVES</a>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <a href=\"partenariat\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">PARTENARIATS</a>\n" +
                "    <a href=\"engagements\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">ENGAGEMENTS</a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">INFORMATIONS</button>     \n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"infos\" class=\"w3-bar-item w3-button\">INFOS PRATIQUES</a>\n" +
                "        <a href=\"materiel\" class=\"w3-bar-item w3-button\">MATERIEL</a>\n" +
                "        <a href=\"galerie\" class=\"w3-bar-item w3-button\">GALERIE</a>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">INSCRIPTIONS</button>\n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"inscription1\" class=\"w3-bar-item w3-button\">INSCRIPTION ET CREATION D'UNE EQUIPE</a>\n" +
                "        <a href=\"inscription2\" class=\"w3-bar-item w3-button\">INSCRIPTION ET REJOINDRE UNE EQUIPE</a>\n" +
                "        <a href=\"inscription3\" class=\"w3-bar-item w3-button\">INSCRIPTIONS SOLO</a>\n" +
                "      </div>\n" +
                "       </div>"+
                "    <a href=\"connexion\" class=\"w3-hover-red w3-hide-small w3-right\" style=\"padding: 7px 24px; margin-right:0px;\"><i class=\"fa fa-user-circle fa-2x\"></i></a>\n" +
                "  </div>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Navbar on small screens -->\n" +
                "<nav id=\"navDemo\" class=\"w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top\" style=\"margin-top:46px\">\n" +
                "  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">LE RAID</a>\n" +
                "  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">PARTENARIATS</a>\n" +
                "  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">INSCRIPTIONS / CONNEXION</a>\n" +
                "  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">INFORMATIONS</a>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Page content -->\n" +
                "<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px\">\n" +
                "\n" +
                "  <!-- Raid Section -->\n" +
                "  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"band\">\n" +
                "    <h2 class=\"w3-wide\">INFOS PRATIQUES</h2>\n" +
                "    <p class=\"w3-justify\">\n" +
                "Lieu : Parc naturel régional de Scarpe-Escaut<br>\n" +
                "Date : 31 Mars - 2 Avril<br><br>\n" +
                "\n" +
                "Participation  :<br> \n" +
                "Le Raid est ouvert à tous, à partir de 18ans. Les pré-inscriptions sont ouvertes à partir de début janvier 2018. Pour valider votre inscription, vous devrez envoyer/déposer les papiers à l'adresse suivante :<br><br>\n" +
                "\n" +
                "Raid HEI<br>\n" +
                "13 rue de Toul<br>\n" +
                "59046 LILLE CEDEX<br>\n" +
                "</p><br>\n" +
                "\n" +
                "<ul>\n" +
                "  <li>L'attestation de lecture du règlement signée (Télécharger le règlement et l'attestation de sa lecture).</li>\n" +
                "  <li>Une caution de 250euros pour l'équipe (ou 62,50euros par personne)</li>\n" +
                "  <li>Le montant de l'inscription</li>\n" +
                "  <li>La photocopie d'une carte étudiante valide ou d'un certificat de scolarité si vous êtes étudiant</li>\n" +
                "  <li>Un certificat médical de non contre-indication à la pratique du sport en compétition datant de moins d'un an</li>\n" +
                "</ul><br><br>\n" +
                "\n" +
                "<p class=\"w3-justify\">\n" +
                "Vous avez maintenant la possibilité de payer votre inscription en ligne, d'envoyer votre certificat médical, votre certificat de scolarité/carte étudiante et l'attestation de lecture du règlement signée en utilisant le site du raid, rendez-vous <a href=\"\">ICI</a><br><br>\n" +
                "\n" +
                "\n" +
                "La clôture des inscriptions est fixée au 28 mars 2018 à 23h59. Aucune inscription ne sera acceptée après cette date. Aucune inscription ne sera remboursée s'il y a des désistements après le 19 mars 2018.<br><br>\n" +
                "\n" +
                "<p class=\"w3-justify\">\n" +
                "Frais d'inscription : <br>\n" +
                "Le montant de l'inscription peut être payé par chèque à l'ordre \"AS HEI\", en espèces, par carte bancaire et par internet via PUMPKIN. Il inclut : l'assistance médicale, la sécurité de l'épreuve, l'hébergement, le ravitaillement, les repas (sauf celui du samedi soir), le départ en bus de Lille. Le montant s'élève à :</p>\n" +
                "</p>\n" +
                "<ul>\n" +
                "  <li> 57 euros par équipier pour les étudiants.</li>\n" +
                "  <li> 72 euros par équipier pour les salariés.</li>\n" +
                "</ul>\n" +
                "<p class=\"w3-justify\">\n" +
                "Possibilité de louer un vélo et un casque pour 10 euros supplémentaires.<br><br>\n" +
                "\n" +
                "\n" +
                "Pour toute inscription après le 13 mars 2018 23h59 le montant sera de 67 euros par équipier (étudiants) et de 92 euros par équipier (salariés). Le supplément location vélo restant le même c'est à dire 10 euros.<br><br>\n" +
                "\n" +
                "\n" +
                "Depart/Retour :<br>\n" +
                "Le départ en bus est prévu le 31/03/2018 à 16h au 60 boulevard Vauban à Lille. Pour les personnes qui viennent par leur propre moyen, le rendez-vous est fixé à 17h15 au camping des Poteries, rue des poteries à Flines-lès-Mortagne. Le retour est prévu le lundi vers 16h00.\n" +
                "Note : Eviter les grosses valises et opter pour des sacs pour que tout puisse entrer dans la soute<br><br>\n" +
                "\n" +
                "Equipes : <br>\n" +
                "Les équipes doivent se composer de 4 personnes pour être classées. \n" +
                "Elles peuvent être mixtes.</p>\n" +
                "\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- The Contact Section -->\n" +
                "  <div class=\"w3-white\" id=\"tour\">\n" +
                "    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h2 class=\"w3-wide w3-center\">CONTACT</h2>\n" +
                "      <div class=\"w3-row-padding w3-padding-32\" style=\"margin:0 -16px\">\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <i class=\"fa fa-map-marker fa-2x\" style=\"width:30px\"></i>13 rue de Toul 59000 Lille\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <i class=\"fa fa-phone fa-2x\" style=\"width:30px\"></i>"); out.println(raid.getContactTel()); out.print("\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <i class=\"fa fa-envelope fa-2x\" style=\"width:30px\"> </i>"); out.println(raid.getContactMail()); out.print("\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  \n" +
                "<!-- End Page Content -->\n" +
                "</div>\n" +
                "\n" +
                "<!-- Footer -->\n" +
                "<footer class=\"w3-container w3-padding-32 w3-center w3-opacity w3-xlarge\">\n" +
                "  <i class=\"fa fa-facebook-official fa-2x w3-hover-opacity\" style=\"color: #0e3561;\"></i>\n" +
                "  <i class=\"fa fa-instagram fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-snapchat fa-2x w3-hover-opacity\" style=\"color: #f2b809\"></i>\n" +
                "  <i class=\"fa fa-pinterest-p fa-2x w3-hover-opacity\" style=\"color: #c00;\"></i>\n" +
                "  <i class=\"fa fa-twitter fa-2x w3-hover-opacity\" style=\"color: #09c;\"></i>\n" +
                "</footer>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");

    }
}
