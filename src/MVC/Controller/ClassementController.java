package MVC.Controller;

import MVC.Model.DAOClassement;
import MVC.View.ClassementAbstractView;
import model.Classement;
import model.Course;

import java.util.List;

public class ClassementController {
    private DAOClassement model;
    private ClassementAbstractView view;

    public ClassementController(DAOClassement model, ClassementAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Classement> getAll(){
        return model.findAll();
    }
    public Classement addClassement(Classement c, Course course){
        return model.create(c,course);
    }
    public boolean removeClassement(Classement c){
        return model.delete(c);
    }
    public Classement updateClassement(Classement c, Course course){
        return model.update(c,course);
    }
    public Classement getClassementById(int id){
        return model.get(id);
    }

}
