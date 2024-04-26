package MVC.View;

import MVC.Controller.CourseController;
import MVC.Controller.EtapeController;
import MVC.Observer.Observer;
import model.Course;
import model.Etape;

import java.util.List;

public abstract class EtapeAbstractView implements Observer {
    protected EtapeController controller;
    protected List<Etape> le;

    public void setController(EtapeController controller) {
        this.controller = controller;
    }

    public abstract void affMsg(String msg);

    public abstract Etape selectionner();

    public abstract void menu();

    public abstract void affList(List l);
    @Override
    public void update(List l) {
        this.le = l;
        affList(l);
    }
}
