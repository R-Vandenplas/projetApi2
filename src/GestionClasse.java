

import myconnections.DBConnection;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestionClasse {

    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    private DateTimeFormatter formatDate = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.Afficher tout\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    findCourse();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    findAll();

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);

    }


    public void createCourse() {
        try {
            String query = "INSERT INTO APICOURSE(NOM, PRICEMONEY, DATEDEBUT,DATEFIN, KMTOTAL) VALUES (?, ?, ?, ?,?)";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez nom: ");
            String nom = sc.nextLine();
            pstmt.setString(1, nom);

            System.out.println("Entrez le prix de la course : ");
            int pricemoney = sc.nextInt();
            sc.nextLine();
            pstmt.setInt(2, pricemoney);

            System.out.println("Entrez date de debut (jour mois année): ");
            String dateString = sc.nextLine();
            String[] date = dateString.split(" ");
            Date dateDebut = Date.valueOf(date[2] + "-" + date[1] + "-" + date[0]);
            pstmt.setDate(3, dateDebut);

            System.out.println("Entrez date de fin (jour mois année): ");
            dateString = sc.nextLine();
            date = dateString.split(" ");
            Date dateFin = Date.valueOf(date[2] + "-" + date[1] + "-" + date[0]);
            pstmt.setDate(4, dateFin);

            System.out.println("Entrez la distance total : ");
            int kmtotal = sc.nextInt();
            sc.nextLine();
            pstmt.setInt(5, kmtotal);

            pstmt.executeUpdate();

            System.out.println("Course ajoutée avec succès");

        } catch (SQLException e) {
            System.out.println("erreur SQL " + e.getMessage());
        }
    }

    public void findCourse() {
        try {
            String query = "SELECT * FROM APICOURSE WHERE NOM = ?";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez le nom de la course: ");
            String nom = sc.nextLine();
            pstmt.setString(1, nom);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID");
                int pricemoney = rs.getInt("PRICEMONEY");
                Date dateDebut = rs.getDate("DATEDEBUT");
                Date dateFin = rs.getDate("DATEFIN");
                int kmtotal = rs.getInt("KMTOTAL");

                System.out.println("ID: " + id);
                System.out.println("Nom: " + nom);
                System.out.println("Prix de la course: " + pricemoney);
                System.out.println("Date de debut: " + dateDebut.toLocalDate().format(formatDate));
                System.out.println("Date de fin: " + dateFin.toLocalDate().format(formatDate));
                System.out.println("Distance total: " + kmtotal);
            } else {
                System.out.println("Aucune course trouvée avec le nom : " + nom);
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL " + e.getMessage());
        }
    }


    public void updateCourse() {
        try {
            String query = "UPDATE APICOURSE SET NOM = ?, PRICEMONEY = ?, DATEDEBUT = ?, DATEFIN = ?, KMTOTAL = ? WHERE ID = ?";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez l'ID de la course: ");
            int id = sc.nextInt();
            sc.nextLine();
            pstmt.setInt(6, id);

            System.out.println("Entrez le nom: ");
            String nom = sc.nextLine();
            pstmt.setString(1, nom);

            System.out.println("Entrez le prix de la course : ");
            int pricemoney = sc.nextInt();
            sc.nextLine();
            pstmt.setInt(2, pricemoney);

            System.out.println("Entrez date de debut (jour mois année): ");
            String dateString = sc.nextLine();
            String[] date = dateString.split(" ");
            Date dateDebut = Date.valueOf(date[2] + "-" + date[1] + "-" + date[0]);
            pstmt.setDate(3, dateDebut);

            System.out.println("Entrez date de fin (jour mois année): ");
            dateString = sc.nextLine();
            date = dateString.split(" ");
            Date dateFin = Date.valueOf(date[2] + "-" + date[1] + "-" + date[0]);
            pstmt.setDate(4, dateFin);

            System.out.println("Entrez la distance total : ");
            int kmtotal = sc.nextInt();
            sc.nextLine();
            pstmt.setInt(5, kmtotal);



            pstmt.executeUpdate();

            System.out.println("Course modifiée avec succès");


        } catch (SQLException e) {
            System.out.println("erreur SQL " + e.getMessage());
        }
    }

    public void deleteCourse() {
        try {
            String query = "DELETE FROM APICOURSE WHERE ID = ?";

            PreparedStatement pstmt = dbConnect.prepareStatement(query);

            System.out.println("Entrez l'ID de la course: ");
            int id = sc.nextInt();
            sc.nextLine();

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            System.out.println("Course supprimée avec succès");

        } catch (SQLException e) {
            System.out.println("erreur SQL " + e.getMessage());

        }
    }

    private void findAll() {
        String query = "SELECT * FROM APICOURSE";
        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {
            if(!rs.isBeforeFirst()){
                System.out.println("Aucune course trouvée");
            }
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                int pricemoney = rs.getInt("PRICEMONEY");
                Date dateDebut = rs.getDate("DATEDEBUT");
                Date dateFin = rs.getDate("DATEFIN");
                int kmtotal = rs.getInt("KMTOTAL");

                System.out.println("--------------------");
                System.out.println("ID: " + id);
                System.out.println("Nom: " + nom);
                System.out.println("Prix de la course: " + pricemoney);
                System.out.println("Date de debut: " + dateDebut.toLocalDate().format(formatDate));
                System.out.println("Date de fin: " + dateFin.toLocalDate().format(formatDate));
                System.out.println("Distance total: " + kmtotal);
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e.getMessage());
        }


    }


    public static void main(String[] args) {

        GestionClasse g = new GestionClasse();
        g.gestion();
    }

}

