package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoSpot;
import fr.banane.projet6.consumer.contract.dao.DaoUtilisateur;
import fr.banane.projet6.model.bean.Commentaire;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.TechnicalException;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Commentaire"
 *
 * @author Banane
 */
@Named
public class CommentaireRM implements RowMapper<Commentaire> {

    @Inject
    DaoUtilisateur daoUtilisateurImpl;

    @Override
    public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Le créateur
        Utilisateur utilisateur = null;
        try {
            utilisateur = daoUtilisateurImpl.read(rs.getInt("id_user"));
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        Commentaire vCommentaire = new Commentaire();
        vCommentaire.setId(rs.getInt("id"));
        vCommentaire.setUtilisateur(utilisateur);
        vCommentaire.setIdSpot(rs.getInt("id_spot"));
        vCommentaire.setCommentaire(rs.getString("commentaire"));
        vCommentaire.setDate(rs.getTimestamp("date"));

        return vCommentaire;
    }
}
