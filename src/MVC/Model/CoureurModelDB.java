package MVC.Model;

import model.Coureur;
import model.Ville;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Coureur;

public class CoureurModelDB extends DAOCoureur {
    protected Connection dbConnect;

    public CoureurModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Coureur create(Coureur coureur) {
        String query = "CALL  APICREATECOUREUR(?,?,?,?,?,?) ";
        try (CallableStatement cs = dbConnect.prepareCall(query)) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, coureur.getMatricule());
            cs.setString(3, coureur.getNom());
            cs.setString(4, coureur.getPrenom());
            cs.setDate(5, java.sql.Date.valueOf(coureur.getDateNaiss()));
            cs.setString(6, coureur.getNationalite());
            cs.executeUpdate();
            int id = cs.getInt(1);
            coureur.setId(id);
            return coureur;


        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }

    }

    @Override
    public Coureur update(Coureur coureur) {
        String query = "update APICOUREUR set matricule = ?, nom = ?, prenom = ?, nationalite = ?, datenaiss = ? where id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, coureur.getMatricule());
            pstm.setString(2, coureur.getNom());
            pstm.setString(3, coureur.getPrenom());
            pstm.setString(4, coureur.getNationalite());
            pstm.setDate(5, java.sql.Date.valueOf(coureur.getDateNaiss()));
            pstm.setInt(6, coureur.getId());
            int n = pstm.executeUpdate();
            if (n == 0) {
                return null;
            }
            return coureur;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }

    }

    @Override
    public boolean delete(Coureur coureur) {
        String query = "delete from APICOUREUR where id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, coureur.getId());
            int n = pstm.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return false;
        }
    }

    @Override
    public Coureur get(int id) {
        String query = "select * from APICOUREUR where id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String nationalite = rs.getString(6);
                LocalDate datenaiss = rs.getDate(5).toLocalDate();
                Coureur coureur = new Coureur(id, matricule, nom, prenom, nationalite, datenaiss);
                return coureur;

            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public List<Coureur> findAll() {
        String query = "select * from APICOUREUR";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            List<Coureur> listeCoureurs = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String nationalite = rs.getString(6);
                LocalDate datenaiss = rs.getDate(5).toLocalDate();
                Coureur coureur = new Coureur(id, matricule, nom, prenom, nationalite, datenaiss);
                listeCoureurs.add(coureur);

            }
            return listeCoureurs;
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
