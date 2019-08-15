package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Voie;

public class VoieResource extends AbstractResource {

    public void newVoie(Voie vVoie){
        getManagerFactory().getVoieManager().newVoie(vVoie);
    }
}
