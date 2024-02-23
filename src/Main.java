import java.math.BigDecimal;
import java.util.Scanner;
import java.time.LocalDate;
import modele.*;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("Tour de France", new BigDecimal(100000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Coureur coureur1 = new Coureur(1,"1", "Vandenplas", "Romain", "Belge", LocalDate.of(1999, 1, 1));
        Coureur coureur2 = new Coureur(0,"2", "Vandenplas", "Romain", "Belge", LocalDate.of(1999, 1, 1));
        course.addCoureur(coureur1);
        course.addCoureur(coureur2);
        for(Classement c : course.getClassement()) {
            System.out.println(c.getCoureur().getMatricule() +" "+ c.getGain()+" "+ c.getPlace());
        }

        course.resultat(coureur1, 1, new BigDecimal(1000));
        course.resultat(coureur2, 2, new BigDecimal(500));
        for(Classement c : course.getClassement()) {
            System.out.println(c.getCoureur().getMatricule() +" "+ c.getGain()+" "+ c.getPlace());
        }
        course.modif(coureur2,1, new BigDecimal(2000));
        course.modif(coureur1,2, new BigDecimal(1500));
        
        for(Classement c : course.getClassement()) {
            System.out.println(c.getCoureur().getMatricule() +" "+ c.getGain()+" "+ c.getPlace());
        }
    }
}