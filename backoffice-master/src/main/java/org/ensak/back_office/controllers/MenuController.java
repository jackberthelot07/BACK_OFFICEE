package org.ensak.back_office.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.ensak.back_office.MainBackOffice;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController implements Initializable {

    @FXML
    private Button accueil;
    @FXML
    private Button division;
    @FXML
    private Button employe;
    @FXML
    private Button procedure;
    @FXML
    private ImageView Laccueil;
    @FXML
    private ImageView Ldivision;
    @FXML
    private ImageView Lemploye;
    @FXML private ImageView Lprocedure;
    public static Stage stage;
    public static BorderPane mainLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    /**
     *
     * methode qui permet d'afficher le menu de gestion de
     * l'adminbistrateur
     *
     */
    public static void Menu()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/menu.fxml"));
            mainLayout = loader.load();

            FXMLLoader loader2  = new FXMLLoader();
            loader2.setLocation(MainBackOffice.class.getResource("/views/accueil.fxml"));
            mainLayout.setCenter(loader2.load());

            Scene scene = new Scene(mainLayout);
            stage= new Stage();
            stage.setTitle("");
            stage.setScene(scene);
            //stage.setMaximized(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            MainBackOffice.MainStage.close();

        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,e);
        }

    }
    @FXML
    public void accueil(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/accueil.fxml"));
            mainLayout.setCenter(loader.load());
        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,e);
        }
        activeBtn(accueil,Laccueil);
    }

    @FXML
    public void division(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/pageDivision.fxml"));
            mainLayout.setCenter(loader.load());
        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,e);
        }
        activeBtn(division,Ldivision);
    }


    @FXML
    public void employe(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/pageEmploye.fxml"));
            mainLayout.setCenter(loader.load());
        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,e);
        }
        activeBtn(employe,Lemploye);
    }

    @FXML
    public void procedure(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/pageProcedures.fxml"));
            mainLayout.setCenter(loader.load());
        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,e);
        }
        activeBtn(procedure,Lprocedure);
    }


    private void activeBtn(Button btn , ImageView img) {

        Button[] btns = {accueil, division, employe, procedure};
        ImageView[] imgs = {Laccueil , Ldivision , Lemploye, Lprocedure};

        for ( Button b : btns) {
            b.setStyle("-fx-background-color:#073763");
        }

        for(ImageView i : imgs)
            i.setStyle("-fx-fill : #969494");
        btn.setStyle(
                "-fx-background-color: #FF9900;"
                        );

        img.setStyle("-fx-fill : #FFFFFF");
    }

    public void logOut(ActionEvent actionEvent) {
        MainBackOffice.MainStage.show();
        stage.close();
    }

}
