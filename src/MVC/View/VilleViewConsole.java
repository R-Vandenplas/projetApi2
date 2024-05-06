package MVC.View;

import model.Ville;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static utilitaires.Utilitaire.*;

public class VilleViewConsole extends VilleAbstractView{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public Ville selectionner() {
        update(villeController.getAll());
        int nl =  choixElt(lv);
        Ville vi = lv.get(nl-1);
        return vi;
    }


    @Override
    public void menu() {
        update(villeController.getAll());
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
        System.out.println("Nom de la Ville:");
        String nom = sc.nextLine();
        System.out.println("Latitude de la Ville:");
        double latitude = lireDouble();
        System.out.println("Longitude de la Ville:");
        double longitude = lireDouble();
        System.out.println("Pays de la Ville:");
        String pays = sc.nextLine();
        Ville v = villeController.addVille(new Ville(nom, latitude, longitude, pays));
        if(v!=null) affMsg("création de :"+v);
        else affMsg("erreur de création");
    }
    private void retirer() {
        Ville v = selectionner();
        if(v!=null) {
            if(villeController.removeVille(v)) affMsg("suppression de :"+v);
            else affMsg("erreur de suppression");
        }
    }
    private void rechercher(){
       System.out.println("id de la ville :");
       int id = lireInt();
       Ville v =villeController.getVilleById(id);
         if(v!=null) affMsg("ville trouvée :"+v);
         else affMsg("ville non trouvée");

    }
    private void modifier(){
        Ville v = selectionner();
        if(v!=null) {
            System.out.println("Nom de la Ville:");
            String nom = sc.nextLine();
            System.out.println("Latitude de la Ville:");
            double latitude = lireDouble();
            System.out.println("Longitude de la Ville:");
            double longitude = lireDouble();
            System.out.println("Pays de la Ville:");
            String pays = sc.nextLine();
            v.setNom(nom);
            v.setLatitude(latitude);
            v.setLongitude(longitude);
            v.setPays(pays);
            if(villeController.updateVille(v)!=null) affMsg("modification de :"+v);
            else affMsg("erreur de modification");
        }
    }


    @Override
    public void affList(List l) {
        affListe(l);
    }
}
