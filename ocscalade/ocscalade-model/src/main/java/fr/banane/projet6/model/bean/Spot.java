package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Spot
 */
public class Spot {

    // ==================== Attributs ====================

    private int id;
    private int id_createur;
    private boolean officiel;
    private String nom;
    private int departement;
    private String adresse;
    private String description;

    // ==================== Contructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Spot(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_createur -
     * @param officiel -
     * @param nom -
     * @param departement -
     * @param adresse -
     * @param description -
     */
    public Spot(int id, int id_createur, boolean officiel,String nom, int departement, String adresse, String description) {
        this.id = id;
        this.id_createur = id_createur;
        this.officiel = officiel;
        this.nom = nom;
        this.departement = departement;
        this.adresse = adresse;
        this.description = description;
    }
    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_createur() {
        return id_createur;
    }

    public void setId_createur(int id_createur) {
        this.id_createur = id_createur;
    }

    public boolean isOfficiel() {
        return officiel;
    }

    public void setOfficiel(boolean officiel) {
        this.officiel = officiel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", id_createur=" + id_createur +
                ", officiel=" + officiel +
                ", nom='" + nom + '\'' +
                ", departement=" + departement +
                ", adresse='" + adresse + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
