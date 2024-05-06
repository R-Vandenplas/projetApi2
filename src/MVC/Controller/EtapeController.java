package MVC.Controller;

import MVC.Model.DAOEtape;
import MVC.View.EtapeAbstractView;
import model.Etape;

import java.util.List;

public class EtapeController {
    private DAOEtape model;
    private EtapeAbstractView view;

    public EtapeController(DAOEtape model, EtapeAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Etape> getAll(){
        return model.findAll();
    }
    public Etape addEtape(Etape e){
        return model.create(e);
    }
    public boolean removeEtape(Etape e){
        return model.delete(e);
    }
    public Etape updateEtape(Etape e){
        return model.update(e);
    }
    public Etape getEtapeById(int id){
        return model.get(id);
    }
}
