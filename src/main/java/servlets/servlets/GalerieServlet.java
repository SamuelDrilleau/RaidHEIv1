package servlets.servlets;

import servlets.manager.UserLibrary;
import servlets.model.Photo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/galerie")

/* Page permettant de consulter les photos des différentes éditions du raid */

public class GalerieServlet extends HttpServlet {
    int annee;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        annee=Integer.parseInt(request.getParameter("annee"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
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
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/general.css\">\n" +
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
                "       </div>"+
                "    <a href=\"connexion\" class=\"w3-hover-red w3-hide-small w3-right\" style=\"padding: 7px 24px; margin-right:0px;\"><i class=\"fa fa-user-circle fa-2x\"></i></a>\n" +
                "  </div>\n" +
                "</nav>\n" +

                "<!-- Page content -->\n" +
                "<div class=\"container\">\n"+
                "<form method=\"post\">\n" +
                        "\t\t<select name=\"anne\" id=\"annee\">\n" +
                        "\t\t\t<option value=\"2017\">2017</option>\n" +
                        "\t\t\t<option value=\"2018\">2018</option>\n" +
                        "\t\t</select>\n" +
                        "\t\t<input type=\"submit\" name=\"submit\">\n" +
                        "\t</form>");
/* Récupérer les photos dans la UserLibrary */
                ArrayList<Photo> list = UserLibrary.getInstance().getAllPhoto(annee);
                for (int i=0; i<list.size(); i++){
                    out.println("<img src=\"C:/Users/DRILLEAU/Desktop/"); out.println(list.get(i).getNom()); out.println("\">");
                }

                out.println("</div>"+

                "<!-- Footer -->\n" +
                "<footer class=\"w3-container w3-padding-32 w3-center w3-opacity w3-xlarge\">\n" +
                "  <i class=\"fa fa-facebook-official fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-instagram fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-snapchat fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-pinterest-p fa-2x w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-twitter fa-2x w3-hover-opacity\"></i>\n" +
                "</footer>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
}
