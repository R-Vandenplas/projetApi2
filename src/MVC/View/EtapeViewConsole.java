package MVC.View;

import model.Course;
import model.Etape;
import model.Ville;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class EtapeViewConsole extends EtapeAbstractView{
    private Scanner sc = new Scanner(System.in);


    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public Etape selectionner() {

        update(etapeController.getAll());
        int nl =  choixElt(le);
        Etape e = le.get(nl-1);
        return e;
    }

    @Override
    public void menu() {
        update(etapeController.getAll());
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

    @Override
    public void ajouter() {
        System.out.println("Numéro de l'étape:");
        int numero = lireInt();
        System.out.println("Date de l'étape:");
        LocalDate date = lecDate();
        System.out.println("Kilométrage de l'étape:");
        int km = lireInt();
        System.out.println("Description de l'étape:");
        String description = sc.nextLine();
        System.out.println("Ville de départ de l'étape:");
        Ville VilleDepart = villeView.selectionner();
        System.out.println("Ville d'arrivée de l'étape:");
        Ville VilleArrivee =villeView.selectionner();
        System.out.println("Course de l'étape:");
        Course Course = courseView.selectionner();
        Etape e =etapeController.addEtape(new Etape( numero, description, km, date, VilleDepart,VilleArrivee, Course));
        if(e != null) affMsg("ajout de :"+e);
        else affMsg("erreur d'ajout");
    }
    private void retirer() {
        Etape e = selectionner();
        if(e!=null) {
            if(etapeController.removeEtape(e)) affMsg("suppression de :"+e);
            else affMsg("erreur de suppression");
        }
    }

    private void rechercher() {
        System.out.println("Id de l'étape:");
        int id = lireInt();
        Etape e = etapeController.getEtapeById(id);
        if(e!=null) affMsg("recherche de :"+e);
        else affMsg("erreur de recherche");
    }

    private void modifier() {
        Etape e = selectionner();
        if(e!=null) {
            System.out.println("Numéro de l'étape:");
            int numero = lireInt();
            System.out.println("Date de l'étape:");
            LocalDate date = lecDate();
            System.out.println("Kilométrage de l'étape:");
            int km = lireInt();
            System.out.println("Description de l'étape:");
            String description = sc.nextLine();
            System.out.println("Ville de départ de l'étape:");
            Ville VilleDepart = villeView.selectionner();
            System.out.println("Ville d'arrivée de l'étape:");
            Ville VilleArrivee =villeView.selectionner();
            System.out.println("Course de l'étape:");
            Course Course = courseView.selectionner();
            e.setNumero(numero);
            e.setDateEtape(date);
            e.setKm(km);
            e.setDescription(description);
            e.setVilleDepart(VilleDepart);
            e.setVilleArrivee(VilleArrivee);
            e.setCourse(Course);
            if(etapeController.updateEtape(e)!=null) affMsg("modification de :"+e);
            else affMsg("erreur de modification");
        }
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }
}
