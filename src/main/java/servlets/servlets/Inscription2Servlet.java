package servlets.servlets;

import org.apache.commons.codec.digest.DigestUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import servlets.manager.UserLibrary;
import servlets.model.Equipe;
import servlets.model.Participant;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

@WebServlet("/inscription2")
public class Inscription2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail;
        String mdp1;
        String mdp2;
        String mdp;
        String nom;
        String prenom;
        String sexe;
        String tel;
        String statut;
        String nomEnt;
        String nomUrg;
        String telUrg;
        String bds;
        String vtt;
        String bus;
        String tshirt;
        String fftri;


        String nomEquipe1;
        String mdpE1;
        String mdpE2;
        String typeRaid;

        mail= request.getParameter("email");
        mdp1 = DigestUtils.sha256Hex(request.getParameter("mdp1"));
        mdp2 = DigestUtils.sha256Hex(request.getParameter("mdp2"));
        nom= request.getParameter("nom");
        prenom= request.getParameter("prenom");
        sexe= request.getParameter("sexe");
        tel=request.getParameter("tel");
        statut=request.getParameter("statut");
        nomEnt=request.getParameter("ent/ecole");
        nomUrg=request.getParameter("nomUrg");
        telUrg=request.getParameter("telUrg");
        bds=request.getParameter("bds");
        vtt=request.getParameter("vtt");
        bus=request.getParameter("bus");
        tshirt=request.getParameter("tshirt");
        fftri=request.getParameter("fftri");

        nomEquipe1=request.getParameter("nomEquipe1");
        mdpE1=DigestUtils.sha256Hex(request.getParameter("mdpE1"));
        mdpE2=DigestUtils.sha256Hex(request.getParameter("mdpE2"));
        typeRaid=request.getParameter("typeRaid");

        Participant participant = new Participant(mail,mdp1,nom,prenom,sexe,tel,statut,nomEnt,nomUrg,telUrg,bds,vtt,bus,tshirt,fftri,nomEquipe1,"","","");

        UserLibrary.getInstance().addParticipant(participant);

        response.sendRedirect("index");

        try {
            String host = "smtp.office365.com";
            String user = "";
            String pass = "";
            String to = mail;
            String from = "";
            String subject = "Inscription RaiHEI";
            String messageText = "Your Is Test Email :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        PrintWriter out=response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<title>Raid HEI - Le Raid</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "<link rel=\"icon\" href=\"images/logo.png\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/inscriptions.css\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/general.css\">\n" +
                "<script src=\"js/script.js\" type=\"text/javascript\"></script>"+
                "<body>\n" +
                "\n" +
                "<!-- Navbar -->\n" +
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
                        "        <a href=\"epreuve\" class=\"w3-bar-item w3-button\">EPREUVES</a>\n" +
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
                        "</nav>"+
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
                "<div class=\"container\">\n" +
                "\n" +
                "  <form method=\"post\" onSubmit=\"return validation(this)\">\n" +
                "    <label >E-mail</label>\n" +
                "    <input type=\"email\" name=\"email\" required=\"\">\n" +
                "    <label>Mot de passe</label><input type=\"password\" name=\"mdp1\" required=\"\">\n" +
                "    <label>Confirmer le mot de passe</label><input type=\"password\" name=\"mdp2\" required=\"\">\n" +
                "    <label>Nom</label><input type=\"text\" name=\"nom\" required=\"\">\n" +
                "    <label>Prénom</label><input type=\"text\" name=\"prenom\" required=\"\">\n" +
                "    <label>Sexe</label>\n" +
                "    <select name=\"sexe\">\n" +
                "      <option value=\"F\">Féminin</option>\n" +
                "      <option value=\"M\">Masculin</option>\n" +
                "    </select>\n" +
                "    <label>Numéro de portable</label><input type=\"tel\" name=\"tel\" required=\"\">\n" +
                "    <label>Statut</label>\n" +
                "    <select name=\"statut\">\n" +
                "      <option value=\"etudiant\">Etudiant</option>\n" +
                "      <option value=\"salarie\">Salarié</option>\n" +
                "    </select>\n" +
                "    <label>Nom de votre école ou de votre entreprise</label><input type=\"text\" name=\"ent/ecole\" required=\"\">\n" +
                "    <label>Nom de la personne à contacter en cas d'urgrence</label><input type=\"text\" name=\"nomUrg\" required=\"\">\n" +
                "    <label>Numéro de la personne à contacter en cas d'urgence</label><input type=\"tel\" name=\"telUrg\" required=\"\">\n" +
                "    <label>Cotisant BDS HEI ?</label>\n" +
                "    <select name=\"bds\">\n" +
                "      <option value=\"oui\">Oui</option>\n" +
                "      <option value=\"non\">Non</option>\n" +
                "    </select>\n" +
                "    <label>Amenez-vous votre propre VTT ?</label>\n" +
                "    <select name=\"vtt\">\n" +
                "      <option value=\"oui\">Oui</option>\n" +
                "      <option value=\"non\">Non</option>\n" +
                "    </select>\n" +
                "    <label>Venez-vous avec le bus mis à votre disposition ?</label>\n" +
                "    <select name=\"bus\">\n" +
                "      <option value=\"oui\">Oui</option>\n" +
                "      <option value=\"non\">Non</option>\n" +
                "    </select>\n" +
                "      <label>Etes-vous membre de la FFTri ?</label>\n" +
                "      <select name=\"fftri\">\n" +
                "          <option value=\"oui\">Oui</option>\n" +
                "          <option value=\"non\">Non</option>\n" +
                "      </select>\n" +
                "    <label>Quelle est votre taille de t-shit ?</label>\n" +
                "    <select name=\"tshirt\">\n" +
                "      <option value=\"s\">S</option>\n" +
                "      <option value=\"m\">M</option>\n" +
                "      <option value=\"l\">L</option>\n" +
                "      <option value=\"xl\">XL</option>\n" +
                "    </select>\n" +
                "\n" +
                "      <label>Nom de l'équipe</label>\n" +
                "      <select=\"nomEquipe1\">\n");
                ArrayList<Equipe> list = UserLibrary.getInstance().getAllEquipe();
                for(int i=0;i<list.size();i++){
                    if (!list.get(i).getNom().equals("Indiv")){
                        out.println("<option>");
                        out.println(list.get(i).getNom());
                        out.println("</option>");
                    }
                }
                out.println("</select>");
                out.println("<label>Mot de passe de l'équipe</label>\n" +
                "      <input id=\"mdpE1\" type=\"password\" name=\"mdpE1\">\n" +
                "<input type=\"submit\" value=\"Valider\" />"+
                "  </form>\n" +
                "  \n" +
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
                "\n" +
                "</body>\n" +
                "</html>\n");
    }
}
