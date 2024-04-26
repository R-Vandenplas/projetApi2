package MVC;

import MVC.Controller.CoureurController;
import MVC.Controller.VilleController;
import MVC.Model.CoureurModelDB;
import MVC.Model.DAOCoureur;
import MVC.Model.DAOVille;
import MVC.Model.VilleModelDB;
import MVC.View.CoureurAbstractView;
import MVC.View.CoureurViewConsole;
import MVC.View.VilleAbstractView;
import MVC.View.VilleViewConsole;

import java.util.Arrays;

import static utilitaires.Utilitaire.affListe;
import static utilitaires.Utilitaire.choixListe;

public class Gestion {
    private DAOVille vm;
    private VilleController vc;
    private VilleAbstractView vv;
    private DAOCoureur cm;
    private CoureurController cc;
    private CoureurAbstractView cv;

    public void gestion() {
        vm = new VilleModelDB();
        vv = new VilleViewConsole();
        vc = new VilleController(vm, vv);
        vm.addObserver(vv);

        cm = new CoureurModelDB();
        cv = new CoureurViewConsole();
        cc = new CoureurController(cm, cv);
        cm.addObserver(cv);

        do {

            int ch = choixListe(Arrays.asList("Ville", "Coureur", "Classement", "Etape", "Course", "fin"));
            switch (ch) {
                case 1:
                    vv.menu();
                    break;
                case 2:
                    cv.menu();
                    break;
                case 3:
                    return;
                case 4:
                    return;
                case 5:
                    return;
                case 6:
                    return;
            }
        } while (true);

    }

    public static void main(String[] args) {
        Gestion gm = new Gestion();
        gm.gestion();
    }
}
