package MVC;

import MVC.Controller.*;
import MVC.Model.*;
import MVC.View.*;

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

    private DAOEtape em;
    private EtapeController ec;
    private EtapeAbstractView ev;

    private DAOCourse com;
    private CourseController coc;
    private CourseAbstractView cov;

    private DAOClassement clm;
    private ClassementController clc;
    private ClassementAbstractView clv;

    public void gestion() {
        clm = new ClassementModelDB();
        clv = new ClassementViewConsole();
        clc = new ClassementController(clm,clv);
        clm.addObserver(clv);

        com = new CourseModelDB();
        cov = new CourseViewConsole();
        coc = new CourseController(com, cov);

        vm = new VilleModelDB();
        vv = new VilleViewConsole();
        vc = new VilleController(vm, vv);
        vm.addObserver(vv);

        cm = new CoureurModelDB();
        cv = new CoureurViewConsole();
        cc = new CoureurController(cm, cv);
        cm.addObserver(cv);

        em = new EtapeModelDB();
        ev = new EtapeViewConsole();
        ec = new EtapeController(em, ev);
        em.addObserver(ev);
        ev.setVilleView(vv);
        ev.setCourseView(cov);


        com.addObserver(cov);
        cov.setCoureurView(cv);
        cov.setEtapeView(ev);

        cov.setClassementController(clc);
        cov.setEtapeController(ec);









        do {

            int ch = choixListe(Arrays.asList("Ville", "Coureur",  "Etape", "Course", "fin"));
            switch (ch) {
                case 1:
                    vv.menu();
                    break;
                case 2:
                    cv.menu();
                    break;
                case 3:
                    ev.menu();
                    break;
                case 4:
                    cov.menu();
                    break;
                case 5:
                    return;
            }
        } while (true);

    }

    public static void main(String[] args) {
        Gestion gm = new Gestion();
        gm.gestion();
    }
}
