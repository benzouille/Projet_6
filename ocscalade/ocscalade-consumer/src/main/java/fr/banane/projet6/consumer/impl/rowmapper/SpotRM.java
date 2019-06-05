package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoSecteur;
import fr.banane.projet6.consumer.contract.dao.DaoVoie;
import fr.banane.projet6.model.bean.Secteur;
import fr.banane.projet6.model.bean.Spot;
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
    
    @Override
    public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {
//id id_createur officiel departement adresse description
        //TODO à terminer apres UtilisateurRS
        ArrayList<Secteur> secteurs = (ArrayList<Secteur>) daoSecteurImpl.readAll(rs.getInt("id"));

        Spot vSpot = new Spot();
        vSpot.setId(rs.getInt("id"));
        vSpot.setId_createur(rs.getInt("id_createur"));
        vSpot.setNom(rs.getString("nom"));
        vSpot.setDescription(rs.getString("description"));
        vSpot.setSecteurs(secteurs);
        return vSpot;

    }
}
