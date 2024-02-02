package modele;

import java.util.Date;
import java.util.Objects;

public class Coureur {
    private String matricule;
    private String nom;
    private String prenom;
    private String nationalite;
    private Date dateNaiss;

    public Coureur(String matricule, String nom, String prenom, String nationalite, Date dateNaiss) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.dateNaiss = dateNaiss;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coureur coureur = (Coureur) o;
        return Objects.equals(matricule, coureur.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }
}
