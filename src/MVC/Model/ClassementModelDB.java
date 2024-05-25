package MVC.Model;

import model.Classement;
import model.Coureur;
import model.Course;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class ClassementModelDB  extends DAOClassement{
    protected Connection dbConnect;
    private DAOCoureur coureurModelDB = new CoureurModelDB();

    public ClassementModelDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }


    @Override
    public Classement create(Classement classement,Course course){
        String query = "CALL APICREATECLASSEMENT(?,?,?,?,?)";
        try(CallableStatement cs = dbConnect.prepareCall(query)){
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,classement.getPlace());
            cs.setBigDecimal(3,classement.getGain());
            cs.setInt(4,course.getId());
            cs.setInt(5,classement.getCoureur().getId());
            cs.executeUpdate();
            int id = cs.getInt(1);
            classement.setId(id);
            return classement;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }

    }

    @Override
    public Classement update(Classement classement, Course course) {
        String query = "update APICLASSEMENT set place = ?, gain = ?, course = ?, coureur = ? where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classement.getPlace());
            pstm.setBigDecimal(2,classement.getGain());
            pstm.setInt(3,course.getId());
            pstm.setInt(4,classement.getCoureur().getId());
            pstm.setInt(5,classement.getId());
            int n = pstm.executeUpdate();
            if(n == 0){
                return null;
            }
            else {
                return classement;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }
    @Override
    public Classement updateByCourseIdAndCoureurId(Classement classement, int idCourse) {
        String query = "update APICLASSEMENT set place = ?, gain = ?, course = ?, coureur = ? where course = ? and coureur = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classement.getPlace());
            pstm.setBigDecimal(2,classement.getGain());
            pstm.setInt(3,idCourse);
            pstm.setInt(4,classement.getCoureur().getId());
            pstm.setInt(5,idCourse);
            pstm.setInt(6,classement.getCoureur().getId());
            int n = pstm.executeUpdate();
            if(n == 0){
                return null;
            }
            else {
                return classement;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean delete(Classement classement) {
        String query = "delete from APICLASSEMENT where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classement.getId());
            int n = pstm.executeUpdate();
            if(n == 0){
                return false;
            }
            else {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return false;
        }

    }

    @Override
    public Classement get(int id) {
        String query = "select * from APICLASSEMENT where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int place = rs.getInt(2);
                BigDecimal gain = rs.getBigDecimal(3);
                int idcoureur = rs.getInt(5);
                Coureur coureur = coureurModelDB.get(idcoureur);
                return new Classement(id,place,gain,coureur);
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
    public boolean  deleteByCourseIdAndCoureurId(int idCourse, int idCoureur) {
        String query = "DELETE from APICLASSEMENT where course = ? and coureur = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idCourse);
            pstm.setInt(2,idCoureur);
            int n = pstm.executeUpdate();
            if(n == 0){
                return false;
            }
            else {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return false;
        }
    }

    @Override
    public List<Classement> findByCourseId(int courseId) {
String query = "select * from APICLASSEMENT where course = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,courseId);
            ResultSet rs = pstm.executeQuery();
            List<Classement> listeClassement = new java.util.ArrayList<>();
            while(rs.next()){
                int id = rs.getInt(1);
                int place = rs.getInt(2);
                BigDecimal gain = rs.getBigDecimal(3);
                int idcoureur = rs.getInt(5);
                Coureur coureur = coureurModelDB.get(idcoureur);
                Classement classement = new Classement(id,place,gain,coureur);
                listeClassement.add(classement);
            }
            return listeClassement;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }

    }

    @Override
    public List<Classement> findAll() {
        String query = "select * from APICLASSEMENT";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            List<Classement> listeClassement = new java.util.ArrayList<>();
            while(rs.next()){
                int id = rs.getInt(1);
                int place = rs.getInt(2);
                BigDecimal gain = rs.getBigDecimal(3);
                int idcoureur = rs.getInt(5);
                Coureur coureur = coureurModelDB.get(idcoureur);
                Classement classement = new Classement(id,place,gain,coureur);
                listeClassement.add(classement);
            }
            return listeClassement;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }


    }


    @Override
    public List getNotification() {
        return findAll();
    }
}
