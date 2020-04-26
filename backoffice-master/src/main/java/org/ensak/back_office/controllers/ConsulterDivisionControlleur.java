package org.ensak.back_office.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ensak.back_office.MainBackOffice;
import org.ensak.back_office.metier.beans.Division;
import org.ensak.back_office.metier.managerbeans.DivisionManager;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ensak.back_office.modele.Employe;

import javax.swing.*;


public class ConsulterDivisionControlleur implements Initializable {
    @FXML
    public  Label numero;
    @FXML
    public Label Lnom;
    @FXML
    public Label LchefDivision;
    @FXML
    public Label Lnumero;
    public static int id = 0;
    @FXML

    public TableColumn<Employe,String> prenom;
    @FXML
    public TableColumn<Employe,String> nom;
    @FXML
    public TableColumn<Employe,String> num;
    @FXML
    public TableView<Employe> employes;
    public Button supprimer;
    public Button annuler;
    public Button modifier;

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
        Division division = new Division();
        num.setCellValueFactory(new PropertyValueFactory<Employe,String>("numero"));
        nom.setCellValueFactory(new PropertyValueFactory<Employe,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Employe,String>("prenom"));
        ObservableList<Employe> dataDivisionView = FXCollections.observableArrayList();
        try {
            division = DivisionManager.getDivisionById(id);
            Lnom.setText(division.getNomDivision());
            Lnumero.setText(String.valueOf(division.getId()));
            LchefDivision.setText(division.getChefDivision().getNom());
            for(org.ensak.back_office.metier.beans.Employe emp : division.getEmployes())
            {
                dataDivisionView.add(new Employe(String.valueOf(emp.getNumero()),emp.getNom(),emp.getPrenom()));
            }
            employes.setItems(dataDivisionView);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void modifierDivision(ActionEvent actionEvent) {
    }

    @FXML
    public void supprimerDivision(ActionEvent actionEvent) throws SQLException {
        int alert = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimmer la divison :"+DivisionManager.getDivisionById(id).getNomDivision(),"Delete",JOptionPane.YES_NO_OPTION);
       if (alert == 0)
       {
           if (DivisionManager.deleteDivision(id))
           {
               JOptionPane.showMessageDialog(null,"Division Supprimée");
               try {

                   FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(MainBackOffice.class.getResource("/views/pageDivision.fxml"));
                   MenuController.mainLayout.setCenter(loader.load());

               } catch (IOException e) {
                   Logger.getLogger(ConsulterDivisionControlleur.class.getName()).log(Level.SEVERE, null, e);
               }
           }

       }


    }

    public void annuler(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainBackOffice.class.getResource("/views/pageDivision.fxml"));
            MenuController.mainLayout.setCenter(loader.load());

        } catch (IOException e) {
            Logger.getLogger(ConsulterDivisionControlleur.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
