package modele;


import java.util.Objects;

/**
 * classe Classement
 * @author Romain Vandenplas
 * @version 1.0
 * @see Coureur
 */
public class Classement {
    /**
     * id du classement
     */
    private int id;
    /**
     * place du coureur
     */
    private int place;
    /**
     * gain du coureur
     */
    private float gain;
    /**
     * coureur
     */
    Coureur coureur;

    /**
     * constructeur de la classe classement
     * @param place
     * @param gain
     * @param coureur
     */
    public Classement(int place, float gain, Coureur coureur) {
        this.place = place;
        this.gain = gain;
        this.coureur = coureur;
    }
    /**
     * getter place
     * @return place
     */
    public int getPlace() {
        return place;
    }
    /**
     * setter place
     * @param place
     */
    public void setPlace(int place) {
        this.place = place;
    }
    /**
     * getter gain
     * @return gain
     */
    public float getGain() {
        return gain;
    }
    /**
     * setter gain
     * @param gain
     */
    public void setGain(float gain) {
        this.gain = gain;
    }
    /**
     * getter coureur
     * @return coureur
     */
    public Coureur getCoureur() {
        return coureur;
    }
    /**
     * setter coureur
     * @param coureur
     */
    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
    }

    /**
     * equals sur l'id
     * @param o
     * @return si les id sont égaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classement that = (Classement) o;
        return id == that.id;
    }

    /**
     * hashcode sur l'id
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
