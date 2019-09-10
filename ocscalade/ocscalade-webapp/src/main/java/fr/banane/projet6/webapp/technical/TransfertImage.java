package fr.banane.projet6.webapp.technical;

import javax.servlet.http.Part;
import java.io.*;

/**
 * Classe permetant de transferer des images au dossier serveur
 */
public abstract class TransfertImage {

    private static final int TAILLE_TAMPON = 102400;
    private static final String PATH = "D:/intellij_workspace/Projet_6/ocscalade/ocscalade-webapp/src/main/webapp/images/spots/";

    public TransfertImage(){ }

    /**
     * Méthode permettant de telechager un fichier image sur le serveur depuis le coté client
     * @param part Part l'image
     * @param nomImage String titre de l'image
     * @throws IOException exception
     */
    public static void transfert(Part part, String nomImage) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(PATH + nomImage)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }

    /**
     * Méthode de récupération du titre de l'image
     * @param part part image
     * @return
     */
    public static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}
