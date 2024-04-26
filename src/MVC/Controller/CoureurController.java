package MVC.Controller;

import MVC.Model.DAOCoureur;
import MVC.View.CoureurAbstractView;
import model.Coureur;
import model.Ville;

import java.util.List;

public class CoureurController {
    private DAOCoureur model;
    private CoureurAbstractView view;

    public CoureurController(DAOCoureur model, CoureurAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Coureur> getAll(){
        return model.findAll();
    }
    public Coureur addCoureur(Coureur c){
        return model.create(c);
    }
    public boolean removeCoureur(Coureur c){
        return model.delete(c);
    }
    public Coureur updateCoureur(Coureur c){
        return model.update(c);
    }
    public Coureur getCoureurById(int id){
        return model.get(id);
    }

}
