package fr.banane.projet6.model.exception;

/**
 * Classe d'exception levée quand l'objet métier crée est déjà dans la base de donnée
 *
 * @author Banane
 */
public class DuplicateException extends Exception {
    /**
     * Constructeur par défaut.
     */
    public DuplicateException() {
    }

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public DuplicateException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause   -
     */
    public DuplicateException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}