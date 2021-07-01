package com.myandroidhello.myvaca;

public class Location {
    private String mKey;
    private String mName;

    public Location(String key, String name){
        mKey = key;
        mName = name;
    }

    public String getKey(){
        return mKey;
    }

    public String getName(){
        return mName;
    }
}
