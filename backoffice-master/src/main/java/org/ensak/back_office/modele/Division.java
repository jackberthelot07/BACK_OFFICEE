package org.example.modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Division {
    private final SimpleStringProperty numero = new SimpleStringProperty("");
    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty chefDivision = new SimpleStringProperty("");
    private final Button consulter = new Button("Consulter");

    public Division() {
        consulter.setStyle("-fx-background-color:#FF9900");
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

    public String getChefDivision() {
        return chefDivision.get();
    }

    public SimpleStringProperty chefDivisionProperty() {
        return chefDivision;
    }

    public void setChefDivision(String chefDivision) {
        this.chefDivision.set(chefDivision);
    }

    public Button getConsulter() {
        return consulter;
    }
}
