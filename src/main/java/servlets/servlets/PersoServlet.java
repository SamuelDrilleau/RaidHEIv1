package servlets.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import servlets.manager.UserLibrary;
import servlets.model.Participant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "perso")
public class PersoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudoUtilisateurConnecte = (String) request.getSession().getAttribute("utilisateurConnecte");
        try {
            ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> multifiles = sf.parseRequest(request);

            for (FileItem item : multifiles) {
                item.write(new File("/Users/DRILLEAU/Desktop/" +
                        ""+ item.getName()));
                out.println(item.getName());
            }
        }
        catch(Exception e){
            out.println("e");
            }

            response.sendRedirect("/prive/perso");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudoUtilisateurConnecte = (String) request.getSession().getAttribute("utilisateurConnecte");
        Participant user = UserLibrary.getInstance().participantByMail(pseudoUtilisateurConnecte);

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
                "<script src=\"js/script.js\" type=\"text/javascript\"></script>"+
                "<body>\n" +
                "\n" +
                "<!-- Navbar -->\n" +
                "<nav class=\"w3-top\">\n" +
                "  <div class=\"w3-bar w3-black w3-card\">\n" +
                "    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <a href=\"../index\" ><button class=\"w3-padding-large w3-button\" title=\"More\">LE RAID</button></a>     \n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"../equipe\" class=\"w3-bar-item w3-button\">L'EQUIPE</a>\n" +
                "        <a href=\"../lieu\" class=\"w3-bar-item w3-button\">LE LIEU</a>\n" +
                "        <a href=\"../precedent\" class=\"w3-bar-item w3-button\">RAIDS PRECEDENTS</a>\n" +
                "        <a href=\"../epreuve\" class=\"w3-bar-item w3-button\">EPREUVES</a>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <a href=\"../partenariat\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">PARTENARIATS</a>\n" +
                "    <a href=\"../engagements\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">ENGAGEMENTS</a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">INFORMATIONS</button>     \n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"../infos\" class=\"w3-bar-item w3-button\">INFOS PRATIQUES</a>\n" +
                "        <a href=\"../materiel\" class=\"w3-bar-item w3-button\">MATERIEL</a>\n" +
                "        <a href=\"../galerie\" class=\"w3-bar-item w3-button\">GALERIE</a>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">INSCRIPTIONS</button>\n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"../inscription1\" class=\"w3-bar-item w3-button\">INSCRIPTION ET CREATION D'UNE EQUIPE</a>\n" +
                "        <a href=\"../inscription2\" class=\"w3-bar-item w3-button\">INSCRIPTION ET REJOINDRE UNE EQUIPE</a>\n" +
                "        <a href=\"../inscription3\" class=\"w3-bar-item w3-button\">INSCRIPTIONS SOLO</a>\n" +
                "      </div>\n" +
                "    <a href=\"../connexion\" class=\"w3-hover-red w3-hide-small w3-right\" style=\"padding: 7px 24px;\"><i class=\"fa fa-user-circle fa-2x\"></i></a>\n" +
                "  </div>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Page content -->\n" +
                "<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px\">\n" +
                "\n" +
                "  <!-- Raid Section -->\n" +
                "  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"band\">\n" +
                "    <h2 class=\"w3-wide\">MON COMPTE</h2>\n" +
                "    <p class=\"w3-justify\">Bienvenue sur votre espace personnel hei. Vous pouvez retrouver toutes les informations relatives aux inscriptions ici</p><br>\n" +
                "    <p class=\"w3-justify\">Vous faîtes actuellement parti de l'équipe : raidhei pour un parcours de type Aventure</p>\n" +
                "    <h3>Etat de votre inscription</h3>\n" +
                "    <p class=\"w3-justify\">Ces informations seront mises à jour régulièrement dès votre inscription</p>\n" +
                "    <ul>\n" +
                "    \t<li>Attestation de lecture du règlement signée et remise:"); out.println(user.getAttestation()); out.println("(Télécharger le règlement et l'attestation de sa lecture)</li>\n" +
                "    \t<li>Certificat médical valide: "); out.println(user.getCertifMed()); out.println("</li>\n" +
                "    \t<li>Certificat de scolarité ou carte étudiante valide(Recto/Verso)(pour les étudiants): "); out.println(user.getCertifSco()); out.println("NON</li>\n" +
                "    </ul>\n" +
                "    <h3>Envoi de documents :</h3>\n" +
                "    <p class=\"w3-justify\">Vos documents doivent être au format PDF et ne pas dépasser 2 Mo</p>\n" +
                "    <ul>\n" +
                "\t<form action=\"perso\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "\t\t<li>\n" +
                "\t\t\t<label>Attestation de lecture du règlement signée:</label>\n" +
                "\t\t\t<input type=\"file\" name=\"attestation\" id=\"attestation\">\n" +
                "\t\t\t<input type=\"submit\" name=\"submit\">\n" +
                "\t\t</li>\n" +
                "\t</form>\n" +
                "\t<form action=\"perso\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "\t\t<li>\n" +
                "\t\t\t<label>Certificat médical:</label>\n" +
                "\t\t\t<input type=\"file\" name=\"certifMed\" id=\"certifMed\">\n" +
                "\t\t\t<input type=\"submit\" name=\"submit\">\n" +
                "\t\t</li>\n" +
                "\t</form>\n" +
                "\t<form action=\"perso\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "\t\t<li>\n" +
                "\t\t\t<label>Certificat de Scolarité/Carte étudiante:</label>\n" +
                "\t\t\t<input type=\"file\" name=\"certifSco\" id=\"certifSco\">\n" +
                "\t\t\t<input type=\"submit\" name=\"submit\">\n" +
                "\t\t\t\n" +
                "\t\t</li>\n" +
                "\t</form>\n" +
                "</ul>"+
                "    <h3>Vos information</h3>\n" +
                "    <ul>\n" +
                "    \t<li>Votre adresse mail :"); out.println(user.getMail()); out.println("</li>\n" +
                "    \t<li>Vous prenez le bus :"); out.println(user.getBus()); out.println("</li>\n" +
                "    \t<li>Vous louez un vélo :"); out.println(user.getVtt()); out.println("</li>\n" +
                "    \t<li>Téléphone :"); out.println(user.getTel()); out.println("</li>\n" +
                "    \t<li>Statut :"); out.println(user.getStatut()); out.println("</li>\n" +
                "    \t<li>Ecole :"); out.println(user.getNomEnt()); out.println("</li>\n" +
                "    \t<li>Contact en cas d'urgence :"); out.println(user.getTelUrg()); out.println("</li>\n" +
                "    </ul>\n" +
                "\n" +
                "    <a href=\"\"><button>Changer de mot de passe</button></a>\n" +
                "    <a href=\"../deconnexion\"><button>Se déconnecter</button></a>\n" +
                "    <a href=\"\"><button>Supprimer son compte</button></a>\n" +
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
                "\n"+
                "</body>\n" +
                "</html>\n");

    }

}




