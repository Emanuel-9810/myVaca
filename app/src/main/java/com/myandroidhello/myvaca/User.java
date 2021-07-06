package com.myandroidhello.myvaca;

public class User {
    public String email;
    public String locations;

    public User(){}

    //Login cnstrctr
    public User(String email){
        this.email = email;
    }

    //Cnstrctr for loc
    public User(String email, String locations){
        this.email = email;
        this.locations = locations;
    }
}

