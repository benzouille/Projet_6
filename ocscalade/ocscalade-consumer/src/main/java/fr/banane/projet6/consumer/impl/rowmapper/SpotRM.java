package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.*;
import fr.banane.projet6.model.bean.*;
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
    @Inject
    DaoDepartement daoDepartementImpl;
    @Inject
    DaoCommentaire daoCommentaireImpl;

    @Override
    public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Liste de secteur
        ArrayList<Secteur> secteurs = (ArrayList<Secteur>) daoSecteurImpl.readAllByIdSpot(rs.getInt("id"));

        //Liste d'image
        ArrayList<Image> images = (ArrayList<Image>) daoImageImpl.readAll(rs.getInt("id"));

        //Le créateur
        Utilisateur createur =daoUtilisateurImpl.read(rs.getInt("id_createur"));

        //Departement
        Departement departement = daoDepartementImpl.read(rs.getInt("id_departement"));

        //Commentaires
        ArrayList<Commentaire> commentaires = (ArrayList<Commentaire>) daoCommentaireImpl.readAllBySpot(rs.getInt("id"));

        return new Spot(rs.getInt("id"),
                createur,
                secteurs,
                images,
                rs.getBoolean("officiel"),
                rs.getString("nom"),
                departement,
                rs.getString("adresse"),
                rs.getString("description"),
                commentaires);

    }
}
