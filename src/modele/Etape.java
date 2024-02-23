package modele;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * classe Etape
 * @author Romain
 * @version 1.0
 * @see Ville
 * @see Course
 */
public class Etape {
    //<--------------attributs--------------->
    /**
     * id de l'etape
     */
    private int id;
    /**
     * numero de l'etape
     */
    private int numero;
    /**
     * description de l'etape
     */
    private String description;
    /**
     * kilometrage de l'etape
     */
    private int km;
    /**
     * date de l'etape
     */
    private LocalDate dateEtape;
    /**
     * ville de depart
     */
    private Ville villeDepart;
    /**
     * ville d'arrivee
     */
    private Ville villeArrivee;
    /**
     * course
     */
    private Course course;
    //<--------------constructeurs--------------->
    /**
     * constructeur de la classe etape
     * @param numero
     * @param description
     * @param km
     * @param dateEtape
     * @param villeDepart
     * @param villeArrivee
     * @param course
     */
    public Etape(int numero, String description, int km, LocalDate dateEtape, Ville villeDepart, Ville villeArrivee, Course course) {
        this.numero = numero;
        this.description = description;
        this.km = km;
        this.dateEtape = dateEtape;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.course = course;
    }
    //<--------------getters et setters--------------->
    /**
     * getter numero
     * @return numero
     */
    public int getNumero() {
        return numero;
    }
    /**
     * setter numero
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * getter description
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * setter description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * getter km
     * @return km
     */
    public int getKm() {
        return km;
    }
    /**
     * setter km
     * @param km
     */
    public void setKm(int km) {
        this.km = km;
    }
    /**
     * getter dateEtape
     * @return dateEtape
     */
    public LocalDate getDateEtape() {
        return dateEtape;
    }
    /**
     * setter dateEtape
     * @param dateEtape
     */
    public void setDateEtape(LocalDate dateEtape) {
        this.dateEtape = dateEtape;
    }
    /**
     * getter villeDepart
     * @return villeDepart
     */
    public Ville getVilleDepart() {
        return villeDepart;
    }
    /**
     * setter villeDepart
     * @param villeDepart
     */
    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }
    /**
     * getter villeArrivee
     * @return villeArrivee
     */
    public Ville getVilleArrivee() {
        return villeArrivee;
    }
    /**
     * setter villeArrivee
     * @param villeArrivee
     */
    public void setVilleArrivee(Ville villeArrivee) {
        this.villeArrivee = villeArrivee;
    }
    /**
     * getter course
     * @return course
     */
    public Course getCourse() {
        return course;
    }
    /**
     * setter course
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }
    /**
     * methode equals basée sur l'id
     * @param o
     * @return égalité ou non
     */
    //<--------------methodes equals et hashcode--------------->
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etape etape = (Etape) o;
        return id== etape.id;
    }
    /**
     * methode hashCode basée sur l'id
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
