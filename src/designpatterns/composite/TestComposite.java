package designpatterns.composite;


import java.math.BigDecimal;
import java.time.LocalDate;
public class TestComposite {
    public static void main(String[] args){
        Course c1 = new Course(1,"Tour de France", new BigDecimal(1000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Course c2 = new Course(2,"Tour de Belgique", new BigDecimal(1000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Course c3 = new Course(3,"Tour de Luxembourg", new BigDecimal(1000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Course c4 = new Course(4,"Tour d' Italie", new BigDecimal(1000), LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 25), 3000);
        Championnat ch1 = new Championnat(1,"Championnat 1");
        Championnat ch2 = new Championnat(2,"Championnat 2");
        Championnat ch3 = new Championnat(3,"Championnat 3");
        ch1.getElts().add(c1);
        ch1.getElts().add(ch2);
        ch1.getElts().add(ch3);
        ch2.getElts().add(c2);
        ch2.getElts().add(c3);
        ch3.getElts().add(c4);

        System.out.println(ch1);



    }
}
