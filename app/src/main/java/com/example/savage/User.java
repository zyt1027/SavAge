package com.example.savage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.Random;
import java.util.UUID;


public class User extends Person implements Parcelable {

    private String userCode;
    private String password;
    private String citta;
    private String numeroCivico;
    private String via;
    private String postCode;
    private Date dataNascita;
    private int peso;
    private int altezza;
    private Person parente;




    public User(){
        super();
    }

    public User(String nome,String numtel,Date dataNasciata,String email,String password){
        super(nome,numtel,email);
        this.userCode= UUID.randomUUID().toString();
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


    public  User(Parcel parcel){
        this.userCode=parcel.readString();
        this.setEmail(parcel.readString());
        this.setPassword(parcel.readString());

    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserCode() {
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


    public String toString(){
        return this.getName()+"\t"+this.getDataNascita().toString()+"\t"+this.getUserCode();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.userCode);
        dest.writeString(this.getEmail());
        dest.writeString(this.getPassword());

    }
}
