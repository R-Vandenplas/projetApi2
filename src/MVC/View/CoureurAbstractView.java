package MVC.View;

import MVC.Controller.CoureurController;
import MVC.Observer.Observer;
import model.Coureur;

import java.util.List;

public abstract class CoureurAbstractView implements Observer {

    protected CoureurController coureurController;
    protected List<Coureur> lc;

    public void  setController(CoureurController clientController){
        this.coureurController=clientController;
    }

    public abstract void affMsg(String msg);

    public abstract Coureur selectionner();

    public abstract void menu();

    public abstract void affList(List l);
    @Override
    public void update(List l) {
        this.lc = l;
        affList(l);
    }
}
