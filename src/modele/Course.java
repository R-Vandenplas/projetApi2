package modele;

import java.util.Date;
import java.util.List;
import java.util.Objects;
/**
 * classe Course
 * @author Romain Vandenplas
 * @version 1.0
 * @see Classement
 * @see Etape
 */
public class Course {
    /**
     * nom de la course
     */
    private String nom;
    /**
     * gain de la course
     */
    private float priceMoeny;
    /**
     * date de debut de la course
     */
    private Date dateDebut;
    /**
     * date de fin de la course
     */
    private Date dateFin;
    /**
     * kilometrage total de la course
     */
    private int kmTotal;

    /**
     * liste des classements
     */
    List<Classement> classement;
    /**
     * liste des etapes
     */
    List<Etape> etapes;
    /**
     * constructeur de la classe course
     * @param nom
     * @param priceMoeny
     * @param dateDebut
     * @param dateFin
     * @param kmTotal
     */
    public Course(String nom, float priceMoeny, Date dateDebut, Date dateFin, int kmTotal) {
        this.nom = nom;
        this.priceMoeny = priceMoeny;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmTotal = kmTotal;
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
     * getter priceMoeny
     * @return priceMoeny
     */
    public float getPriceMoeny() {
        return priceMoeny;
    }
    /**
     * setter priceMoeny
     * @param priceMoeny
     */
    public void setPriceMoeny(float priceMoeny) {
        this.priceMoeny = priceMoeny;
    }
    /**
     * getter dateDebut
     * @return dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }
    /**
     * setter dateDebut
     * @param dateDebut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    /**
     * getter dateFin
     * @return dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }
    /**
     * setter dateFin
     * @param dateFin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    /**
     * getter kmTotal
     * @return kmTotal
     */
    public int getKmTotal() {
        return kmTotal;
    }
    /**
     * setter kmTotal
     * @param kmTotal
     */
    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
    }
    /**
     * getter classement
     * @return classement
     */
    public List<Classement> getClassement() {
        return classement;
    }
    /**
     * setter classement
     * @param classement
     */
    public void setClassement(List<Classement> classement) {
        this.classement = classement;
    }
    /**
     * getter etapes
     * @return etapes
     */
    public List<Etape> getEtapes() {
        return etapes;
    }
    /**
     * setter etapes
     * @param etapes
     */
    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }
    /**
     * methode equals basée sur le nom
     * @param o
     * @return égalité ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(nom, course.nom);
    }
    /**
     * methode hashCode basée sur le nom
     * @return hashCode de la course
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
