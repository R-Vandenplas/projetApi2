package modele;

public class Classement {
    private int place;
    private float gain;

    Coureur coureur;

    public Classement(int place, float gain, Coureur coureur) {
        this.place = place;
        this.gain = gain;
        this.coureur = coureur;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public float getGain() {
        return gain;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public Coureur getCoureur() {
        return coureur;
    }

    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
    }


}
