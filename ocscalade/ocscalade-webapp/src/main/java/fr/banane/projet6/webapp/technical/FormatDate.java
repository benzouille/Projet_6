package fr.banane.projet6.webapp.technical;

import fr.banane.projet6.model.bean.Commentaire;
import fr.banane.projet6.model.bean.Spot;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormatDate {

    private String patternFr ="dd/MM/yyyy";
    private String patternEn ="yyyy-MM-dd";
    private String PatternLongFr ="dd/MM/yyyy HH.mm.ss";

    public FormatDate(){}

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

    public String formatDateAffichage(Timestamp timestamp){
        SimpleDateFormat simpleDateFormatFr = new SimpleDateFormat(patternFr);
        return simpleDateFormatFr.format(timestamp);
    }

    public String formatDateHeureAffichage(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormatFr = new SimpleDateFormat(PatternLongFr);
        return simpleDateFormatFr.format(timestamp);
    }

    public List<String> changeFormatDateHeure(Spot spot){
        List<Commentaire> vListCommentaires = spot.getCommentaires();
        ArrayList<String> temps = new ArrayList<String>();
        for (Commentaire commentaire : vListCommentaires){

            temps.add(formatDateHeureAffichage(commentaire.getDate()));
        }
        return temps;
    }
}
