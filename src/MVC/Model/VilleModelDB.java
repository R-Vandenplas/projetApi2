package MVC.Model;

import model.Ville;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VilleModelDB extends DAOVille {
    protected Connection dbConnect;

    public VilleModelDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Ville get(int id) {
        String query = "select * from APIVILLE where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String nom = rs.getString(2);
                double lattitude = rs.getDouble(3);
                double longitude = rs.getDouble(4);
                String pays = rs.getString(5) ;
                Ville ville = new Ville(id,nom,lattitude,longitude,pays);
                return  ville;

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
    public List<Ville> findAll() {
        String query = "select * from APIVILLE";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            List<Ville> listeVilles = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                double lattitude = rs.getDouble(3);
                double longitude = rs.getDouble(4);
                String pays = rs.getString(5) ;
                Ville ville = new Ville(id,nom,lattitude,longitude,pays);
                listeVilles.add(ville);
            }
            return listeVilles;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public Ville create(Ville ville) {
        String query = "CALL  APICREATEVILLE(?,?,?,?,?) ";
        try (CallableStatement cs = dbConnect.prepareCall(query)) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, ville.getNom());
            cs.setDouble(3, ville.getLatitude());
            cs.setDouble(4, ville.getLongitude());
            cs.setString(5, ville.getPays());
            cs.executeUpdate();
            int id = cs.getInt(1);
            ville.setId(id);
            return ville;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }

    }

    @Override
    public Ville update(Ville ville) {
        String query = "update APIVILLE set nom = ?, lattitude = ?, longitude = ?, pays = ? where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,ville.getNom());
            pstm.setDouble(2,ville.getLatitude());
            pstm.setDouble(3,ville.getLongitude());
            pstm.setString(4,ville.getPays());
            pstm.setInt(5,ville.getId());
            int n = pstm.executeUpdate();
            if(n == 0){
                return null;
            }
            else {
                return ville;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }


    }

    @Override
    public boolean delete(Ville ville) {
        String query = "delete from APIVILLE where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,ville.getId());
            int n = pstm.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return false;
        }
    }

    @Override
    public List getNotification() {
       return findAll();
    }
}
