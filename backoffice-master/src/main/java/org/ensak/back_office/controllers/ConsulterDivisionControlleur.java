package org.ensak.back_office.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.ensak.back_office.MainBackOffice;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsulterDivisionControlleur implements Initializable {
    @FXML
    public static Label numero;
    @FXML
    public static Label Lnom;
    @FXML
    public Label LchefDivision;


    public static void consulterDivision() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/consulterDivision.fxml"));
            MenuController.mainLayout.setCenter(loader.load());

        } catch (IOException e) {
            Logger.getLogger(ConsulterDivisionControlleur.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Lnom.setText("ok");

    }
}
