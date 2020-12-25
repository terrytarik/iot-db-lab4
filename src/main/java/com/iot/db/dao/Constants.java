package com.iot.db.dao;

public enum Constants {
    DB_URL ("jdbc:mysql://localhost:3306/labs_db?useSSL=false"),
    DB_USERNAME ("root"),
    DB_PASSWORD ("tiric2001");

    public final String value;

    Constants(String settings) {
        this.value = settings;
    }


    @Override
    public String toString() {
        return "Constants{" +
            "value='" + value + '\'' +
            '}';
    }
}
