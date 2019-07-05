package com.example.savage;

public class Person {


    private String name;
    private String numeroTel;
    private String email;


    public Person(){}

    public Person(String nome,String numtel,String email){
        this.setName(nome);
        this.setNumeroTel(numtel);
        this.setEmail(email);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }




}
