package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Image;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Image"
 *
 * @author Banane
 */
@Named
public class ImageRM implements RowMapper<Image> {
    @Override
    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
        Image vImage = new Image();
        vImage.setId(rs.getInt("id"));
        vImage.setId_spot(rs.getInt("id_spot"));
        vImage.setTitre(rs.getString("titre"));
        vImage.setPath(rs.getString("path"));

        return vImage;
    }
}
