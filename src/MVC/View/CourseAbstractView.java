package MVC.View;

import MVC.Controller.CourseController;
import MVC.Observer.Observer;
import model.Course;

import java.util.List;

public abstract class CourseAbstractView implements Observer {
    protected CourseController controller;
    protected List<Course> lc;

    public void setController(CourseController controller) {
        this.controller = controller;
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
