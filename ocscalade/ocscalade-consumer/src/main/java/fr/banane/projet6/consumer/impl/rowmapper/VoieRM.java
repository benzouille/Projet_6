package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoDifficulte;
import fr.banane.projet6.consumer.impl.dao.DaoDifficulteImpl;
import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
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

    @Inject
    DaoDifficulte daoDifficulteImpl;

    @Override
    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Difficulte difficulte = daoDifficulteImpl.read(rs.getInt("id_difficulte"));

        Voie vVoie = new Voie();
        vVoie.setId(rs.getInt("id"));
        vVoie.setNom(rs.getString("nom"));
        vVoie.setId_secteur(rs.getInt("id_secteur"));
        vVoie.setDifficulte(difficulte);
        vVoie.setEquipement(rs.getBoolean("equipement"));
        vVoie.setNb_point(rs.getInt("nb_point"));
        vVoie.setNb_longueur(rs.getInt("nb_longueur"));
        vVoie.setDescription(rs.getString("description"));

        return vVoie;
    }
}
