package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {

            Connection con = DbConnection.takeConnection();
            Statement st = con.createStatement();
            String q = "insert into person(name,location,age) values('James','Bhopal',25)";
            st.execute(q);
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}