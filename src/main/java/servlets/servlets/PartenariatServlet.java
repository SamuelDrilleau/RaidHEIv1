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

@WebServlet("/partenariat")
/* Page informant sur les différents partenaire du raid  */
public class PartenariatServlet extends HttpServlet {
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
                "<link type=\"text/javascript\" src=\"../js/script.js\">\n" +
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
                "  <div class=\"w3-content w3-display-container\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/1.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/2.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/3.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/4.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/5.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/6.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/7.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/8.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/9.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/10.jpg\">\n" +
                "                    <img class=\"mySlides\" style=\"width:100%\" src=\"../images/partenariat_img/11.jpg\">\n" +
                "                    \n" +
                "                    <button class=\"w3-button w3-black w3-display-left\" onclick=\"plusDivs(-1)\">&#10094;</button>\n" +
                "                    <button class=\"w3-button w3-black w3-display-right\" onclick=\"plusDivs(1)\">&#10095;</button>\n" +
                "</div>\n" +
                "  <!-- Sponsors Section -->\n" +
                "    <div class=\"w3-black\">\n" +
                "    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n" +
                "      <h2 class=\"w3-wide\">Vous pouvez retrouver notre brochure <a href=\"../pdf/Dossier partenariat_RAIDHEI_2018.pdf\" target=\"_blank\" title=\"\">ici</a>.</h2>\n" +
                "      <p>\n" +
                "      <br /></font><br />N'ésitez pas à nous faire part de toute autre proposition de sponsoring. Nous sommes à votre écoute et disponibles pour répondre à vos attentes :<br /><br />\n" +
                "      "); out.println(raid.getNomCom1()); out.print("<a href=\""); out.println(raid.getMailCom1()); out.print("\">"); out.println(raid.getMailCom1()); out.print("</a><br />\n" +
                "      "); out.println(raid.getNomCom2()); out.print("<a href=\""); out.println(raid.getMailCom2()); out.print("\">"); out.println(raid.getMailCom2()); out.print("</a><br />\n" +
                "      </p>\n" +
                "    </div>\n" +
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
                "  <i class=\"fa fa-facebook-official fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-instagram fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-snapchat fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-pinterest-p fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-twitter fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-linkedin fa-2x w3-hover-opacity\"></i>\n" +
                "</footer>\n" +
                "\n" +
                "<script>\n" +
                "    var slideIndex = 1;\n" +
                "    showDivs(slideIndex);\n" +
                "\n" +
                "    function plusDivs(n) {\n" +
                "        showDivs(slideIndex += n);\n" +
                "    }\n" +
                "\n" +
                "    function showDivs(n) {\n" +
                "        var i;\n" +
                "        var x = document.getElementsByClassName(\"mySlides\");\n" +
                "        if (n > x.length) {slideIndex = 1}\n" +
                "        if (n < 1) {slideIndex = x.length} ;\n" +
                "        for (i = 0; i < x.length; i++) {\n" +
                "            x[i].style.display = \"none\";\n" +
                "        }\n" +
                "        x[slideIndex-1].style.display = \"block\";\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");

    }
}
