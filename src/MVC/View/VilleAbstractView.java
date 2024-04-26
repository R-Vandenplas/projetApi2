package MVC.View;

import MVC.Controller.VilleController;
import MVC.Observer.Observer;
import model.Ville;

import java.util.List;

public abstract class VilleAbstractView implements Observer {
    protected VilleController controller;
    protected List<Ville> lv;

    public void setController(VilleController controller) {
        this.controller = controller;
    }

    public abstract void affMsg(String msg);

    public abstract Ville selectionner();

    public abstract void menu();

    public abstract void affList(List l);
    @Override
    public void update(List l) {
        this.lv = l;
        affList(l);
    }
}
