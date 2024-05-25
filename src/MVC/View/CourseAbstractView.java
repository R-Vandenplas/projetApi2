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

    protected CoureurAbstractView coureurView;
    protected EtapeAbstractView etapeView;

    protected ClassementController classementController;
    protected EtapeController etapeController;

    public void setController(CourseController controller) {
        this.courseController = controller;
    }

    public void setCoureurView(CoureurAbstractView courv) {
        this.coureurView = courv;
    }

    public void setEtapeView(EtapeAbstractView etav) {
        this.etapeView = etav;
    }

    public void setClassementController(ClassementController controller) {
        this.classementController = controller;
    }
    public void setEtapeController(EtapeController controller) {
        this.etapeController = controller;
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
