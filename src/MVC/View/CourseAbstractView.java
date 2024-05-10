package MVC.View;

import MVC.Controller.ClassementController;
import MVC.Controller.CourseController;
import MVC.Controller.EtapeController;
import MVC.Observer.Observer;
import model.Course;

import java.util.List;

public abstract class CourseAbstractView implements Observer {
    protected CourseController courseController;
    protected List<Course> lc;

    protected CoureurAbstractView courv;
    protected EtapeAbstractView etav;

    protected ClassementController classementController;
    protected EtapeController etapeController;

    public void setController(CourseController controller) {
        this.courseController = controller;
    }

    public void setCoureurView(CoureurAbstractView courv) {
        this.courv = courv;
    }

    public void setEtapeView(EtapeAbstractView etav) {
        this.etav = etav;
    }

    public abstract void affMsg(String msg);

    public abstract Course selectionner();

    public abstract void menu();

    public abstract void affList(List l);
    @Override
    public void update(List l) {
        this.lc = l;
        affList(l);
    }

}
