package com.example.savage;

public class Person {



    private String name;
    private String numeroTel;

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

    public Person(String nome,String numtel){
        this.setName(nome);
        this.setNumeroTel(numeroTel);
    }


}
