package com.bank.system.util;

public class DatabaseConnector {
    private static DatabaseConnector ourInstance = new DatabaseConnector();

    public static DatabaseConnector getInstance() {
        return ourInstance;
    }

    private DatabaseConnector() {
    }
}
