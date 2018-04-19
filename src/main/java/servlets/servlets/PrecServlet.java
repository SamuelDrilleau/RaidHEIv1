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

@WebServlet("/precedent")
/* Page permettant d'avoir accès aux raids précédents*/
public class PrecServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Raid raid = UserLibrary.getInstance().getRaid();

        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<title>Raid HEI - Le Raid</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta  name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
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
                "<div class=\"w3-white\" id=\"tour\">\n" +
                "    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h2 class=\"w3-wide w3-center\">Les Raids Précédents</h2>\n" +
                "    </div>\n" +
                "    <div class=\"w3-bar-item w3-button w3 w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h1 class =\"w3-wide w3-center\">Raid HEI 2016:</h1>\n" +
                "      <img  src=\"../images/quesnoy.jpg\" style=\"width:100%\">\n" +
                "    </div>\n" +
                "      <p><b>Lieu:</b>L'Avesnois (Nord), Le Quesnoy</br>\n" +
                "        <b>Dates:</b>les 8,9 et 10 Avril 2016</br></br>\n" +
                "        <b>Parcours Aventure:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 34.6km de VTT, 8.3km de Course, 5 km de Canoë et 7.1km de Run and Bike</li>\n" +
                "        <li>Dimanche:3.2km de Course et 26.4km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>84.6km.</b>\n" +
                "      </p>\n" +
                "      <p><b> Parcours Expert:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 43km de VTT, 10km de Course, 5 km de Canoë et 7.1km de Run and Bike</li>\n" +
                "        <li>Dimanche:3.2km de Course et 26.4km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>94.7km.</b>\n" +
                "      </p>\n" +
                "\n" +
                "      <div class=\"w3-bar-item w3-button w3 w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h1 class =\"w3-wide w3-center\">Raid HEI 2015:</h1>\n" +
                "      <img  src=\"../images/valjoly.png\" style=\"width:100%\">\n" +
                "      </div>\n" +
                "      <p><b>Lieu:</b>Le Valjoly (Nord), Signy-le-petit</br>\n" +
                "        <b>Dates:</b>les 24,25 et 26 Avril 2015</br></br>\n" +
                "        <b>Parcours Aventure:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 38.9km de VTT, 20.5km de Course, 1.5 km de Canoë et 14.4km de Run and Bike</li>\n" +
                "        <li>Dimanche:8.6km de Course, 9.5km de Run and Bike et 8.5km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>101.4km.</b>\n" +
                "      </p>\n" +
                "      <p><b> Parcours Expert:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 45km de VTT, 29.9km de Course, 1.5 km de Canoë et 7.2km de Run and Bike</li>\n" +
                "        <li>Dimanche:8.6km de Course, 9.5km de Run and Bike et 8.5km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>110.1km.</b>\n" +
                "      </p>\n" +
                "\n" +
                "      <div class=\"w3-bar-item w3-button w3 w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h1 class =\"w3-wide w3-center\">Raid HEI 2014:</h1>\n" +
                "      <img  src=\"../images/marquise.jpg\" style=\"width:100%\">\n" +
                "      </div>\n" +
                "      <p><b>Lieu:</b> La Côte d'Opale (Pas-De-Calais), Marquise </br>\n" +
                "        <b>Dates:</b>les 25,26 et 27 Avril 2014</br></br>\n" +
                "        <b>Parcours Aventure:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 40.81km de VTT, 6.83km de Course, 3 km de Canoë et 26.46km de Run and Bike</li>\n" +
                "        <li>Dimanche:15km de Course et 23.36km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>115.46km.</b>\n" +
                "      </p>\n" +
                "      <p><b> Parcours Expert:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 34.31km de VTT, 18.7km de Course, 3 km de Canoë et 26.46km de Run and Bike</li>\n" +
                "        <li>Dimanche:19.3km de Course et 28.87km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>130.64km.</b>\n" +
                "      </p>\n" +
                "\n" +
                "      <div class=\"w3-bar-item w3-button w3 w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h1 class =\"w3-wide w3-center\">Raid HEI 2013:</h1>\n" +
                "      <img  src=\"../images/revin.jpg\" style=\"width:100%\">\n" +
                "      </div>\n" +
                "      <p><b>Lieu:</b>  Les Ardennes (Champagne-Ardennes), Revin </br>\n" +
                "        <b>Dates:</b>les 5,6 et 7 Avril 2013</br></br>\n" +
                "        <b>Parcours Aventure:</b></br>\n" +
                "        <li>Vendredi soir: 1h15 de Course d'orientation et un 400m verticale facultatif</li>\n" +
                "        <li>Samedi soir: 16.2km de VTT, 14.9km de Course, 1.5 km de Canoë et 6.7km de Run and Bike</li>\n" +
                "        <li>Dimanche:10.7km de Course et 4.8km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>54.8km.</b>\n" +
                "      </p>\n" +
                "      <p><b> Parcours Expert:</b></br>\n" +
                "        <li>Vendredi soir: 1h15 de Course d'orientation et un 400m verticale</li>\n" +
                "        <li>Samedi soir: 25.9km de VTT, 13.1km de Course, 1.5 km de Canoë et 6.7km de Run and Bike</li>\n" +
                "        <li>Dimanche:16.9km de Course et 7.6km de VTT</li></br>\n" +
                "\n" +
                "        Soit en tout <b>71.7km.</b>\n" +
                "      </p>\n" +
                "\n" +
                "      <div class=\"w3-bar-item w3-button w3 w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h1 class =\"w3-wide w3-center\">Raid HEI 2012:</h1>\n" +
                "      <img  src=\"../images/long.jpg\" style=\"width:100%\">\n" +
                "      </div>\n" +
                "      <p><b>Lieu:</b> Vallée de la Somme (Picardie), Long</br>\n" +
                "        <b>Dates:</b>les 13,14 et 15 Avril 2012</br></br>\n" +
                "        <b>Parcours Aventure:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 42km de VTT, 10.5km de Course, 5.1 km de Canoë</li>\n" +
                "        <li>Dimanche:Relais kayak sur 300m et Run and Bike de 19.8km</li></br>\n" +
                "\n" +
                "        Soit en tout <b>77.2km.</b>\n" +
                "      </p>\n" +
                "      <p><b> Parcours Expert:</b></br>\n" +
                "        <li>Vendredi soir: 1h30 de Course d'orientation</li>\n" +
                "        <li>Samedi soir: 64.4km de VTT, 10.5km de Course et 5.1 km de Canoë</li>\n" +
                "        <li>Dimanche:Relais Kayak sur 300m, Run and Bike de 19.8km et course sur 8.9km</li></br>\n" +
                "\n" +
                "        Soit en tout <b>109km.</b>\n" +
                "      </p>\n" +
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
                "<!-- Footer -->\n" +
                "<footer class=\"w3-container w3-padding-32 w3-center w3-opacity w3-xlarge\">\n" +
                "  <i class=\"fa fa-facebook-official fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-instagram fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-snapchat fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-pinterest-p fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-twitter fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-linkedin fa-2x w3-hover-opacity\"></i>\n" +
                "</footer>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }
}
