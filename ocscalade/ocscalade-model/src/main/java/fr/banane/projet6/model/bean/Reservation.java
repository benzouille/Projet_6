package fr.banane.projet6.model.bean;

import java.util.Date;

/**
 * Objet metier représentant une Reservation
 *
 * @author Banane
 */
public class Reservation {

    // ==================== Attributs ====================
    private int id;
    private int id_topo;
    private int id_user_locataire;
    private Date date;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Reservation(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_topo -
     * @param id_user_locataire -
     * @param date -
     */
    public Reservation(int id, int id_topo, int id_user_locataire, Date date) {
        this.id = id;
        this.id_topo = id_topo;
        this.id_user_locataire = id_user_locataire;
        this.date = date;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_topo() {
        return id_topo;
    }

    public void setId_topo(int id_topo) {
        this.id_topo = id_topo;
    }

    public int getId_user_locataire() {
        return id_user_locataire;
    }

    public void setId_user_locataire(int id_user_locataire) {
        this.id_user_locataire = id_user_locataire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", id_topo=" + id_topo +
                ", id_user_locataire=" + id_user_locataire +
                ", date=" + date +
                '}';
    }
}
