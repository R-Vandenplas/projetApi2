package MVC.Model;

import model.*;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseModelDB extends DAOCourse{
    protected Connection dbConnect;
    private DAOCoureur coureurModelDB = new CoureurModelDB();

    public CourseModelDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Course create(Course course) {
        String query ="CALL APICREATECOURSE(?,?,?,?,?,?)" ;
        try (CallableStatement cs = dbConnect.prepareCall(query)) {
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,course.getNom());
            cs.setBigDecimal(3,course.getPriceMoney());
            cs.setDate(4,java.sql.Date.valueOf(course.getDateDebut()));
            cs.setDate(5,java.sql.Date.valueOf(course.getDateFin()));
            cs.setInt(6,course.getKmTotal());
            cs.executeUpdate();
            course.setId(cs.getInt(1));
            return course;
            }
        catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }

    }

    @Override
    public Course update(Course course) {
        String query = "update APICOURSE set nom = ?, priceMoney = ?, dateDebut = ?, dateFin = ?, kmTotal = ? where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,course.getNom());
            pstm.setBigDecimal(2,course.getPriceMoney());
            pstm.setDate(3,java.sql.Date.valueOf(course.getDateDebut()));
            pstm.setDate(4,java.sql.Date.valueOf(course.getDateFin()));
            pstm.setInt(5,course.getKmTotal());
            pstm.setInt(6,course.getId());
            int n = pstm.executeUpdate();
            if(n == 0){
                return null;
            }
            else {
                return course;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean delete(Course course) {
        String query = "delete from APICOURSE where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,course.getId());
            int n = pstm.executeUpdate();
            return n>0;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);
            return false;
        }

    }

    @Override
    public Course get(int id) {
        String query = "select * from APICOURSE where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String nom = rs.getString(2);
                BigDecimal priceMoney = rs.getBigDecimal(3);
                LocalDate dateDebut = rs.getDate(4).toLocalDate();
                LocalDate dateFin = rs.getDate(5).toLocalDate();
                int kmTotal = rs.getInt(6);
                Course course = new Course(id,nom,priceMoney,dateDebut,dateFin,kmTotal);
                return  course;

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List<Course> findAll() {
        String query = "select * from APICOURSE";
        List<Course> listeCourse = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                BigDecimal priceMoney = rs.getBigDecimal(3);
                LocalDate dateDebut = rs.getDate(4).toLocalDate();
                LocalDate dateFin = rs.getDate(5).toLocalDate();
                int kmTotal = rs.getInt(6);
                Course course = new Course(id,nom,priceMoney,dateDebut,dateFin,kmTotal);
                listeCourse.add(course);
            }
            return listeCourse;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }
    @Override
    public List<Etape> getEtapes(Course course) {
        String query = "select * from APIETAPE where idCourse = ?";
        List<Etape> listEtape = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int numero = rs.getInt(2);
                LocalDate date = rs.getDate(3).toLocalDate();
                int km = rs.getInt(4);
                String description = rs.getString(5);
                int idVilleDepart = rs.getInt(6);
                int idVilleArrivee = rs.getInt(7);

                VilleModelDB villeModelDB = new VilleModelDB();
                Ville villeDepart = villeModelDB.get(idVilleDepart);
                Ville villeArrivee = villeModelDB.get(idVilleArrivee);

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
    public List<Classement> getClassements(Course course) {
        String query = "select * from APICLASSEMENT where idCourse = ?";
        List<Classement> listClassement = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int place = rs.getInt(2);
                BigDecimal gain = rs.getBigDecimal(3);
                int idCoureur = rs.getInt(4);
                Coureur coureur = coureurModelDB.get(idCoureur);

                Classement classement = new Classement(id, place, gain, coureur);
                listClassement.add(classement);
            }
            return listClassement;
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
