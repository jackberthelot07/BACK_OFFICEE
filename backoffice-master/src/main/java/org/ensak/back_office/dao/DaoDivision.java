package org.ensak.back_office.dao;

import org.ensak.back_office.metier.beans.Division;
import org.ensak.back_office.metier.beans.Employe;
import org.ensak.back_office.metier.beans.EmployeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDivision implements InterfaceDaoDivision {

    private static final Connection conn = ConnexionBD.connexion();
    private static String TABLE_NAME = "division";
    private static String TB_EMPLOYES_NAME = "employes";
    private Division division;
    private static String query_employes = "SELECT * FROM" + TB_EMPLOYES_NAME + "WHERE chef_division=?";

    @Override
    public Division getDivisionById(int id) throws SQLException {

        ArrayList<Employe> employes = new ArrayList<Employe>();
        String query = "SELECT * FROM" + TABLE_NAME + "WHERE id =?";
        PreparedStatement preparedStatement = DaoDivision.conn.prepareStatement(query);
        PreparedStatement preparedStatement1 = conn.prepareStatement(query_employes);
        preparedStatement.setInt(1, id);
        preparedStatement1.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSet resultSetemployes = preparedStatement1.executeQuery();
        division = new Division();
        if (resultSet.next()) {
            division.setId(resultSet.getInt(1));
            division.setNomDivision(resultSet.getString(2));
            division.setChefDivision(EmployeDao.getEmploye(resultSet.getInt(3)));
        }
        while (resultSetemployes.next()) {
            employes.add(EmployeDao.getEmploye(id));
        }
        division.setEmployes(employes);

        return division;
    }

    @Override
    public boolean addDivision(final Division division) throws SQLException {
        String query = "INSERT INTO" +TABLE_NAME+"(nom,chef_division) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1,division.getNomDivision());
        preparedStatement.setInt(2,division.getChefDivision().getNumero());

        return preparedStatement.execute();
    }

    @Override
    public final boolean updateDivision(final Division division) throws SQLException {

        String query = "INSERT INTO" +TABLE_NAME+"(nom,chef_division) VALUES(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1,division.getNomDivision());
        preparedStatement.setInt(2,division.getChefDivision().getNumero());

        return preparedStatement.execute();
    }

    @Override
    public final boolean deleteDivision(final Division division) throws SQLException {

        String query = "DELETE FROM"+TABLE_NAME+"WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            final int id = division.getId();
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return preparedStatement.execute();
        }


    }


    public static List<Division> getAllDivision() throws SQLException {
        PreparedStatement preparedStatement=null;
        List<Division> divisions = new ArrayList<>();
        ArrayList<Employe> employes = new ArrayList<Employe>();
        String query  = "SELECT * FROM"+TABLE_NAME;
        try {
            preparedStatement = conn.prepareStatement("select * from division");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id =resultSet.getInt(1);
               PreparedStatement preparedStatement1 =conn.prepareStatement("select * from employes where id=?");
                preparedStatement1.setInt(1,id);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next())
                {
                    employes.add(EmployeDao.getEmploye(id));
                }


                Division division = new Division(id,resultSet.getString(2),EmployeDao.getEmploye(resultSet.getInt(3)),employes);

                divisions.add(division);
            }

            return divisions;
        } finally {
            if (preparedStatement != null) preparedStatement.close();
        }

    }

    @Override
    public boolean addEmployeDivision(Division division, Employe employe) throws SQLException {
        String query = "INSERT INTO employe (id_division) VALUES (?) WHERE id =?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1,division.getId());
        preparedStatement.setInt(2,employe.getNumero());
        return preparedStatement.execute();
    }


}
