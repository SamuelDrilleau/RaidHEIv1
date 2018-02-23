package servlets.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import servlets.manager.UserLibrary;
import servlets.model.Participant;
import servlets.model.Raid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<title>Raid HEI - Le Raid</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "<link rel=\"icon\" href=\"images/logo.png\">\n" +
                "<script src=\"js/script.js\" type=\"text/javascript\"></script>"+
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
                "    <a href=\"connexion\" class=\"w3-hover-red w3-hide-small w3-right\" style=\"padding: 7px 24px;\"><i class=\"fa fa-user-circle fa-2x\"></i></a>\n" +
                "  </div>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Navbar on small screens -->\n" +
                "<nav id=\"navDemo\" class=\"w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top\" style=\"margin-top:46px\">\n" +
                "  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">LE RAID</a>\n" +
                "  <a href=\"partenariat\" class=\"w3-bar-item w3-button w3-padding-large\">PARTENARIATS</a>\n" +
                "  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">INSCRIPTIONS / CONNEXION</a>\n" +
                "  <a href=\"infos\" class=\"w3-bar-item w3-button w3-padding-large\">INFORMATIONS</a>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Page content -->\n" +
                "<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px\">\n" +
                "\n" +
                "  <!-- Video -->\n" +
                "  <div class=\"w3-display-container w3-center\">\n" +
                "    <video style=\"width:100%\" poster =\"images/logo.png\" controls>\n" +
                "  \t\t<source src=\"videos/raid2017.ogv\" type=\"video/ogg\">\n" +
                "    </video>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- Raid Section -->\n" +
                "  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"band\">\n" +
                "    <h2 class=\"w3-wide\">LE RAID</h2>\n" +
                "    <p class=\"w3-opacity\"><i>Le sport est le dépassement de soi. Le sport est l'école de vie.</i></p>\n" +
                "    <p class=\"w3-justify\">Chaque année et cela depuis maintenant 23 éditions l'équipe organisatrice vous organise un weekend au coeur de la nature et dans un lieu unique et différent à chaque fois. Articulé autour de disciplines telles que  le trail, le run&bike, la course d'orientation, le VTT et le canoë , ce raid sera là pour prouver que chacun est capable de se dépasser. L'élément moteur de cette association est de vous faire partager sa passion pour le sport en équipe. Au cours de ces deux jours, vous aurez l'occasion de partager des moments forts en émotion avec vos coéquipiers et les autres raideurs.</p>\n" +
                "    <div class=\"w3-row w3-padding-32\">\n" +
                "<p class=\"w3-justify\">Nous sommes en ");

                Raid raid = UserLibrary.getInstance().getRaid();
                out.println(raid.getAnnee()+" !");

                out.println("      <div class=\"w3-third\">\n" +
                "        <p>Dépassement de soi</p>\n" +
                "        <img src=\"images/heart.png\" class=\"w3-round w3-margin-bottom\" style=\"width:60%\">\n" +
                "      </div>\n" +
                "      <div class=\"w3-third\">\n" +
                "        <p>Cadre exceptionnel</p>\n" +
                "        <img src=\"images/field.png\" class=\"w3-round w3-margin-bottom\" style=\"width:60%\">\n" +
                "      </div>\n" +
                "      <div class=\"w3-third\">\n" +
                "        <p>Entraide</p>\n" +
                "        <img src=\"images/help.png\" class=\"w3-round\" style=\"width:60%\">\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- Sponsors Section -->\n" +
                "    <div class=\"w3-black\" id=\"tour\">\n" +
                "    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h2 class=\"w3-wide w3-center\">NOS PARTENAIRES</h2>\n" +
                "      <div class=\"w3-row-padding w3-padding-32\" style=\"margin:0 -16px\">\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <img src=\"images/sg.jpg\" style=\"width:100%; background-color: white\">\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <img src=\"images/salti.png\" style=\"width:100%; background-color: white\">\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <img src=\"images/frmn.png\" style=\"width:100%; background-color: white\">\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- The Contact Section -->\n" +
                "  <div class=\"w3-white\" id=\"tour\">\n" +
                "    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h2 class=\"w3-wide w3-center\">CONTACT</h2>\n" +
                "      <div class=\"w3-row-padding w3-padding-32\" style=\"margin:0 -16px\">\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <i class=\"fa fa-map-marker fa-2x\" style=\"width:30px\"></i> Chicago, US\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <i class=\"fa fa-phone fa-2x\" style=\"width:30px\"></i> Phone: +00 151515\n" +
                "        </div>\n" +
                "        <div class=\"w3-third w3-margin-bottom\">\n" +
                "          <i class=\"fa fa-envelope fa-2x\" style=\"width:30px\"> </i> Email: mail@mail.com\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  \n" +
                "<!-- End Page Content -->\n" +
                "</div>\n" +
                "\n" +
                "<!-- Footer -->\n" +
                "<footer class=\"w3-container w3-padding-32 w3-center w3-opacity w3-xlarge\">\n" +
                "  <i class=\"fa fa-facebook-official fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-instagram fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-snapchat fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-pinterest-p fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-twitter fa-2x w3-hover-opacity\"></i>\n" +
                "</footer>\n" +
                "</body>\n" +
                "</html>\n");

    }
}
