package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoVoie;
import fr.banane.projet6.model.bean.Secteur;
import fr.banane.projet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * RowMapper de la classe "Secteur"
 *
 * @author Banane
 */
@Named
public class SecteurRM implements RowMapper<Secteur> {

    @Inject
    DaoVoie daoVoieImpl;

    @Override
    public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {

        ArrayList<Voie> voies = (ArrayList<Voie>) daoVoieImpl.readAll(rs.getInt("id"));

        Secteur vSecteur = new Secteur();
        vSecteur.setId(rs.getInt("id"));
        vSecteur.setId_spot(rs.getInt("id_spot"));
        vSecteur.setNom(rs.getString("nom"));
        vSecteur.setDescription(rs.getString("description"));
        vSecteur.setVoies(voies);
        return vSecteur;
    }
}
