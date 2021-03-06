package fr.banane.projet6.model.bean;

import fr.banane.projet6.model.exception.DuplicateException;
import fr.banane.projet6.model.exception.StringSetException;

/**
 * Objet metier représentant un Utilisateur
 *
 * @author Banane
 */
public class Utilisateur {

    // ==================== Attributs ====================
    private int id;
    private Sexe sexe;
    private Privilege privilege;
    private String pseudo;
    private String email;
    private String password;
    private Departement departement;
    private String date_naissance;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Utilisateur(){
        this.sexe = new Sexe(3, "non renseigné");
        this.privilege = new Privilege(1, "utilisateur");
        this.departement = new Departement(102, "non renseigné", "non renseigné");
        this.date_naissance = "inconnu";
    }

    /**
     * Constructeur
     * @param id -
     * @param sexe -
     * @param privilege -
     * @param pseudo -
     * @param email -
     * @param password -
     * @param departement -
     * @param date_naissance -
     */
    public Utilisateur(int id, Sexe sexe, Privilege privilege, String pseudo, String email, String password, Departement departement, String date_naissance){
        this.id = id;
        this.sexe = sexe;
        this.privilege = privilege;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.departement = departement;
        this.date_naissance = date_naissance;
    }

    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) throws StringSetException {
        if(pseudo.length() > 10) {
            throw new StringSetException("Le pseudo est trop grand ! (10 caractères maximum)");
        }else{
            this.pseudo = pseudo;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", sexe=" + sexe +
                ", privilege=" + privilege +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", departement=" + departement +
                ", date_naissance='" + date_naissance + '\'' +
                '}';
    }
}
