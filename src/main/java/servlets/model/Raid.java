package servlets.model;


import java.sql.Date;
import java.time.LocalDate;

public class Raid {

    private int id=0;
    private LocalDate debut;
    private LocalDate fin;
    private LocalDate changement;
    private String contactMail;
    private String contactTel;
    private String lieu;
    private String presentation;
    private int prixCaution;
    private int prixEtudiantE;
    private int prixEtudiantL;
    private int prixExterneE;
    private int prixExterneL;
    private String nomCom1;
    private String mailCom1;
    private String nomCom2;
    private String mailCom2;
    private String epreuveV1;
    private String epreuveV2;
    private String epreuveS1;
    private String epreuveS2;
    private String epreuveS3;
    private String epreuveD1;
    private String epreuveD2;
    private String plaquetteImg;
    private String equipeImg;
    private String ancienImg;

    public Raid(int id, LocalDate debut, LocalDate changement, LocalDate fin, String contactMail, String contactTel, String lieu, String presentation, int prixCaution, int prixEtudiantE, int prixEtudiantL, int prixExterneE, int prixExterneL, String nomCom1, String mailCom1, String nomCom2, String mailCom2, String epreuveV1, String epreuveV2, String epreuveS1, String epreuveS2, String epreuveS3, String epreuveD1, String epreuveD2, String plaquetteImg, String equipeImg, String ancienImg) {
        this.id = id;
        this.debut = debut;
        this.changement = changement;
        this.fin = fin;
        this.contactMail = contactMail;
        this.contactTel = contactTel;
        this.lieu = lieu;
        this.presentation = presentation;
        this.prixCaution = prixCaution;
        this.prixEtudiantE = prixEtudiantE;
        this.prixEtudiantL = prixEtudiantL;
        this.prixExterneE = prixExterneE;
        this.prixExterneL = prixExterneL;
        this.nomCom1 = nomCom1;
        this.mailCom1 = mailCom1;
        this.nomCom2 = nomCom2;
        this.mailCom2 = mailCom2;
        this.epreuveV1 = epreuveV1;
        this.epreuveV2 = epreuveV2;
        this.epreuveS1 = epreuveS1;
        this.epreuveS2 = epreuveS2;
        this.epreuveS3 = epreuveS3;
        this.epreuveD1 = epreuveD1;
        this.epreuveD2 = epreuveD2;
        this.plaquetteImg = plaquetteImg;
        this.equipeImg = equipeImg;
        this.ancienImg = ancienImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public LocalDate getChangement() {
        return changement;
    }

    public void setChangement(LocalDate changement) {
        this.changement = changement;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public int getPrixCaution() {
        return prixCaution;
    }

    public void setPrixCaution(int prixCaution) {
        this.prixCaution = prixCaution;
    }

    public int getPrixEtudiantE() {
        return prixEtudiantE;
    }

    public void setPrixEtudiantE(int prixEtudiantE) {
        this.prixEtudiantE = prixEtudiantE;
    }

    public int getPrixEtudiantL() {
        return prixEtudiantL;
    }

    public void setPrixEtudiantL(int prixEtudiantL) {
        this.prixEtudiantL = prixEtudiantL;
    }

    public int getPrixExterneE() {
        return prixExterneE;
    }

    public void setPrixExterneE(int prixExterneE) {
        this.prixExterneE = prixExterneE;
    }

    public int getPrixExterneL() {
        return prixExterneL;
    }

    public void setPrixExterneL(int prixExterneL) {
        this.prixExterneL = prixExterneL;
    }

    public String getNomCom1() {
        return nomCom1;
    }

    public void setNomCom1(String nomCom1) {
        this.nomCom1 = nomCom1;
    }

    public String getMailCom1() {
        return mailCom1;
    }

    public void setMailCom1(String mailCom1) {
        this.mailCom1 = mailCom1;
    }

    public String getNomCom2() {
        return nomCom2;
    }

    public void setNomCom2(String nomCom2) {
        this.nomCom2 = nomCom2;
    }

    public String getMailCom2() {
        return mailCom2;
    }

    public void setMailCom2(String mailCom2) {
        this.mailCom2 = mailCom2;
    }

    public String getEpreuveV1() {
        return epreuveV1;
    }

    public void setEpreuveV1(String epreuveV1) {
        this.epreuveV1 = epreuveV1;
    }

    public String getEpreuveV2() {
        return epreuveV2;
    }

    public void setEpreuveV2(String epreuveV2) {
        this.epreuveV2 = epreuveV2;
    }

    public String getEpreuveS1() {
        return epreuveS1;
    }

    public void setEpreuveS1(String epreuveS1) {
        this.epreuveS1 = epreuveS1;
    }

    public String getEpreuveS2() {
        return epreuveS2;
    }

    public void setEpreuveS2(String epreuveS2) {
        this.epreuveS2 = epreuveS2;
    }

    public String getEpreuveS3() {
        return epreuveS3;
    }

    public void setEpreuveS3(String epreuveS3) {
        this.epreuveS3 = epreuveS3;
    }

    public String getEpreuveD1() {
        return epreuveD1;
    }

    public void setEpreuveD1(String epreuveD1) {
        this.epreuveD1 = epreuveD1;
    }

    public String getEpreuveD2() {
        return epreuveD2;
    }

    public void setEpreuveD2(String epreuveD2) {
        this.epreuveD2 = epreuveD2;
    }

    public String getPlaquetteImg() {
        return plaquetteImg;
    }

    public void setPlaquetteImg(String plaquetteImg) {
        this.plaquetteImg = plaquetteImg;
    }

    public String getEquipeImg() {
        return equipeImg;
    }

    public void setEquipeImg(String equipeImg) {
        this.equipeImg = equipeImg;
    }

    public String getAncienImg() {
        return ancienImg;
    }

    public void setAncienImg(String ancienImg) {
        this.ancienImg = ancienImg;
    }
}
