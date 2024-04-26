package MVC.Model;

import model.Coureur;
import MVC.Observer.Subject;

import java.util.List;

public abstract class DAOCoureur extends Subject {

        public abstract Coureur create(Coureur coureur);
        public abstract Coureur update(Coureur coureur);
        public abstract boolean delete(Coureur coureur);
        public abstract Coureur get(int id);
        public abstract List<Coureur> findAll();

}
