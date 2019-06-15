package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoDepartement;
import fr.banane.projet6.consumer.contract.dao.DaoPrivilege;
import fr.banane.projet6.consumer.contract.dao.DaoSexe;
import fr.banane.projet6.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * RowMapper de la classe "Utilisateur"
 *
 * @author Banane
 */
@Named
public class UtilisateurRM implements RowMapper<Utilisateur> {

    @Inject
    DaoPrivilege daoPrivilegeimpl;
    @Inject
    DaoSexe daoSexeImpl;
    @Inject
    DaoDepartement daoDepartementImpl;

    @Override
    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        //id id_sexe pseudo email password departement date_naissance id_privilege
        Utilisateur vUtilisateur = new Utilisateur();

        vUtilisateur.setId(rs.getInt("id"));
        vUtilisateur.setSexe(daoSexeImpl.read(rs.getInt("id_sexe")));
        vUtilisateur.setPseudo(rs.getString("pseudo"));
        vUtilisateur.setEmail(rs.getString("email"));
        vUtilisateur.setPassword(rs.getString("password"));
        vUtilisateur.setDepartement(daoDepartementImpl.read(rs.getInt("departement")));
        vUtilisateur.setDate_naissance(rs.getString("date_naissance"));
        vUtilisateur.setPrivilege(daoPrivilegeimpl.read(rs.getInt("id_privilege")));

        return vUtilisateur;
    }
}
