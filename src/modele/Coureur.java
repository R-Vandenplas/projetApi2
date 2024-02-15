package modele;

import java.util.Date;
import java.util.Objects;
/**
 * classe Coureur
 * @author Romain Vandenplas
 * @version 1.0
 */
public class Coureur {
    /**
     * id du coureur
     */
    public int id;
    /**
     * matricule du coureur
     */
    private String matricule;
    /**
     * nom du coureur
     */
    private String nom;
    /**
     * prenom du coureur
     */
    private String prenom;
    /**
     * nationalite du coureur
     */
    private String nationalite;
    /**
     * date de naissance du coureur
     */
    private Date dateNaiss;

    /**
     * constructeur de la classe coureur
     * @param matricule
     * @param nom
     * @param prenom
     * @param nationalite
     * @param dateNaiss
     */
    public Coureur(String matricule, String nom, String prenom, String nationalite, Date dateNaiss) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.dateNaiss = dateNaiss;
    }
    /**
     * getter matricule
     * @return matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * setter matricule
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    /**
     * getter nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter prenom
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter nationalite
     * @return nationalite
     */
    public String getNationalite() {
        return nationalite;
    }
    /**
     * setter nationalite
     * @param nationalite
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    /**
     * getter date de naissance
     * @return dateNaiss
     */
    public Date getDateNaiss() {
        return dateNaiss;
    }
    /**
     * setter date de naissance
     * @param dateNaiss
     */
    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    /**
     * methode equals basée l'id
     * @param o
     * @return si les id sont egaux ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coureur coureur = (Coureur) o;
        return id == coureur.id;
    }
    /**
     * methode hashCode basée sur l'id
     * @return le hashcode du coureur
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
