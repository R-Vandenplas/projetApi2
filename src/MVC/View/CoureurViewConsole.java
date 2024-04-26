package MVC.View;

import model.Coureur;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class CoureurViewConsole extends CoureurAbstractView {


    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public Coureur selectionner() {
        update(coureurController.getAll());
        int nl = choixElt(lc);
        Coureur co = lc.get(nl - 1);
        return co;
    }


    @Override
    public void menu() {
        update(coureurController.getAll());
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
        System.out.println("Matricule du coureur:");
        String matricule = sc.nextLine();
        System.out.println("Nom du coureur:");
        String nom = sc.nextLine();
        System.out.println("Prenom du coureur:");
        String prenom = sc.nextLine();
        System.out.println("Nationalité du coureur:");
        String nationalite = sc.nextLine();
        System.out.println("Date de naissance du coureur:");
        LocalDate dateNaiss = lecDate();
        Coureur c = coureurController.addCoureur(new Coureur(matricule, nom, prenom, nationalite, dateNaiss));
        if (c != null) affMsg("création de :" + c);
        else affMsg("erreur de création");
    }

    private void retirer() {
        Coureur c = selectionner();
        if (c != null) {
            if (coureurController.removeCoureur(c)) affMsg("suppression de :" + c);
            else affMsg("erreur de suppression");
        }
    }

    private void rechercher() {
        System.out.println("id du coureur :");
        int id = lireInt();
        Coureur c = coureurController.getCoureurById(id);
        if (c != null) affMsg("coureur trouvée :" + c);
        else affMsg("coureur non trouvée");

    }

    private void modifier() {
        Coureur c = selectionner();
        if (c != null) {
            System.out.println("Matricule du coureur:");
            String matricule = sc.nextLine();
            System.out.println("Nom du coureur:");
            String nom = sc.nextLine();
            System.out.println("Prenom du coureur:");
            String prenom = sc.nextLine();
            System.out.println("Nationalité du coureur:");
            String nationalite = sc.nextLine();
            System.out.println("Date de naissance du coureur:");
            LocalDate dateNaiss = lecDate();
            c.setMatricule(matricule);
            c.setNom(nom);
            c.setPrenom(prenom);
            c.setNationalite(nationalite);
            c.setDateNaiss(dateNaiss);
            if (coureurController.updateCoureur(c) != null) affMsg("modification de :" + c);
            else affMsg("erreur de modification");
        }
    }


    @Override
    public void affList(List l) {
        affListe(l);
    }
}


