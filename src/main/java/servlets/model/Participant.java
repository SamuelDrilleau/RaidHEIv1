package servlets.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Participant {
    private String mail;
    private String mdp;
    private String nom;
    private String prenom;
    private String sexe;
    private String tel;
    private String statut;
    private String nomEnt;
    private String nomUrg;
    private String telUrg;
    private int bds;
    private int vtt;
    private int bus;
    private String tshirt;
    private int fftri;
    private String nomEquipe;
    private int attestation;
    private int certifMed;
    private int certifSco;
    private int caution;
    private int paiement;

    public Participant(String mail, String mdp, String nom, String prenom, String sexe, String tel, String statut, String nomEnt, String nomUrg, String telUrg, int bds, int vtt, int bus, String tshirt, int fftri, String nomEquipe, int attestation, int certifMed, int certifSco, int caution, int paiement) {
        this.mail = mail;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.tel = tel;
        this.statut = statut;
        this.nomEnt = nomEnt;
        this.nomUrg = nomUrg;
        this.telUrg = telUrg;
        this.bds = bds;
        this.vtt = vtt;
        this.bus = bus;
        this.tshirt = tshirt;
        this.fftri = fftri;
        this.nomEquipe = nomEquipe;
        this.attestation = attestation;
        this.certifMed = certifMed;
        this.certifSco = certifSco;
        this.caution = caution;
        this.paiement = paiement;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNomEnt() {
        return nomEnt;
    }

    public void setNomEnt(String nomEnt) {
        this.nomEnt = nomEnt;
    }

    public String getNomUrg() {
        return nomUrg;
    }

    public void setNomUrg(String nomUrg) {
        this.nomUrg = nomUrg;
    }

    public String getTelUrg() {
        return telUrg;
    }

    public void setTelUrg(String telUrg) {
        this.telUrg = telUrg;
    }

    public int getBds() {
        return bds;
    }

    public void setBds(int bds) {
        this.bds = bds;
    }

    public int getVtt() {
        return vtt;
    }

    public void setVtt(int vtt) {
        this.vtt = vtt;
    }

    public int getBus() {
        return bus;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }

    public String getTshirt() {
        return tshirt;
    }

    public void setTshirt(String tshirt) {
        this.tshirt = tshirt;
    }

    public int getFftri() {
        return fftri;
    }

    public void setFftri(int fftri) {
        this.fftri = fftri;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getAttestation() {
        return attestation;
    }

    public void setAttestation(int attestation) {
        this.attestation = attestation;
    }

    public int getCertifMed() {
        return certifMed;
    }

    public void setCertifMed(int certifMed) {
        this.certifMed = certifMed;
    }

    public int getCertifSco() {
        return certifSco;
    }

    public void setCertifSco(int certifSco) {
        this.certifSco = certifSco;
    }

    public int getCaution() {
        return caution;
    }

    public void setCaution(int caution) {
        this.caution = caution;
    }

    public int getPaiement() {
        return paiement;
    }

    public void setPaiement(int paiement) {
        this.paiement = paiement;
    }
}
