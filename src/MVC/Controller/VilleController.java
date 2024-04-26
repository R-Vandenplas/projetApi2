package MVC.Controller;

import MVC.Model.DAOVille;
import MVC.View.VilleAbstractView;
import model.Ville;

import java.util.List;

public class VilleController {
    private DAOVille model;
    private VilleAbstractView view;

    public VilleController(DAOVille model, VilleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);

    }

    public List<Ville> getAll(){
        return model.findAll();
    }
    public Ville addVille(Ville v){
       return model.create(v);
    }
    public boolean removeVille(Ville v){
       return model.delete(v);
    }
    public Ville updateVille(Ville v){
        return model.update(v);
    }
    public Ville getVilleById(int id){
        return model.get(id);
    }

}
