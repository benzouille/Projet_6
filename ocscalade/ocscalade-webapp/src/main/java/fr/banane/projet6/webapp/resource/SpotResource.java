package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Spot;

import java.util.List;

public class SpotResource extends AbstractResource {

    public void newSpot (Spot spot) {
        getManagerFactory().getSpotManager().newSpot(spot);
    }

    public List<Spot> getListSpot() {
        return getManagerFactory().getSpotManager().getListSpot();
    }

    public Spot getSpot(Integer pId) {
        return getManagerFactory().getSpotManager().getSpot(pId);
    }

    public Spot getSpotByName(String name) {
        return getManagerFactory().getSpotManager().getSpotByName(name);
    }

    public void updateSpot (Spot spot) {getManagerFactory().getSpotManager().updateSpot(spot);}
}
