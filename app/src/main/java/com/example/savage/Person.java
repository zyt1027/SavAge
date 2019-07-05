package com.example.savage;

public class Person {



    private String name;
    private String numeroTel;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

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

    public Person(String nome,String numtel,String email){
        this.setName(nome);
        this.setNumeroTel(numtel);
        this.setEmail(email);
    }


}
