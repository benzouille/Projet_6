package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoUser;
import fr.banane.projet6.model.bean.Commentaire;

import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CommentaireRM implements RowMapper<Commentaire> {
    //TODO à continuer
    @Inject
    DaoUser daoUserImpl;

    @Override
    public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
