package MVC.View;

import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class CourseViewConsole extends CourseAbstractView{

    private Scanner sc = new Scanner(System.in);


    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public Course selectionner() {
        update(courseController.getAll());
        int nl =  choixElt(lc);
        Course c = lc.get(nl-1);
        return c;
    }

    @Override
    public void menu() {
        update(courseController.getAll());
        do {

            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "special", "fin"));
            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    menu_special();
                    break;
                case 6:
                    return;
            }
        } while (true);

    }

    private void ajouter() {
        System.out.println("Nom de la Course:");
        String nom = sc.nextLine();
        System.out.println("PriceMoney de la Course:");
        BigDecimal priceMoney = sc.nextBigDecimal();
        System.out.println("Date de début de la Course:");
        LocalDate dateDebut = lecDate();
        System.out.println("Date de fin de la Course:");
        LocalDate dateFin = lecDate();
        System.out.println("Km total de la Course:");
        int kmTotal = lireInt();
        Course c = courseController.addCourse(new Course(nom,priceMoney,dateDebut,dateFin,kmTotal));
        if(c != null) affMsg("ajout de :"+c);
        else affMsg("erreur d'ajout");


    }
    private void retirer(){
        Course c = selectionner();
        if(c != null){
            if(courseController.removeCourse(c)) affMsg("suppression de :"+c);
            else affMsg("erreur de suppression");
        }
    }
    private void rechercher() {
        System.out.println("id de la course :");
        int id = lireInt();
        Course c = courseController.getCourseById(id);
        if(c != null) affMsg("course trouvé :"+c);
        else affMsg("course non trouvé");
    }

    private void modifier() {
        Course c = selectionner();
        if(c != null){
            System.out.println("Nom de la Course:");
            String nom = sc.nextLine();
            System.out.println("PriceMoney de la Course:");
            BigDecimal priceMoney = sc.nextBigDecimal();
            System.out.println("Date de début de la Course:");
            LocalDate dateDebut = lecDate();
            System.out.println("Date de fin de la Course:");
            LocalDate dateFin = lecDate();
            System.out.println("Km total de la Course:");
            int kmTotal = lireInt();
            c.setNom(nom);
            c.setPriceMoney(priceMoney);
            c.setDateDebut(dateDebut);
            c.setDateFin(dateFin);
            c.setKmTotal(kmTotal);
            if (courseController.updateCourse(c)!=null) affMsg("modification de :"+c);
            else affMsg("erreur de modification");
        }
    }




    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void menu_special(){
        System.out.println("id de la course :");
        int id = lireInt();
        Course c = courseController.getCourseById(id);
        if(c != null){
            affMsg("Menu special de la course :"+c);
            c.getClassement().addAll(classementController.getAllByCourse(c.getId()));
            c.getEtapes().addAll(etapeController.getAllByCourse(c.getId()));
        }

        else {
            affMsg("course non trouvé");
            return;
        }


        do {
            int ch = choixListe(Arrays.asList("Liste des Classements", "Gain Total", "Vainqueur", "addCoureur", "supCoureur", "addResultat", "modifResultat", "addEtape", "supEtape", "liste villes", "classement complet ?","liste etapes", "fin"));
            switch (ch) {
                case 1:
                    listClassement(c);
                    break;
                case 2:
                    gainTotal(c);
                    break;
                case 3:
                    vainqueur(c);
                    break;
                case 4:
                    addCoureur(c);
                    break;
                case 5:
                    supCoureur(c);
                    break;
                case 6:
                    addResultat(c);
                    break;
                case 7:
                    modifResultat(c);
                    break;
                case 8:
                    addEtape(c);
                    break;
                case 9:
                    supEtape(c);
                    break;
                case 10:
                    listeVilles(c);
                    break;
                case 11:
                    classementComplet(c);
                    break;
                case 12:
                    listeEtapes(c);
                    break;
                case 13:
                    return;
            }
        }while (true) ;
        }

    private void listClassement(Course c){
        if(c.listeCoureursPlaceGain().size() == 0) affMsg("Pas de classement");
        else
        affList(c.listeCoureursPlaceGain());
    }
    private void gainTotal(Course c){
        affMsg("Gain total de la course :"+c.gainTotal());
    }
    private void vainqueur(Course c){
        try {
            affMsg("Vainqueur de la course :"+c.vainqueur());
        } catch (Exception e) {
            affMsg("Pas de vainqueur");
        }

    }
    private void addCoureur(Course c){

       Coureur coureur = coureurView.selectionner();
       try{
           c.addCoureur(coureur);
           Classement cl = classementController.addClassement(new Classement(0,new BigDecimal(0),coureur),c);
              if(cl != null) affMsg("ajout du coureur :"+cl + " à la course :"+c);
              else affMsg("erreur d'ajout");
       }
       catch (Exception e){
           affMsg(e.getMessage());
       }


    }
    private void supCoureur(Course c){
        Coureur coureur = coureurView.selectionner();
        c.supCoureur(coureur);
        Boolean test = classementController.removeClassementByCourseIdAndCoureurId(c,coureur);
        if(test) affMsg("suppression du coureur : "+ coureur + " de la course : "+c);
        else affMsg("erreur de suppression");


    }

    private void addResultat(Course c){
        Coureur coureur = coureurView.selectionner();
        System.out.println("Place du coureur :");
        int place = lireInt();
        System.out.println("Gain du coureur :");
        BigDecimal gain = sc.nextBigDecimal();
        try{
            c.resultat(coureur,place,gain);
            Classement cla =classementController.updateClassementByCourseIdAndCoureurId(new Classement(place,gain,coureur),c);
            if(cla != null) affMsg("ajout du resultat :"+cla);
            else affMsg("erreur d'ajout");
        }
        catch (Exception e){
            affMsg(e.getMessage());
        }

    }
    private void modifResultat(Course c){
        Coureur coureur = coureurView.selectionner();
        System.out.println("Place du coureur :");
        int place = lireInt();
        System.out.println("Gain du coureur :");
        BigDecimal gain = sc.nextBigDecimal();
        try{
            c.modif(coureur,place,gain);
            Classement cla =classementController.updateClassementByCourseIdAndCoureurId(new Classement(place,gain,coureur),c);
            if(cla != null) affMsg("modification du resultat :"+cla);
            else affMsg("erreur de modification");
        }
        catch (Exception e){
            affMsg(e.getMessage());
        }

    }
    private void addEtape(Course c){
        List<Etape> etapesLibre = etapeController.getAllByCourse(0);
        if(etapesLibre.size() == 0)
        {
            affMsg("Pas d'étape disponible");
            etapeView.ajouter();
        }
        else {

                System.out.println("Voulez vous ajouter une étape ?");
                int ch = choixListe(Arrays.asList("oui","non"));
                switch (ch) {
                    case 1:
                        etapeView.ajouter();
                        break;
                    case 2:
                        break;

                }

        }

        int nl  = choixListe(etapesLibre) ;
        Etape e = etapesLibre.get(nl-1);
        try {
            c.addEtape(e);
            e.setCourse(c);
            Etape et =etapeController.updateEtape(e);
            if(et != null) affMsg("ajout de l'étape :"+et);
            else affMsg("erreur d'ajout");

        }catch (Exception ex){
            affMsg(ex.getMessage());

        }

    }
    private void supEtape(Course c){

        Etape e = etapeView.selectionner();
        try {
            c.supEtape(e);
            e.setCourse(courseController.getCourseById(0));
            Etape et =etapeController.updateEtape(e);
            if(et != null) affMsg("suppression de l'étape :"+et);
            else affMsg("erreur de suppression");
        }catch (Exception ex){
            affMsg(ex.getMessage());
        }

    }
    private void listeVilles(Course c){
        if (c.listeVilles().size() == 0) affMsg("Pas de ville");
        else affList(c.listeVilles());

    }
    private void classementComplet(Course c){
        if(c.classementComplet()) affMsg("Classement complet");
        else affMsg("Classement incomplet");
    }
    private void listeEtapes(Course c){
        if(c.getEtapes().size() == 0) affMsg("Pas d'étape");
        else affList(c.getEtapes());

    }

}
