package org.example.modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Employe {
    private final SimpleStringProperty numero = new SimpleStringProperty("");
    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty prenom = new SimpleStringProperty("");
    private final SimpleStringProperty email = new SimpleStringProperty("");
    private final SimpleStringProperty telephone = new SimpleStringProperty("");
    private final Button supprimer = new Button("Supprimer");
    private final Button consulter = new Button("Consulter");


    public Employe() {
    }

    public Button getConsulter() {
        return consulter;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getNumero() {
        return numero.get();
    }

    public SimpleStringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public Button getSupprimer() {
        return supprimer;
    }
}
