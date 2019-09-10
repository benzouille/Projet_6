package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Voie;

/**
 * Classe permettant de manipuler un Objet Voie depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class VoieResource extends AbstractResource {

    /**
     * Envoie un objet Voie au module business
     * @param vVoie objet Voie
     */
    public void newVoie(Voie vVoie){
        getManagerFactory().getVoieManager().newVoie(vVoie);
    }
}
