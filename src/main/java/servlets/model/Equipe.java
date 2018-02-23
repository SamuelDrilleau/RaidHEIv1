package servlets.model;

public class Equipe {
    private String nom;
    private String mdp;
    private String typeRaid;

    public Equipe(String nom, String mdp, String typeRaid) {
        this.nom = nom;
        this.mdp = mdp;
        this.typeRaid = typeRaid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getTypeRaid() {
        return typeRaid;
    }

    public void setTypeRaid(String typeRaid) {
        this.typeRaid = typeRaid;
    }
}
