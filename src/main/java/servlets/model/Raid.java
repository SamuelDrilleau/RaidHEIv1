package servlets.model;

public class Raid {

    private int annee;
    private int id=0;

    public Raid(int annee) {
        this.annee = annee;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
