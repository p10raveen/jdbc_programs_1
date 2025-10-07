package org.example.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection takeConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String path="jdbc:mysql://localhost:3306/db";
            String user="root";
            String pass="bhopal";
            con = DriverManager.getConnection(path,user,pass);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}
