package servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterAdmin")
public class FilterAdmin implements Filter {
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String identifiant = (String) httpRequest.getSession().getAttribute("utilisateurConnecte");
        if(identifiant == null || "".equals(identifiant) || !identifiant.equals("raid@hei.fr")) {
            System.out.println("Il faut être admin pour accéder à cette page !");
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("connexion");
            return;
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
