package designpatterns.builder;

import java.time.LocalDate;
import java.util.Objects;

/**
 * classe Coureur
 * @author Romain Vandenplas
 * @version 1.0
 */
public class Coureur {
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
    private Coureur(CoureurBuilder builder) {
        this.id = builder.id;
        this.matricule = builder.matricule;
        this.nom = builder.nom;
        this.prenom = builder.prenom;
        this.nationalite = builder.nationalite;
        this.dateNaiss = builder.dateNaiss;
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
    public String toString() {
        return "Coureur{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", dateNaiss=" + dateNaiss +
                '}';
    }

    //<--------------builder--------------->
public static class CoureurBuilder {
        private int id;
        private String matricule;
        private String nom;
        private String prenom;
        private String nationalite;
        private LocalDate dateNaiss;

        public CoureurBuilder() {

        }

        public CoureurBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CoureurBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public CoureurBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public CoureurBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public CoureurBuilder setNationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        public CoureurBuilder setDateNaiss(LocalDate dateNaiss) {
            this.dateNaiss = dateNaiss;
            return this;
        }

        public Coureur build() throws Exception {
            if(matricule == null || nom == null || prenom == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Coureur(this);
        }
    }


}
