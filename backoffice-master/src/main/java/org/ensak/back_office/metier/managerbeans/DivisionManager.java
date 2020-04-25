package org.ensak.back_office.metier.managerbeans;

import org.ensak.back_office.dao.DaoDivision;
import org.ensak.back_office.metier.beans.Division;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionManager {

    public static ArrayList<Division> getAllDivisions() throws SQLException {
        return (ArrayList<Division>) DaoDivision.getAllDivision();
    }
}
