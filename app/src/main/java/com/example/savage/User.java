package com.example.savage;

import java.util.Date;


public class User extends Person {
    private int userCode;



    private String password;
    private String citta;
    private String numeroCivico;
    private String via;
    private String postCode;
    private Date dataNascita;
    private int peso;
    private int altezza;
    private Person parente;


    public User(String nome,String numtel,Date dataNasciata,String email,String password){
        super(nome,numtel,email);
        this.setPassword(password);
        this.setDataNascita(dataNasciata);
    }

    public User(String nome,String numtel,String email,String password,String citta,String numeoCivico,String via,String postCode,Date dataNasciata,int peso,int altezza,String parentName,String parentNumtel,String parentEmail ){

        this(nome,numtel,dataNasciata,email,password);
        Person tmpParente=new Person(parentName,parentNumtel,parentEmail);
        this.setAltezza(altezza);
        this.setCitta(citta);
        this.setParente(tmpParente);
        this.setPeso(peso);
        this.setNumeroCivico(numeoCivico);
        this.setVia(via);
        this.setPostCode(postCode);
    }



    public int getUserCode() {
        return userCode;
    }


    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public Person getParente() {
        return parente;
    }

    public void setParente(Person parente) {
        this.parente = parente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }







}
