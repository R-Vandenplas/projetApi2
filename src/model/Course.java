package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * classe Course
 *
 * @author Romain Vandenplas
 * @version 1.0
 * @see Classement
 * @see Etape
 */
public class Course {
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

    /**
     * constructeur de la classe course
     *
     * @param nom
     * @param priceMoney
     * @param dateDebut
     * @param dateFin
     * @param kmTotal
     */
    public Course(String nom, BigDecimal priceMoney, LocalDate dateDebut, LocalDate dateFin, int kmTotal) {
        this.nom = nom;
        this.priceMoney = priceMoney;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmTotal = kmTotal;
    }

    /**
     * constructeur de la classe course avec id
     *
     * @param id
     * @param nom
     * @param priceMoney
     * @param dateDebut
     * @param dateFin
     * @param kmTotal
     */
    public Course(int id, String nom, BigDecimal priceMoney, LocalDate dateDebut, LocalDate dateFin, int kmTotal) {
        this.id = id;
        this.nom = nom;
        this.priceMoney = priceMoney;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmTotal = kmTotal;
    }
    //<--------------getters & setters--------------->

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return id == course.id;
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
                '}';
    }
    //<------------------methodes développées------------------->

    /**
     * Retourne la liste des coureurs avec leur place et leur gain
     *
     * @return liste des coureurs avec leur place et leur gain
     */
    public List<Classement> listeCoureursPlaceGain() {
        return classement;
    }

    /**
     * Retourne le gain total de la course
     *
     * @return gain total de la course
     */
    public BigDecimal gainTotal() {
        BigDecimal gainTotal = new BigDecimal(0);
        for (Classement c : classement) {
            gainTotal = gainTotal.add(c.getGain());
        }
        return gainTotal;
    }

    /**
     * Retourne le coureur vainqueur en cherchant dans le classement le coureur avec la place 1
     *
     * @return coureur vainqueur
     */
    public Coureur vainqueur() {
        for (Classement c : classement) {
            if (c.getPlace() == 1) {
                return c.getCoureur();
            }
        }
        throw new RuntimeException("Pas de vainqueur dans le classement");
    }

    /**
     * Ajoute un coureur au classement avec une place et un gain à 0
     *
     * @param c coureur à ajouter
     */
    public void addCoureur(Coureur c) {
        for (Classement cl : classement) {
            if (cl.getCoureur().equals(c)) {
                throw new RuntimeException("Le coureur est déjà inscrit à la course");
            }
        }
        classement.add(new Classement(0, new BigDecimal(0), c));
    }

    /**
     * Supprime un coureur et son classement de la liste des classements avec un iterator
     *
     * @param c coureur à supprimer
     */
    public void supCoureur(Coureur c) {
        Iterator<Classement> iterator = classement.iterator();
        while (iterator.hasNext()) {
            Classement cl = iterator.next();
            if (cl.getCoureur().equals(c)) {
                iterator.remove();
            }
        }
    }


    /**
     * Permet de donner le classement d'un coureur avec sa place et son gain si il n'a pas déjà de classement
     * Attention le equals etant sur l'id si l'objet coureur n'a pas d'id la méthode ne fonctionnera pas
     *
     * @param c     coureur à modifier
     * @param place nouvelle place
     * @param gain  nouveau gain
     */
    public void resultat(Coureur c, int place, BigDecimal gain) {
        Boolean test = false;
        for (Classement cl : classement) {
            if (cl.getCoureur().equals(c)) {
                test = true;
                if (cl.getPlace() == 0) {
                    cl.setPlace(place);
                    cl.setGain(gain);
                } else
                    throw new RuntimeException("Le coureur a déjà un classement");
            }
        }
        if (!test) {
            throw new RuntimeException("Le coureur n'est pas inscrit à la course");
        }


    }

    /**
     * Permet de modifier le classement d'un coureur avec sa place et son gain, le coureur doit déjà avoir un classement
     * Attention le equals etant sur l'id si l'objet coureur n'a pas d'id la méthode ne fonctionnera pas
     *
     * @param c     coureur à modifier
     * @param place nouvelle place
     * @param gain  nouveau gain
     */
    public void modif(Coureur c, int place, BigDecimal gain) {
        Boolean test = false;
        for (Classement cl : classement) {
            if (cl.getCoureur().equals(c)) {
                test = true;
                if (cl.getPlace() != 0) {
                    cl.setPlace(place);
                    cl.setGain(gain);
                } else
                    throw new RuntimeException("Le coureur n'a pas de classement");

            }
        }
        if (!test) {
            throw new RuntimeException("Le coureur n'est pas inscrit à la course");
        }
    }


    /**
     * Ajoute une étape à la liste des étapes
     *
     * @param e étape à ajouter
     */
    public void addEtape(Etape e) {
        if(getEtapes().contains(e)){
            throw new RuntimeException("L'étape est déjà dans la course");
        }
        getEtapes().add(e);
    }

    /**
     * Supprime une étape de la liste des étapes avec un iterator
     *
     * @param e étape à supprimer
     */
    public void supEtape(Etape e) {
        boolean test = false;
        Iterator<Etape> iterator = etapes.iterator();
        while (iterator.hasNext()) {
            Etape et = iterator.next();
            if (et.equals(e)) {
                iterator.remove();
                test = true;
            }
        }
        if (!test) {
            throw new RuntimeException("L'étape n'est pas dans la course");
        }

    }

    /**
     * Retourne la liste des villes en affichant une seule fois chaque ville
     *
     * @return liste des villes de la course
     */
    public List<Ville> listeVilles() {
        List<Ville> villes = new ArrayList<>();
        for (Etape e : etapes) {
            if (!villes.contains(e.getVilleDepart())) {
                villes.add(e.getVilleDepart());
            }
            if (!villes.contains(e.getVilleArrivee())) {
                villes.add(e.getVilleArrivee());
            }

        }
        return villes;
    }

    /**
     * verifie si tout les coureurs ont un classement différent de 0 donc si ils ont participé à la course
     *
     * @return true ou false true si tout les coureurs ont un classement différent de 0 false si un cours n'a pas de classement
     */
    public boolean classementComplet() {
        for (Classement c : classement) {
            if (c.getPlace() == 0) {
                return false;
            }
        }
        return true;
    }


}

