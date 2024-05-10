package MVC.View;

import MVC.Controller.ClassementController;
import MVC.Observer.Observer;
import model.Classement;


import java.util.List;

public abstract class ClassementAbstractView implements Observer {
    protected ClassementController classementController;
    protected List<Classement> lc;

    public void setController(ClassementController controller) {
        this.classementController = controller;
    }

    public abstract void affMsg(String msg);

    public abstract Classement selectionner();

    public abstract void menu();

    public abstract void affList(List l);
    @Override
    public void update(List l) {
        this.lc = l;
        affList(l);
    }
}
