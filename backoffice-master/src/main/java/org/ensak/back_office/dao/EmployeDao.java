package org.ensak.back_office.dao;



import org.ensak.back_office.dao.ConnexionBD;
import org.ensak.back_office.metier.beans.Employe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeDao {
    private static Connection cnx = ConnexionBD.connexion();
    private static ResultSet rs;
    private static PreparedStatement pstm;


    public ArrayList<Employe> getAll() throws SQLException{
        ArrayList<Employe> Employes = new ArrayList<Employe>();
        Employe empl;
        try {
            pstm = cnx.prepareStatement("select * from employes;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                empl = new Employe();
                empl.setNumero(rs.getInt(1));
                empl.setNom(rs.getString(2));
                empl.setPrenom(rs.getString(3));
                empl.setPassword(rs.getString(4));


                Employes.add(empl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Employes;

    }
    public static Employe getEmployeBid(int id) throws SQLException{
        Employe empl = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement("select * from employes where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                empl = new Employe();
                empl.setNumero(resultSet.getInt(1));
                empl.setNom(resultSet.getString(2));
                empl.setPrenom(resultSet.getString(3));
                empl.setPassword(resultSet.getString(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empl;

    }

    public boolean AjouterEmpl(Employe emp) throws SQLException {
        Statement st = cnx.createStatement();
        String select="SELECT nom, prenom,pass FROM employes";
        ResultSet trouve = st.executeQuery(select);
        boolean a = true;
        while (trouve.next()) {
            System.out.println(trouve.getString("nom"));
            if (trouve.getString("nom").contains(emp.getNom()) && trouve.getString("prenom").contains(emp.getPrenom())&& trouve.getString("pass").contains(emp.getPassword())) {
                System.out.println("Okay!!");
                a = false;
                break;
            }
        }
        System.out.println("a = "+a);
        if (a) {
            final String insert = "INSERT INTO employes (nom, prenom,pass) VALUES('"
                    +emp.getNom()+"', '"+emp.getPrenom()+"', '"+"', '')";
            st.executeUpdate(insert);
            return true;
        }
        return false;
    }



    public boolean editEmploye(Employe employe) throws SQLException {
        try {
            pstm = cnx.prepareStatement("Update employes set nom=?,prenom=?,pass=?,where numero=?");
            pstm.setString(1, employe.getNom());
            pstm.setString(2, employe.getPrenom());
            pstm.setString(3, employe.getPassword());

            pstm.setInt(4,employe.getNumero());
            return (pstm.executeUpdate()>0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
