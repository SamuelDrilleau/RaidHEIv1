package servlets.servlets;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import servlets.manager.UserLibrary;
import servlets.model.Raid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/equipe")
/* Page permettant d'acceder aux informations sur l'équipe du raid HEI */
public class EquipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectInfoSimple ois = new ObjectInfoSimple("raidhei","");
        response.setCharacterEncoding("UTF-8");
        Raid raid = UserLibrary.getInstance().getRaid();

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
                "<style>\n" +
                "/* Style inputs with type=\"text\", select elements and textareas */\n" +
                "input[type=text], select, textarea, input[type=\"tel\"], input[type=\"password\"], input[type=\"email\"] {\n" +
                "    width: 100%; /* Full width */\n" +
                "    padding: 12px; /* Some padding */ \n" +
                "    border: 1px solid #ccc; /* Gray border */\n" +
                "    border-radius: 4px; /* Rounded borders */\n" +
                "    box-sizing: border-box; /* Make sure that padding and width stays in place */\n" +
                "    margin-top: 6px; /* Add a top margin */\n" +
                "    margin-bottom: 16px; /* Bottom margin */\n" +
                "    resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */\n" +
                "}\n" +
                "\n" +
                "/* Style the submit button with a specific background color etc */\n" +
                "input[type=submit] {\n" +
                "    background-color: #4CAF50;\n" +
                "    color: white;\n" +
                "    padding: 12px 20px;\n" +
                "    border: none;\n" +
                "    border-radius: 4px;\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                "\n" +
                "/* When moving the mouse over the submit button, add a darker green color */\n" +
                "input[type=submit]:hover {\n" +
                "    background-color: #45a049;\n" +
                "}\n" +
                "\n" +
                "/* Add a background color and some padding around the form */\n" +
                ".container {\n" +
                "    border-radius: 5px;\n" +
                "    background-color: #f2f2f2;\n" +
                "    padding: 20px;\n" +
                "    width: 35%;\n" +
                "    margin-top: 10%;\n" +
                "    margin-bottom: 10%;\n" +
                "    margin-right: auto;\n" +
                "    margin-left: auto;\n" +
                "}\n" +
                "\n" +
                "footer{\n" +
                "    background-color: #fff;\n" +
                "    width:100%;\n" +
                "    z-index:1\n" +
                "}\n" +
                "\n" +
                "\n" +
                "\n"+
                "</style>"+
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
                "<div id=\"photos\" class=\"w3-content w3-display-container\">\n" +
                "  <img class=\"mySlides\" src=\"../images/equipe2017.jpg\" style=\"width:100%\">\n" +
                "  <img class=\"mySlides\" src=\"../images/organigramme2018.jpg\" style=\"width:100%\">\n" +
                "\n" +
                "  <button class=\"w3-button w3-black w3-display-left\" onclick=\"plusDivs(-1)\">&#10094;</button>\n" +
                "  <button class=\"w3-button w3-black w3-display-right\" onclick=\"plusDivs(1)\">&#10095;</button>\n" +
                "</div>\n" +
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
                "\n" +
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
                "</html>");
    }

    public static BufferedReader getReaderFromObjectInfo(ObjectInfoSimple objectInfo) {
        AmazonS3 s3Client = AmazonS3Provider.getS3Client();

        S3Object object = s3Client.getObject(objectInfo.getBucket(), objectInfo.getKey());
        S3ObjectInputStream objectContentRawStream = object.getObjectContent();

        return new BufferedReader(new InputStreamReader(objectContentRawStream));
    }
}
