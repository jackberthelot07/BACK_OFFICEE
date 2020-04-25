package org.ensak.back_office.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.ensak.back_office.MainBackOffice;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsulterDivisionControlleur {
    public Label numero;
    @FXML
    public static Label Lnumero;
    @FXML
    public static Label Lnom;
    @FXML
    public static Label LchefDivision;


    public static void consulterDivision(ActionEvent event) {
        LchefDivision.setText("");
      //Lnom.setText(division.getNomDivision());
     //LchefDivision.setText(division.getChefDivision().getNom());
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/consulterDivision.fxml"));
            MenuController.mainLayout.setCenter(loader.load());

        } catch (IOException e) {
            Logger.getLogger(ConsulterDivisionControlleur.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
