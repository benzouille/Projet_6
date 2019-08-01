package fr.banane.projet6.webapp.technical;

import fr.banane.projet6.model.bean.Spot;

import java.util.List;

/**
 * Classe permetant de tronquer les descriptions d'une liste de spot pour la présentation.
 */
public class SubStringDescription {

    /**
     * Constructeur par défaut
     */
    public SubStringDescription(){
    }

    /**
     * Tronque les déscriptions dépassant les 31 charactères
     * @param vListSpots
     * @return vListSpot modifié avec les description tronqué
     */
    public List<Spot>cutDescription(List<Spot>vListSpots){
        //reduction des déscriptions
        for (int i = 0; i < vListSpots.size(); i++) {
            String str;
            if(vListSpots.get(i).getDescription().length()>31){
                str = vListSpots.get(i).getDescription().substring(0, 30)+"...";
                vListSpots.get(i).setDescription(str);
            }
        }
        return vListSpots;
    }
}
