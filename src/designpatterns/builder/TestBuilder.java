package designpatterns.builder;

import java.time.LocalDate;

public class TestBuilder {
    public static void main(String[] args) {
        try {
            Coureur coureur = new Coureur.CoureurBuilder()
                    .setId(1)
                    .setMatricule("123")
                    .setNom("Doe")
                    .setPrenom("John")
                    .setNationalite("USA")
                    .setDateNaiss(LocalDate.of(1990, 1, 1))
                    .build();
            System.out.println(coureur);
        } catch (Exception e) {
            System.out.println("erreur : " + e.getMessage());
        }
        try {
            Coureur c2 = new Coureur.CoureurBuilder()
                    .setId(2)
                    .setMatricule("456")
                    .setNom("Doe")
                    .setPrenom("Jane")

                    .build();
            System.out.println(c2);
        } catch (Exception e) {
            System.out.println("erreur : "+e.getMessage());
        }
    }
}
