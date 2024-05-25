package MVC.View;

import MVC.Controller.CourseController;
import MVC.Controller.EtapeController;
import MVC.Observer.Observer;
import model.Course;
import model.Etape;

import java.util.List;

public abstract class EtapeAbstractView implements Observer {
    protected EtapeController etapeController;
    protected List<Etape> le;
    protected VilleAbstractView villeView;
    protected CourseAbstractView courseView;

    public void setController(EtapeController controller) {
        this.etapeController = controller;
    }

    public void setVilleView (VilleAbstractView view){
        this.villeView = view;
    }
    public void setCourseView(CourseAbstractView view){
        this.courseView = view;
    }

    public abstract void affMsg(String msg);

    public abstract Etape selectionner();

    public abstract void menu();

    public abstract void ajouter();

    public abstract void affList(List l);
    @Override
    public void update(List l) {
        this.le = l;
        affList(l);
    }
}
