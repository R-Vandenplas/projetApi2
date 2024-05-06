package MVC.View;

import model.Course;

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

            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));
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
}
