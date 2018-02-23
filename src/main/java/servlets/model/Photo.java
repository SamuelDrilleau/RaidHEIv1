package servlets.model;

public class Photo {
    private Integer id;
    private int annee;
    private String nom;

    public Photo(int id, int annee, String nom) {
        this.id = id;
        this.annee = annee;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
