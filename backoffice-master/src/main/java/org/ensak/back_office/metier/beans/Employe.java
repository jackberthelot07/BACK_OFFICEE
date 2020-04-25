package org.ensak.back_office.metier.beans;

public class Employe {
    private int numero;
    private String Nom;
    private String Prenom;

    private String email;
    private String tele;
    private String Password;
    public Employe() {
        // TODO Auto-generated constructor stub
        super();
    }




    public Employe(int numero, String nom, String prenom, String email, String tele, String password) {
        super();
        this.numero = numero;
        Nom = nom;
        Prenom = prenom;
        this.email = email;
        this.tele = tele;
        this.Password = password;
    }




    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTele() {
        return tele;
    }
    public void setTele(String tele) {
        this.tele = tele;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }







}
