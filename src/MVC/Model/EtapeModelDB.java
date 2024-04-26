package MVC.Model;

import model.Course;
import model.Etape;
import model.Ville;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EtapeModelDB extends DAOEtape {
    protected Connection dbConnect;
    private DAOVille villeModelDB = new VilleModelDB();
    private DAOCourse courseModelDB = new CourseModelDB();

    public EtapeModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }


    }

    @Override
    public Etape get(int id) {
        String query = "select * from APIETAPE where id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int numero = rs.getInt(2);
                LocalDate date = rs.getDate(3).toLocalDate();
                int km = rs.getInt(4);
                String description = rs.getString(5);
                int idVilleDepart = rs.getInt(6);
                int idVilleArrivee = rs.getInt(7);
                int idCourse = rs.getInt(8);

                Ville villeDepart = villeModelDB.get(idVilleDepart);
                Ville villeArrivee = villeModelDB.get(idVilleArrivee);
                Course course = courseModelDB.get(idCourse);

                Etape etape = new Etape(id, numero, description, km, date, villeDepart, villeArrivee, course);
                return etape;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;

        }


    }

    @Override
    public Etape create(Etape etape) {
        String query = "insert into APIETAPE(numero,dateEtape,km,description,villeDepart,villeArrivee,course) values(?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, etape.getNumero());
            pstm.setDate(2, java.sql.Date.valueOf(etape.getDateEtape()));
            pstm.setInt(3, etape.getKm());
            pstm.setString(4, etape.getDescription());
            pstm.setInt(5, etape.getVilleDepart().getId());
            pstm.setInt(6, etape.getVilleArrivee().getId());
            pstm.setInt(7, etape.getCourse().getId());
            int n = pstm.executeUpdate();
            if (n == 0) {
                return null;
            }
            return etape;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public Etape update(Etape etape) {
        String query = "update APIETAPE set numero = ?, dateEtape = ?, km = ?, description = ?, villeDepart = ?, villeArrivee = ?, course = ? where id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, etape.getNumero());
            pstm.setDate(2, java.sql.Date.valueOf(etape.getDateEtape()));
            pstm.setInt(3, etape.getKm());
            pstm.setString(4, etape.getDescription());
            pstm.setInt(5, etape.getVilleDepart().getId());
            pstm.setInt(6, etape.getVilleArrivee().getId());
            pstm.setInt(7, etape.getCourse().getId());
            pstm.setInt(8, etape.getId());
            int n = pstm.executeUpdate();
            if (n == 0) {
                return null;
            }
            return etape;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public boolean delete(Etape etape) {
        String query = "delete from APIETAPE where id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, etape.getId());
            int n = pstm.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public List<Etape> findAll() {
        String query = "select * from APIETAPE";
        List<Etape> listEtape = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int numero = rs.getInt(2);
                LocalDate date = rs.getDate(3).toLocalDate();
                int km = rs.getInt(4);
                String description = rs.getString(5);
                int idVilleDepart = rs.getInt(6);
                int idVilleArrivee = rs.getInt(7);
                int idCourse = rs.getInt(8);

                Ville villeDepart = villeModelDB.get(idVilleDepart);
                Ville villeArrivee = villeModelDB.get(idVilleArrivee);
                Course course = courseModelDB.get(idCourse);

                Etape etape = new Etape(id, numero, description, km, date, villeDepart, villeArrivee, course);
                listEtape.add(etape);
            }
            return listEtape;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List getNotification() {
        return findAll();
    }
}
