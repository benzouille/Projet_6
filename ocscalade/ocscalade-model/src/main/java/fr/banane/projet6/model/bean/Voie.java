package fr.banane.projet6.model.bean;
/**
 * Objet metier représentant un Topo
 *
 * @author Banane
 */
public class Voie {
    // ==================== Attributs ====================
    private int id;
    private int id_secteur;
    private int id_difficulte;
    private String nom;
    private String description;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Voie(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_secteur -
     * @param id_difficulte -
     * @param nom -
     * @param description -
     */
    public Voie(int id, int id_secteur, int id_difficulte, String nom, String description) {
        this.id = id;
        this.id_secteur = id_secteur;
        this.id_difficulte = id_difficulte;
        this.nom = nom;
        this.description = description;
    }
    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_secteur() {
        return id_secteur;
    }

    public void setId_secteur(int id_secteur) {
        this.id_secteur = id_secteur;
    }

    public int getId_difficulte() {
        return id_difficulte;
    }

    public void setId_difficulte(int id_difficulte) {
        this.id_difficulte = id_difficulte;
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

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Voie{" +
                "id=" + id +
                ", id_secteur=" + id_secteur +
                ", id_difficulte=" + id_difficulte +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}