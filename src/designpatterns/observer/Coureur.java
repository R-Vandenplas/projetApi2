package designpatterns.observer;

import java.time.LocalDate;
import java.util.Objects;

/**
 * classe Coureur
 * @author Romain Vandenplas
 * @version 1.0
 */
public class Coureur extends Observer {
    //<--------------attributs--------------->
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
    private LocalDate dateNaiss;
    //<--------------constructeurs--------------->
    /**
     * constructeur de la classe coureur
     * @param matricule
     * @param nom
     * @param prenom
     * @param nationalite
     * @param dateNaiss
     */
    public Coureur(String matricule, String nom, String prenom, String nationalite, LocalDate dateNaiss) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.dateNaiss = dateNaiss;
    }

    /**
     * constructeur de la classe coureur avec id
     * @param id
     * @param matricule
     * @param nom
     * @param prenom
     * @param nationalite
     * @param dateNaiss
     */
    public Coureur(int id, String matricule, String nom, String prenom, String nationalite, LocalDate dateNaiss) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.dateNaiss = dateNaiss;
    }
    //<--------------getters et setters--------------->
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
    public LocalDate getDateNaiss() {
        return dateNaiss;
    }
    /**
     * setter date de naissance
     * @param dateNaiss
     */
    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    /**
     * methode equals basée l'id
     * @param o
     * @return si les id sont egaux ou non
     */
    //<--------------methodes equals et hashcode--------------->
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
    @Override
    public void update(String msg) {
        System.out.println(prenom+" "+nom+" a reçu le msg :"+msg);
    }
}
