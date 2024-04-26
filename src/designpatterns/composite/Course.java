package designpatterns.composite;

import model.Classement;
import model.Etape;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe Course
 *
 * @author Romain Vandenplas
 * @version 1.0
 * @see Classement
 * @see Etape
 */
public class Course extends Element {
    //<--------------attributs--------------->
    /**
     * id de la course
     */
    private int id;

    /**
     * nom de la course
     */
    private String nom;
    /**
     * gain de la course
     */
    private BigDecimal priceMoney;
    /**
     * date de debut de la course
     */
    private LocalDate dateDebut;
    /**
     * date de fin de la course
     */
    private LocalDate dateFin;
    /**
     * kilometrage total de la course
     */
    private int kmTotal;

    /**
     * liste des classements
     */
    List<Classement> classement = new ArrayList<>();
    /**
     * liste des etapes
     */
    List<Etape> etapes = new ArrayList<>();

    //<--------------constructeurs--------------->
    public Course(int id, String nom, BigDecimal priceMoney, LocalDate dateDebut, LocalDate dateFin, int kmTotal) {
        super(id);
        this.nom = nom;
        this.priceMoney = priceMoney;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmTotal = kmTotal;
    }
    //<--------------getters & setters--------------->

    /**
     * getter nom
     *
     * @return nom
     */

    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter priceMoney
     *
     * @return priceMoney
     */
    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    /**
     * setter priceMoney
     *
     * @param priceMoney
     */
    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    /**
     * getter dateDebut
     *
     * @return dateDebut
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * setter dateDebut
     *
     * @param dateDebut
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * getter dateFin
     *
     * @return dateFin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * setter dateFin
     *
     * @param dateFin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * getter kmTotal
     *
     * @return kmTotal
     */
    public int getKmTotal() {
        return kmTotal;
    }

    /**
     * setter kmTotal
     *
     * @param kmTotal
     */
    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
    }

    /**
     * getter classement
     *
     * @return classement
     */
    public List<Classement> getClassement() {
        return classement;
    }

    /**
     * setter classement
     *
     * @param classement
     */
    public void setClassement(List<Classement> classement) {
        this.classement = classement;
    }

    /**
     * getter etapes
     *
     * @return etapes
     */
    public List<Etape> getEtapes() {
        return etapes;
    }

    /**
     * setter etapes
     *
     * @param etapes
     */
    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }
    //<--------------methodes equals et hashcode--------------->

    /**
     * methode equals basée sur l'id
     *
     * @param o
     * @return égalité ou non
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return nom.equals(course.nom);
    }

    @Override
    public BigDecimal totPriceMoney() {
        return priceMoney;
    }

    /**
     * methode hashCode basée sur l'id
     *
     * @return hashCode de la course
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", priceMoney=" + priceMoney +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", kmTotal=" + kmTotal +
                ", classement=" + classement +
                ", etapes=" + etapes +
                '}';
    }
}


