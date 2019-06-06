package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoImage;
import fr.banane.projet6.consumer.contract.dao.DaoSecteur;
import fr.banane.projet6.consumer.contract.dao.DaoUtilisateur;
import fr.banane.projet6.consumer.contract.dao.DaoVoie;
import fr.banane.projet6.model.bean.Image;
import fr.banane.projet6.model.bean.Secteur;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * RowMapper de la classe "Spot"
 *
 * @author Banane
 */
@Named
public class SpotRM implements RowMapper<Spot> {

    @Inject
    DaoSecteur daoSecteurImpl;
    @Inject
    DaoUtilisateur daoUtilisateurImpl;
    @Inject
    DaoImage daoImageImpl;
    
    @Override
    public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Liste de secteur
        ArrayList<Secteur> secteurs = (ArrayList<Secteur>) daoSecteurImpl.readAll(rs.getInt("id"));
        //Liste d'image
        ArrayList<Image> images = (ArrayList<Image>) daoImageImpl.readAll(rs.getInt("id"));
        //Le créateur
        Utilisateur createur =daoUtilisateurImpl.read(rs.getInt("id_createur"));

        Spot vSpot = new Spot();
        vSpot.setId(rs.getInt("id"));
        vSpot.setCreateur(createur);
        vSpot.setOfficiel(rs.getBoolean("officiel"));
        vSpot.setNom(rs.getString("nom"));
        vSpot.setAdresse(rs.getNString("adresse"));
        vSpot.setDescription(rs.getString("description"));
        vSpot.setSecteurs(secteurs);
        vSpot.setImages(images);
        return vSpot;

    }
}
