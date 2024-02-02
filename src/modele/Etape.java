package modele;

import java.util.Date;
import java.util.Objects;

public class Etape {
    private int numero;
    private String description;
    private int km;
    private Date dateEtape;

    private Ville villeDepart;
    private Ville villeArrivee;
    private Course course;

    public Etape(int numero, String description, int km, Date dateEtape, Ville villeDepart, Ville villeArrivee, Course course) {
        this.numero = numero;
        this.description = description;
        this.km = km;
        this.dateEtape = dateEtape;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.course = course;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Date getDateEtape() {
        return dateEtape;
    }

    public void setDateEtape(Date dateEtape) {
        this.dateEtape = dateEtape;
    }

    public Ville getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    public Ville getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(Ville villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etape etape = (Etape) o;
        return numero == etape.numero && Objects.equals(course, etape.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, course);
    }
}
