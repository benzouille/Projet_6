package fr.banane.projet6.model.exception;

/**
 * Classe d'exception levée quand une erreur technique est survenue
 *
 * @author Banane
 */
public class TechnicalException extends Exception {

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public TechnicalException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public TechnicalException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
