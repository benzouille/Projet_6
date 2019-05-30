package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Privilege
 *
 * @author Banane
 */
public class Privilege {

    // ==================== Attributs ====================
    private int id;
    private String privilege;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Privilege(){
    }

    /**
     * Constructeur
     * @param id -
     * @param privilege -
     */
    public Privilege(int id, String privilege) {
        this.id = id;
        this.privilege = privilege;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
