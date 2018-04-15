package servlets.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deconnexion")
/*Page de déconnexion*/
public class DeconnexionServlet extends HttpServlet {

    @Override

   /*Page de déconnexion*/
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("utilisateurConnecte");
        resp.sendRedirect("connexion");
    }
}
