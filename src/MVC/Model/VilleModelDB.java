package MVC.Model;

import model.Ville;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = "insert into APIVILLE(nom, lattitude, longitude, pays) values(?,?,?,?)";
        String query2 = "select id from APIVILLE where lattitude = ? and longitude = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query);
            PreparedStatement pstm2 = dbConnect.prepareStatement(query2);) {
            pstm.setString(1,ville.getNom());
            pstm.setDouble(2,ville.getLatitude());
            pstm.setDouble(3,ville.getLongitude());
            pstm.setString(4,ville.getPays());
            int n = pstm.executeUpdate();
            if(n == 1){
                pstm2.setDouble(1,ville.getLatitude());
                pstm2.setDouble(2,ville.getLongitude());
                ResultSet rs = pstm2.executeQuery();
                if(rs.next()){
                    ville.setId(rs.getInt(1));
                    notifyObservers();
                    return ville;
                }
                else {
                    System.err.println("record introuvable");
                    return null;
                }
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
