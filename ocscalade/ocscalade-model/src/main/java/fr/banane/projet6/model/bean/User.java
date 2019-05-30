package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un User
 *
 * @author Banane
 */
public class User {

    // ==================== Attributs ====================
    private int id;
    private int id_sexe;
    private int id_privilege;
    private String pseudo;
    private String email;
    private String password;
    private int departement;
    private String date_naissance;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public User(){
    }

    /**
     * Constructeur
     * @param id
     * @param id_sexe
     * @param id_privilege
     * @param pseudoemail
     * @param password
     * @param departement
     * @param date_naissance
     */
    public User(int id, int id_sexe, int id_privilege, String pseudoemail, String password, int departement, String date_naissance){
        this.id = id;
        this.id_sexe = id_sexe;
        this.id_privilege = id_privilege;
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

    public int getId_sexe() {
        return id_sexe;
    }

    public void setId_sexe(int id_sexe) {
        this.id_sexe = id_sexe;
    }

    public int getId_privilege() {
        return id_privilege;
    }

    public void setId_privilege(int id_privilege) {
        this.id_privilege = id_privilege;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    // ==================== Methodes ====================

    public User(int id, int id_sexe, int id_privilege, String pseudo, String email, String password, int departement, String date_naissance) {
        this.id = id;
        this.id_sexe = id_sexe;
        this.id_privilege = id_privilege;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.departement = departement;
        this.date_naissance = date_naissance;
    }
}
