package fr.banane.projet6.webapp.technical;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe permettant de convertir des String en Timestamp
 */
public class FormatDate {

    private String patternEn ="yyyy-MM-dd";

    public FormatDate(){}

    /**
     * Méthode permettant de convertir un String en Timestamp
     * @param dateStr string
     * @return Timestamp
     */
    public Timestamp stringToTimestamp(String dateStr){
        if(dateStr != null){
            SimpleDateFormat simpleDateFormatEn = new SimpleDateFormat(patternEn);
            Date date = simpleDateFormatEn.parse(dateStr, new ParsePosition(0));
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        }
        else {
            return null;
        }
    }
}
