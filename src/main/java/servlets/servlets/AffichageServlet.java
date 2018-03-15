package servlets.servlets;

import servlets.manager.UserLibrary;
import servlets.model.Participant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/admin/affichage")
public class AffichageServlet extends HttpServlet {
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
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/general.css\">\n" +
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
                "<table>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th>mail</th>\n" +
                "<th>nom prenom</th>\n" +
                "<th>sexe</th>\n" +
                "<th>téléphone</th>\n" +
                "<th>statut</th>\n" +
                "<th>nom école / entreprise</th>\n" +
                "<th>nom urgence</th>\n" +
                "<th>téléphone urgence</th>\n" +
                "<th>bds</th>\n" +
                "<th>vtt</th>\n" +
                "<th>bus</th>\n" +
                "<th>fftri</th>\n" +
                "<th>nom équipe</th>\n" +
                "<th>attestation</th>\n" +
                "<th>certificat médical</th>\n" +
                "<th>certificat scolaire</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n"+
                "<tr>\n");

        ArrayList<Participant> liste = UserLibrary.getInstance().getAllParticipant();
        for (int i=0;i<liste.size();i++){
            out.println("<th>"+liste.get(i).getMail()+"</th>");
            out.println("<th>"+liste.get(i).getNom()+" "+liste.get(i).getPrenom()+"</th>");
            out.println("<th>"+liste.get(i).getSexe()+"</th>");
            out.println("<th>"+liste.get(i).getTel()+"</th>");
            out.println("<th>"+liste.get(i).getStatut()+"</th>");
            out.println("<th>"+liste.get(i).getNomEnt()+"</th>");
            out.println("<th>"+liste.get(i).getNomUrg()+"</th>");
            out.println("<th>"+liste.get(i).getTelUrg()+"</th>");
            out.println("<th>"+liste.get(i).getBds()+"</th>");
            out.println("<th>"+liste.get(i).getVtt()+"</th>");
            out.println("<th>"+liste.get(i).getBus()+"</th>");
            out.println("<th>"+liste.get(i).getFftri()+"</th>");
            out.println("<th>"+liste.get(i).getNomEquipe()+"</th>");
            out.println("<th>"+liste.get(i).getAttestation()+"</th>");
            out.println("<th>"+liste.get(i).getCertifMed()+"</th>");
            out.println("<th>"+liste.get(i).getCertifSco()+"</th>");
        }

                out.println("</tr>\n" +
                        "\t</body>"+
                "\t</table>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");
    }
}
