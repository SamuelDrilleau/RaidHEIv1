package servlets.servlets;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.model.ObjectMetadata;
import servlets.manager.UserLibrary;
import servlets.model.Raid;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/admin/maj")
@MultipartConfig
public class MajServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserLibrary.getInstance().emptyRaid();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dateD = request.getParameter("debut");
        String dateC = request.getParameter("changement");
        String dateF = request.getParameter("fin");
        if (dateC!=null || dateD!=null || dateF!=null) {
            LocalDate changement = LocalDate.parse(dateC, dateFormat);
            LocalDate fin = LocalDate.parse(dateF, dateFormat);
            LocalDate debut = LocalDate.parse(dateD, dateFormat);

            Raid raid = new Raid(
                    0,
                    debut,
                    changement,
                    fin,
                    request.getParameter("contactMail"),
                    request.getParameter("contactTel"),
                    request.getParameter("lieu"),
                    request.getParameter("presentation"),
                    Integer.parseInt(request.getParameter("prixCaution")),
                    Integer.parseInt(request.getParameter("prixEtudiantE")),
                    Integer.parseInt(request.getParameter("prixEtudiantL")),
                    Integer.parseInt(request.getParameter("prixExterneE")),
                    Integer.parseInt(request.getParameter("prixExterneL")),
                    request.getParameter("nomCom1"),
                    request.getParameter("mailCom1"),
                    request.getParameter("nomCom2"),
                    request.getParameter("mailCom2"),
                    request.getParameter("epreuveV1"),
                    request.getParameter("epreuveV2"),
                    request.getParameter("epreuveS1"),
                    request.getParameter("epreuveS2"),
                    request.getParameter("epreuveS3"),
                    request.getParameter("epreuveD1"),
                    request.getParameter("epreuveD2"),
                    "equipeImg",
                    "plaquetteImg",
                    "ancienImg"
            );


            UserLibrary.getInstance().addRaid(raid);

        }

        String label1 = request.getParameter("equipe");
        String label2 = request.getParameter("plaquette");
        String label3 = request.getParameter("ancien");

        System.out.println(label1+" "+label2+" "+label3);

        String fichier = "";

        if (label2==null && label3==null) {
            fichier = "equipe";
        }else if (label1==null && label3==null) {
            fichier = "plaquette";
        }else if (label2==null && label1==null) {
            fichier = "ancien";
        }

        AWSCredentials Credentials = new BasicAWSCredentials("AKIAJVBODKWB2ZFE3NP"+"Q", "OHWVrEpcm6P4Gzh7rGlQIsw6IP0qfzgyB6KOuw9"+"j");
        UploadObjectSingleOperation S3client = new UploadObjectSingleOperation();

        Part filePart = request.getPart(fichier); // Retrieves <input type="file" name="file">
        InputStream fileContent = filePart.getInputStream();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpg");
        metadata.setContentLength(fileContent.available());

        S3client.uploadfile(Credentials, "majRaid/" + fichier, fileContent, metadata);

        response.sendRedirect("/admin/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        PrintWriter out=response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "    <link rel=\"icon\" href=\"images/logo.png\">\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/inscriptions.css\">\n"+
                "</head>\n" +
                "<body>\n" +
                "<nav class=\"w3-top\">\n" +
                "  <div class=\"w3-bar w3-black w3-card\">\n" +
                "    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">LE RAID</button>     \n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"../equipe\" class=\"w3-bar-item w3-button\">L'EQUIPE</a>\n" +
                "        <a href=\"../lieu\" class=\"w3-bar-item w3-button\">LE LIEU</a>\n" +
                "        <a href=\"../precedent\" class=\"w3-bar-item w3-button\">RAIDS PRECEDENTS</a>\n" +
                "        <a href=\"../epreuves\" class=\"w3-bar-item w3-button\">EPREUVES</a>\n" +
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
                "<!-- Page content -->\n" +
                "<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px\">\n" +
                "\n" +
                "    <div class=\"container\">\n" +
                "    <form method=\"post\" enctype='multipart/form-data'>\n" +
                "                <label>Date début</label>\n" +
                "                <input type=\"date\" name=\"debut\" required=>\n" +
                "                <label>Date changement de prix</label>\n" +
                "                <input type=\"date\" name=\"changement\" required=>\n" +
                "                <label>Date fin</label><input type=\"date\" name=\"fin\" required=><label>Mail</label>\n" +
                "                <input type=\"email\" name=\"contactMail\" required=><label>Téléphone</label>\n" +
                "                <input type=\"tel\" name=\"contactTel\" required=>\n" +
                "                <label>Lieu</label>\n" +
                "                <input type=\"text\" name=\"lieu\" required=>\n" +
                "                <label>Présentation lieu</label>\n" +
                "                <textarea rows=\"8\" cols=\"50\" name=\"presentation\" required=></textarea>\n" +
                "                <label>Prix caution</label>\n" +
                "                <input type=\"number\" name=\"prixCaution\" required=>\n" +
                "                <label>Prix étudiant early</label>\n" +
                "                <input type=\"number\" name=\"prixEtudiantE\" required=>\n" +
                "                <label>Prix étudiant late</label>\n" +
                "                <input type=\"number\" name=\"prixEtudiantL\" required=>\n" +
                "                <label>Prix externe early</label>\n" +
                "                <input type=\"number\" name=\"prixExterneE\" required=>\n" +
                "                <label>Prix externe late</label>\n" +
                "                <input type=\"number\" name=\"prixExterneL\" required=>\n" +
                "                <div>\n" +
                "                    <label>Contact Com 1</label>\n" +
                "                    <input type=\"text\" name=\"nomCom1\" placeholder=\"NOM Prénom\" required=>\n" +
                "                    <input type=\"email\" name=\"mailCom1\" placeholder=\"email\" required=> \n" +
                "                </div>\n" +
                "                 \n" +
                "                <div> \n" +
                "                    <label>Contact Com 2</label>\n" +
                "                    <input type=\"text\" name=\"nomCom2\" placeholder=\"NOM Prénom\" required=>\n" +
                "                    <input type=\"email\" name=\"mailCom2\" placeholder=\"email\" required=> \n" +
                "                </div>\n" +
                "                 \n" +
                "                <label>Epreuve 1 vendredi</label>\n" +
                "                <input type=\"text\" name=\"epreuveV1\" required=>\n" +
                "                <label>Epreuve 2 vendredi</label>\n" +
                "                <input type=\"text\" name=\"epreuveV2\" required=>\n" +
                "                <label>Epreuve 1 samedi</label>\n" +
                "                <input type=\"text\" name=\"epreuveS1\" required=>\n" +
                "                <label>Epreuve 2 samedi</label>\n" +
                "                <input type=\"text\" name=\"epreuveS2\" required=>\n" +
                "                <label>Epreuve 3 samedi</label>\n" +
                "                <input type=\"text\" name=\"epreuveS3\" required=>\n" +
                "                <label>Epreuve 1 dimanche</label>\n" +
                "                <input type=\"text\" name=\"epreuveD1\" required=>\n" +
                "                <label>Epreuve 2 diamanche</label>\n" +
                "                <input type=\"text\" name=\"epreuveD2\" required=>\n" +
                "\n" +
                "                <input type=\"submit\" name=>\n" +
                "    </form>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"container\">\n" +
                "    <form method=\"post\" enctype=\"multipart/form-data\">\n" +
                "        <label>test</label>\n" +
                "        <input type=\"file\" name=\"file\">\n" +
                "        <input type=\"submit\" name=\"equipe\" id=\"equipe\" onclick=\"changer(this.id) value=\"Envoyer\">\n" +
                "    </form>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"container\">\n" +
                "    <form method=\"post\" enctype=\"multipart/form-data\">\n" +
                "        <label>test</label>\n" +
                "        <input type=\"file\" name=\"file\">\n" +
                "        <input type=\"submit\" name=\"plaquette\" id=\"plaquette\" onclick=\"changer(this.id) value=\"Envoyer\">\n" +
                "    </form>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"container\">\n" +
                "    <form method=\"post\" enctype=\"multipart/form-data\">\n" +
                "        <label>test</label>\n" +
                "        <input type=\"file\" name=\"file\">\n" +
                "        <input type=\"submit\" name=\"ancien\" id=\"ancien\" onclick=\"changer(this.id) value=\"Envoyer\">\n" +
                "    </form>\n" +
                "    </div>\n" +
                "\n" +
                "    <!-- End Page Content -->\n" +
                "</div>\n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "        function changer(id){document.getElementById(id).value = id;}\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
