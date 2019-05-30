package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Topo
 *
 * @author Banane
 */
public class Topo {
    // ==================== Attributs ====================
    private int id;
    private int id_user;
    private String nom;
    private String description;
    private String date_creation;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Topo(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_user -
     * @param nom -
     * @param description -
     * @param date_creation -
     */
    public Topo(int id, int id_user,String nom, String description, String date_creation) {
        this.id = id;
        this.id_user = id_user;
        this.nom =nom;
        this.description = description;
        this.date_creation = date_creation;
    }

    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date_creation='" + date_creation + '\'' +
                '}';
    }
}
