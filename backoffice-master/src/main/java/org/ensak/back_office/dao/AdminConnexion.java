package org.ensak.back_office.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminConnexion {

    private static final Connection conn = ConnexionBD.connexion();
    private static final String SELECT_QUERY = "SELECT  * FROM admin WHERE login =? and password =?";
    public AdminConnexion() {}

    public boolean validation(String login, String pass) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,pass);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }




}
