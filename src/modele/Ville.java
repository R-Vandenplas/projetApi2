package modele;

import java.util.Objects;

public class Ville {
    private String nom;
    private double latitude;
    private double longitude;
    private String pays;

    public Ville(String nom, double latitude, double longitude, String pays) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return Double.compare(latitude, ville.latitude) == 0 && Double.compare(longitude, ville.longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
