package org.ensak.back_office.metier.beans;

public class Employe {
    private int numero;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    private String password;
    public Employe() {
        // TODO Auto-generated constructor stub
        super();
    }

    public Employe(int numero, String nom, String prenom, String email, String tele, String password) {
        super();
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tele = tele;
        this.password = password;
    }
    public Employe(int numero, String nom, String prenom, String email, String tele) {
        super();
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tele = tele;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
        return password;
    }

    public void setPassword(String pass) {
        password = pass;
    }
}
