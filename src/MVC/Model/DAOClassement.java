package MVC.Model;

import MVC.Observer.Subject;
import model.Classement;
import model.Course;

import java.util.List;

public abstract class DAOClassement extends Subject {

        public abstract Classement create(Classement classement, Course course);
        public abstract Classement update(Classement classement, Course course);



        public abstract Classement updateByCourseIdAndCoureurId(Classement classement, int idCourse);

        public abstract boolean delete(Classement classement);
        public abstract Classement get(int id);
        public abstract List<Classement> findAll();

        public abstract boolean deleteByCourseIdAndCoureurId(int courseId, int coureurId);

}
