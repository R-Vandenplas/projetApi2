package MVC.Model;

import MVC.Observer.Subject;
import model.Classement;
import model.Course;
import model.Etape;

import java.util.List;

public abstract class DAOCourse extends Subject {

    public abstract Course createCourse(Course course);
    public abstract Course updateCourse(Course course);
    public abstract boolean deleteCourse(Course course);
    public abstract Course get(int id);
    public abstract List<Course> findAll();

    public abstract List<Etape> getEtapes(Course course);
    public abstract List<Classement> getClassements(Course course);

}
