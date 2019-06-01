package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.impl.dao.DaoDifficulteImpl;
import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * RowMapper de la classe "Voie"
 *
 * @author Banane
 */
@Named
public class VoieRM implements RowMapper<Voie> {

    @Override
    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Voie vVoie = new Voie();
        vVoie.setId(rs.getInt("id"));
        vVoie.setId_secteur(rs.getInt("id_secteur"));
        //TODO a remplir apres avoir fait les impl de difficulte
        Difficulte difficulte = DaoDifficulteImpl.read(rs.)

        vVoie
        return vVoie;
    }
}
