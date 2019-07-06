package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpotsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }
}
