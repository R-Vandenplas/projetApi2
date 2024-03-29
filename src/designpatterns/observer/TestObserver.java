package designpatterns.observer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestObserver {
    public static void main(String[] args) {
        Course c1 = new Course(1, "Tour de France", new BigDecimal(1000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Coureur coureur1 = new Coureur(1, "1", "Vandenplas", "Romain", "Belge", LocalDate.of(1999, 1, 1));
        Course c2 = new Course(2, "Tour de Belgique", new BigDecimal(1000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Coureur coureur2 = new Coureur(0, "2", "Doe", "John", "Belge", LocalDate.of(1999, 1, 1));

        c1.addObserver(coureur1);
        c1.addObserver(coureur2);
        c2.addObserver(coureur1);

        c1.setPriceMoney(new BigDecimal(2000));
        c2.setPriceMoney(new BigDecimal(3000));
    }
}
