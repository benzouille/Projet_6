package fr.banane.projet6.webapp.technical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

/**
 * Classe servlet permettant d'afficher correctement les images
 */
@WebServlet("/static/*")
public class Static extends HttpServlet {
    // àchanger pour mettre votre propre path du dossier image du module webapp.
    private final static String imagesLibrayPath = "D:/intellij_workspace/Projet_6/ocscalade/ocscalade-webapp/src/main/webapp/images/spots";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        File file = new File(imagesLibrayPath, filename);

        if (!file.exists()) file = new File(imagesLibrayPath, "default.png");

        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

        Files.copy(file.toPath(), response.getOutputStream());
    }
}