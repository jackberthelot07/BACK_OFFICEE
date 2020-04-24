package org.ensak.back_office.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.ensak.back_office.MainBackOffice;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccueilController implements Initializable {


    @FXML
    private Button accueil;

    @FXML private ImageView Laccueil;

    @FXML
    private Button divsion;

    @FXML private ImageView Ldivision;

    @FXML
    private Button employe;
    @FXML private ImageView Lemploye;

    @FXML
    private Button procedure;
    @FXML private ImageView Lprocedure;

    public static Stage stage;
    public static BorderPane mainLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static void Menu()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/accueil.fxml"));
            mainLayout = loader.load();

            FXMLLoader loader2  = new FXMLLoader();
            loader2.setLocation(MainBackOffice.class.getResource("/views/accueil.fxml"));
            mainLayout.setCenter(loader2.load());

            Scene scene = new Scene(mainLayout);
            stage= new Stage();
            stage.setTitle("page d'accueil");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();

        } catch (IOException e) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null,e);
        }
    }

}