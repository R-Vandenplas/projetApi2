package modele;


/**
 * classe Classement
 * @author Romain Vandenplas
 * @version 1.0
 * @see Coureur
 */
public class Classement {
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


}
