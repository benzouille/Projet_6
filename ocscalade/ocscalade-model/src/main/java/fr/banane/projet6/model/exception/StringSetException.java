package fr.banane.projet6.model.exception;

/**
 * Classe d'exception levée quand une entrée de forme String ne correspond pas à ce qui est requis
 *
 * @author Banane
 */
public class StringSetException extends Exception {
    /**
     * Constructeur par défaut.
     */
    public StringSetException() {
    }

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public StringSetException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause   -
     */
    public StringSetException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
