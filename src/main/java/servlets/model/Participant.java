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
    private String bds;
    private String vtt;
    private String bus;
    private String tshirt;
    private String fftri;
    private String nomEquipe;
    private String attestation;
    private String certifMed;
    private String certifSco;

    public Participant(String mail, String mdp, String nom, String prenom, String sexe, String tel, String statut, String nomEnt, String nomUrg, String telUrg, String bds, String vtt, String bus, String tshirt, String fftri, String nomEquipe, String attestation, String certifMed, String certifSco) {
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

    public String getBds() {
        return bds;
    }

    public void setBds(String bds) {
        this.bds = bds;
    }

    public String getVtt() {
        return vtt;
    }

    public void setVtt(String vtt) {
        this.vtt = vtt;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getTshirt() {
        return tshirt;
    }

    public void setTshirt(String tshirt) {
        this.tshirt = tshirt;
    }

    public String getFftri() {
        return fftri;
    }

    public void setFftri(String fftri) {
        this.fftri = fftri;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getAttestation() {
        return attestation;
    }

    public void setAttestation(String attestation) {
        this.attestation = attestation;
    }

    public String getCertifMed() {
        return certifMed;
    }

    public void setCertifMed(String certifMed) {
        this.certifMed = certifMed;
    }

    public String getCertifSco() {
        return certifSco;
    }

    public void setCertifSco(String certifSco) {
        this.certifSco = certifSco;
    }
}
