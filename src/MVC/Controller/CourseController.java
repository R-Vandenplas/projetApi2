package MVC.Controller;

import MVC.Model.DAOCourse;
import MVC.View.CourseAbstractView;
import model.Course;


import java.util.List;

public class CourseController {
    private DAOCourse model;
    private CourseAbstractView view;

    public CourseController(DAOCourse model, CourseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Course> getAll(){
        return model.findAll();
    }
    public Course addCourse(Course c){
        return model.create(c);
    }
    public boolean removeCourse(Course c){
        return model.delete(c);
    }
    public Course updateCourse(Course c){
        return model.update(c);
    }
    public Course getCourseById(int id){
        return model.get(id);
    }

}
