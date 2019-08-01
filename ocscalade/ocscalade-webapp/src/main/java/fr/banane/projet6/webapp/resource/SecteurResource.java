package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Secteur;

import java.util.List;

public class SecteurResource extends AbstractResource {

    public Secteur getSecteur(int id_secteur){
        return getManagerFactory().getSecteurManager().getSecteur(id_secteur);
    }

    public List<Secteur> getSecteurById(int id_spot) {
        return getManagerFactory().getSecteurManager().getListSecteurByIdSpot(id_spot);
    }
}
