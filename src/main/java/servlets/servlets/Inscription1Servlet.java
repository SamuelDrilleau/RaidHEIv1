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

@WebServlet("/inscription1")
public class Inscription1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail;
        String mdp1;
        String mdp2;
        String nom;
        String prenom;
        String sexe;
        String tel;
        String statut;
        String nomEnt;
        String nomUrg;
        String telUrg;
        int bds;
        int vtt;
        int bus;
        String tshirt;
        int fftri;


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
        bds=Integer.parseInt(request.getParameter("bds"));
        vtt=Integer.parseInt(request.getParameter("vtt"));
        bus=Integer.parseInt(request.getParameter("bus"));
        tshirt=request.getParameter("tshirt");
        fftri=Integer.parseInt(request.getParameter("fftri"));

        nomEquipe1=request.getParameter("nomEquipe1");
        mdpE1=DigestUtils.sha256Hex(request.getParameter("mdpE1"));
        mdpE2=DigestUtils.sha256Hex(request.getParameter("mdpE2"));
        typeRaid=request.getParameter("typeRaid");


        Equipe equipe = new Equipe(nomEquipe1,mdpE1,typeRaid);

        UserLibrary.getInstance().addEquipe(equipe);

        Participant participant = new Participant(mail,mdp1,nom,prenom,sexe,tel,statut,nomEnt,nomUrg,telUrg,bds,vtt,bus,tshirt,fftri,nomEquipe1,0,0,0,0,0);

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
                "<body>\n");

                       out.println("<script type=\"text/javascript\" language=\"javascript\">");
    /* Cette fonction permet de vérifier que lors du remplissage du formulaire, si les mots de passes sont vides ou qu'ils ne correspondent pas entre eux, l'envoi du formulaire est bloqué */

         out.println("       function validation(pass) {");
         out.println("       if (pass.mdp1.value == '' || pass.mdp2.value == '' || pass.mdpE1.value == '' || pass.mdpE2.value == '' ) {");
         out.println("           alert('Tous les champs ne sont pas remplis');");
         out.println("           pass.mdp1.focus();");
         out.println("           return false;");
         out.println("       }");
         out.println("        else if (pass.mdp1.value != pass.mdp2.value || pass.mdpE1.value != pass.mdpE2.value) {");
         out.println("           alert('Ce ne sont pas les mêmes mots de passe!');");
         out.println("           pass.mdp1.focus();");
         out.println("           return false;");
         out.println("       }");

         out.println("       else if (pass.mdp1.value == pass.mdp2.value && pass.mdpE1.value == pass.mdpE2.value) {");
         out.println("           return true;");
         out.println("       }");
         out.println("       else {");
         out.println("           pass.mdp1.focus();");
         out.println("           return false;");
         out.println("       }");
         out.println(" }");




/*Fonction qui vérifie que le caractère inscrit est alphabétique
    @param evenement est l'événement fournis par le keypress
    @param type est le type de caractère qu'on souhaite bloquer: 0 pour bloquer chiffres, 1 pour bloquer lettres
    @return true si le caractère est correct
         */

        out.println("                function verifieChar(evenement,type){");
        out.println("            var charCode;");
        out.println("            charCode = evenement.keyCode; //Code ascii");
        out.println("");
        out.println("            switch(type){");


        out.println("                case 0:");

                    //Lettres en majuscules,minuscule et trait d'union, c'est idéal lorsqu'on veut remplir un nom, un prénom ..
        out.println("                    if((charCode >= 65 && charCode <= 90)");
        out.println("                            ||(charCode >= 97 && charCode <= 122)");
        out.println("                            ||(charCode == 45)");
        out.println("                            ||(charCode == 32)){");
        out.println("");
        out.println("                        return true ;");
        out.println("                    }");
        out.println("                    else{");
        out.println("                        return false ;");
        out.println("                    }");
        out.println("                    break;");


        out.println("  case 3:");
                    // Chiffres seulement, c'est idéal pour les numéros de téléphone, les ages, les codes postaux
        out.println("         if(charCode >=48 && charCode <= 57) { ");
        out.println("          return true;");
        out.println("           }else {");
        out.println("        return false;");
        out.println("          }");
        out.println("         break;");
        out.println("            }//fermeture du switch");
        out.println("        }//fermeture de la fonction");

        out.println("</script>"+

                "<!-- Navbar -->\n" +
                "<nav class=\"w3-top\">\n" +
                "  <div class=\"w3-bar w3-black w3-card\">\n" +
                "    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <a href=\"index\"><button class=\"w3-padding-large w3-button\" title=\"More\">LE RAID</button></a>\n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"equipe\" class=\"w3-bar-item w3-button\">L'EQUIPE</a>\n" +
                "        <a href=\"lieu\" class=\"w3-bar-item w3-button\">LE LIEU</a>\n" +
                "        <a href=\"raidsprecedent\" class=\"w3-bar-item w3-button\">RAIDS PRECEDENTS</a>\n" +
                "        <a href=\"epreuves\" class=\"w3-bar-item w3-button\">EPREUVES</a>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <a href=\"partenariat\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">PARTENARIATS</a>\n" +
                "    <a href=\"engagements\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">ENGAGEMENTS</a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">INFORMATIONS</button>\n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        <a href=\"infos\" class=\"w3-bar-item w3-button\">INFOS PRATIQUES</a>\n" +
                "        <a href=\"materiel\" class=\"w3-bar-item w3-button\">MATERIEL</a>\n" +
                "        <a href=\"galeries\" class=\"w3-bar-item w3-button\">GALERIE</a>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "       <button class=\"w3-padding-large w3-button\" title=\"More\">INSCRIPTIONS</button>\n" +
                "           <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "               <a href=\"inscription1\" class=\"w3-bar-item w3-button\">INSCRIPTION ET CREATION D'UNE EQUIPE</a>\n" +
                "               <a href=\"inscription2\" class=\"w3-bar-item w3-button\">INSCRIPTION ET REJOINDRE UNE EQUIPE</a>\n" +
                "               <a href=\"inscription3\" class=\"w3-bar-item w3-button\">INSCRIPTIONS SOLO</a>\n" +
                "   </div>\n" +
                "   </div>\n" +
                "           <a href=\"connexion\" class=\"w3-hover-red w3-hide-small w3-right\" style=\"padding: 7px 24px;\"><i class=\"fa fa-user-circle fa-2x\"></i></a>\n" +
                "   </div>\n" +
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
                "<div class=\"container\">\n" +
                "\n" +

                /* Formulaire qui permet de s'inscrire au site et de créer une équipe par la même ocasion */

                "  <form method=\"post\" onSubmit=\"return (validation(this) \">\n" +
                "    <label >E-mail</label>\n" +
                "    <input type=\"email\" name=\"email\" required pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$\">\n" +
                "    <label>Mot de passe</label><input type=\"password\" name=\"mdp1\" required>\n" +
                "    <label>Confirmer le mot de passe</label><input type=\"password\" name=\"mdp2\" required>\n" +
                "    <label>Nom</label><input type=\"text\" name=\"nom\" onKeyPress=\"return verifieChar(event,0);\" required>\n" +
                "    <label>Prénom</label><input type=\"text\" name=\"prenom\" onKeyPress=\"return verifieChar(event,0);\" required>\n" +
                "    <label>Sexe</label>\n" +
                "    <select name=\"sexe\">\n" +
                "      <option value=\"F\">Féminin</option>\n" +
                "      <option value=\"M\">Masculin</option>\n" +
                "    </select>\n" +
                "    <label>Numéro de portable</label><input type=\"tel\" name=\"tel\"  onKeyPress=\"return verifieChar(event,3);\" required  >\n" +
                "    <label>Statut</label>\n" +
                "    <select name=\"statut\">\n" +
                "      <option value=\"etudiant\">Etudiant</option>\n" +
                "      <option value=\"salarie\">Salarié</option>\n" +
                "    </select>\n" +
                "    <label>Nom de votre école ou de votre entreprise</label><input type=\"text\" name=\"ent/ecole\" onKeyPress=\"return verifieChar(event,0);\" required>\n" +
                "    <label>Nom de la personne à contacter en cas d'urgrence</label><input type=\"text\" name=\"nomUrg\" onKeyPress=\"return verifieChar(event,0);\" required>\n" +
                "    <label>Numéro de la personne à contacter en cas d'urgence</label><input type=\"tel\" name=\"telUrg\" onKeyPress=\"return verifieChar(event,3);\"  required >\n" +
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
                "      <input id=\"nomEquipe1\" name=\"nomEquipe1\" type=\"text\" required >\n" +
                "      <label>Mot de passe de l'équipe</label>\n" +
                "      <input id=\"mdpE1\" type=\"password\" name=\"mdpE1\" required >\n" +
                "      <label>Confirmer le mot de passe de l'équipe</label>\n" +
                "      <input id=\"mdpE2\" type=\"password\" name=\"mdpE2\" required >\n" +
                "      <label>Type de raid</label>\n" +
                "      <select name=\"typeRaid\">\n" +
                "        <option value=\"Aventure\">Aventure</option>\n" +
                "        <option value=\"Expert\">Expert</option>\n" +
                "      </select>\n" +
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
