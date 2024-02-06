package modele;

import java.util.Objects;


/**
 * classe Ville
 * @author Romain
 * @version 1.0
 * @see Etape
 */
public class Ville {
    /**
     * nom de la ville
     */
    private String nom;
    /**
     * latitude de la ville
     */
    private double latitude;
    /**
     * longitude de la ville
     */
    private double longitude;
    /**
     * pays de la ville
     */
    private String pays;

    /**
     * constructeur de la classe ville
     * @param nom
     * @param latitude
     * @param longitude
     * @param pays
     */
    public Ville(String nom, double latitude, double longitude, String pays) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pays = pays;
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
     * getter latitude
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }
    /**
     * setter latitude
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    /**
     * getter longitude
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }
    /**
     * setter longitude
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    /**
     * getter pays
     * @return pays
     */
    public String getPays() {
        return pays;
    }
    /**
     * setter pays
     * @param pays
     */
    public void setPays(String pays) {
        this.pays = pays;
    }
    /**
     * methode equals basée sur la latitude et la longitude
     * @param o
     * @return égalité ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return Double.compare(latitude, ville.latitude) == 0 && Double.compare(longitude, ville.longitude) == 0;
    }
    /**
     * methode hashCode basée sur la latitude et la longitude
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
