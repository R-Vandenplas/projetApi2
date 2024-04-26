package MVC.Model;

import MVC.Observer.Subject;
import model.Etape;

import java.util.List;

public abstract class DAOEtape extends Subject {

    public abstract Etape get(int id);
    public abstract Etape create(Etape etape);
    public abstract Etape update(Etape etape);
    public abstract boolean delete(Etape etape);
    public abstract List<Etape> findAll();




}
