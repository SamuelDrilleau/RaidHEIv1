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

@WebServlet("/materiel")
/* Page permettant à l'utilisateur de s'informer sur le matériel à prendre */
public class MaterielServlet extends HttpServlet {
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
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/normal.css\">\n" +
                "<link rel=\"stylesheet\" href=\"css/genreal.css\">\n" +
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
                "  <!-- Raid Section -->\n" +
                "  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"band\">\n" +
                "    \n" +
                "\n" +
                "    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h2 class=\"w3-wide w3-center\">MATERIEL</h2>\n" +
                "      <p class=\"w3-justify\">\n" +
                "        Pour passer un bon weekend au Raid HEI, il ne suffit pas de s'entrainer comme un fou pour avoir une forme olympique! En effet, il est essentiel de bien préparer le matériel que vous allez emmener durant votre weekend. Pour vous aider nous avons préparé une liste de matériel pour vous. Certains matériels sont obligatoires, d'autres au contraire sont conseillés ou interdit ! A vous de faire le bon choix pour passer un bon Raid !\n" +
                "      </p>\n" +
                "      <div class=\"w3-row-padding w3-padding-32\" style=\"margin:0 -16px\">\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <h3>MATERIEL OBLIGATOIRE :</h3>\n" +
                "<h4>Par personne :</h4>\n" +
                "<ul>\n" +
                "  <li> Pique nique du samedi soir</li>\n" +
                "  <li> Sac de couchage</li>\n" +
                "  <li> Casque (si vous apportez votre vélo)</li>\n" +
                "  <li> VTT (si vous ne le louez pas)</li>\n" +
                "  <li> Gourde ou poche à eau</li>\n" +
                "  <li> Gilet fluo</li>\n" +
                "  <li> Lampe frontale</li>\n" +
                "</ul>\n" +
                "\n" +
                "  \n" +
                "<h4>Par équipe :</h4>\n" +
                "<ul>\n" +
                "  <li> 1 ou 2 tentes</li>\n" +
                "  <li> Trousse de secours</li>\n" +
                "  <li> Couverture de survie</li>\n" +
                "  <li> 2 téléphones portables chargés</li>\n" +
                "</ul>\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <h3>MATERIEL<br> CONSEILLE :</h3>\n" +
                "<h4>Par personne :</h4>\n" +
                "<ul>\n" +
                "  <li> Gants</li>\n" +
                "  <li> 2ème paire de chaussures</li>\n" +
                "  <li> Piles de rechange</li>\n" +
                "  <li> Matelas</li>\n" +
                "  <li> Barres de céréales (en cas de fringale)</li>\n" +
                "</ul>\n" +
                "\n" +
                "  \n" +
                "<h4>Par équipe :</h4>\n" +
                "<ul>\n" +
                "  <li> Sifflet</li>\n" +
                "  <li> Porte-carte</li>\n" +
                "  <li> Boussole</li>\n" +
                "</ul>\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <h3>MATERIEL INTERDIT :</h3>\n" +
                "<ul>\n" +
                "  <li> GPS</li>\n" +
                "  <li> Moteur électrique</li> \n" +
                "  <li> Dopage</li>\n" +
                "</ul>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "    </div>\n" +
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
