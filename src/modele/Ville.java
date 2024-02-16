package modele;

import java.util.Objects;


/**
 * classe Ville
 * @author Romain
 * @version 1.0
 * @see Etape
 */
public class Ville {
    //<--------------attributs--------------->
    /**
     * id de la ville
     */
    private int id;
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
    //<--------------constructeurs--------------->
    /**
     * constructeur de la classe ville sans id
     * @param nom nom de la ville
     * @param latitude latitude de la ville
     * @param longitude longitude de la ville
     * @param pays pays de la ville
     */
    public Ville(String nom, double latitude, double longitude, String pays) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pays = pays;
    }

    /**
     * constructeur de la classe ville avec id
     * @param id id de la ville
     * @param nom nom de la ville
     * @param latitude latitude de la ville
     * @param longitude longitude de la ville
     * @param pays pays de la ville
     */
    public Ville(int id, String nom, double latitude, double longitude, String pays) {
        this.id = id;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pays = pays;
    }
    //<--------------getters et setters--------------->
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
    //<--------------equals et hashCode--------------->
    /**
     * methode equals basée sur l'id
     * @param o
     * @return égalité ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return id == ville.id;
    }
    /**
     * methode hashCode basée sur l'id
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash( id);
    }
}
