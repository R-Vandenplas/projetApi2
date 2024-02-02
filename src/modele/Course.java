package modele;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Course {
    private String nom;
    private float priceMoeny;
    private Date dateDebut;
    private Date dateFin;
    private int kmTotal;
    List<Classement> classement;

    List<Etape> etapes;

    public Course(String nom, float priceMoeny, Date dateDebut, Date dateFin, int kmTotal) {
        this.nom = nom;
        this.priceMoeny = priceMoeny;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmTotal = kmTotal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPriceMoeny() {
        return priceMoeny;
    }

    public void setPriceMoeny(float priceMoeny) {
        this.priceMoeny = priceMoeny;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getKmTotal() {
        return kmTotal;
    }

    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
    }

    public List<Classement> getClassement() {
        return classement;
    }

    public void setClassement(List<Classement> classement) {
        this.classement = classement;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(nom, course.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
