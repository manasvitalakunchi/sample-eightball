package com.fortify.sca.plugins.maven.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Vulnerable {

    public static void main(String[] args) throws Exception {

        String userInput = "admin' OR '1'='1";   

        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password");

        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        stmt.executeQuery(query);

        String password = "SuperSecret123";

        Runtime.getRuntime().exec("cmd /c dir " + userInput);
    }
}
