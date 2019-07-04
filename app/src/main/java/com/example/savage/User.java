package com.example.savage;

import java.util.Date;
import java.util.Random;

public class User extends Person {
    private static  int code=0;
    private int userCode;
    private String citta;
    private String numeroCivico;
    private String via;
    private String postCode;
    private Date giornoNascita;
    private int peso;
    private int altezza;
    private Person parente;


    public User(String nome,String numtel,String citta,String numeoCivico,String via,String postCode,Date dataNasciata,int peso,int altezza,String parentName,String parentNumtel ){
        super(nome,numtel);
        this.userCode= code+1;
        Person tmpParente=new Person(parentName,parentNumtel);
        this.setAltezza(altezza);
        this.setCitta(citta);
        this.setGiornoNascita(dataNasciata);
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

    public Date getGiornoNascita() {
        return giornoNascita;
    }

    public void setGiornoNascita(Date giornoNascita) {
        this.giornoNascita = giornoNascita;
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









}
