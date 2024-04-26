package MVC.Model;

import MVC.Observer.Subject;
import model.Ville;

import java.util.List;

public abstract class DAOVille extends Subject {
    public abstract Ville get(int id);
    public abstract List<Ville> findAll();
    public abstract Ville create(Ville ville);
    public abstract Ville update(Ville ville);
    public abstract boolean delete(Ville ville);


}
