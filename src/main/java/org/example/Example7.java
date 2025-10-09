package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Example7 {
    public static void main(String[] args) {
       try {
            Connection con = DbConnection.takeConnection();

            CallableStatement ps = con.prepareCall("{call getAdditionalAge(?)}");
            ps.setInt(1,65);

            ps.registerOutParameter(1, Types.INTEGER);
            ps.execute();

            int age = ps.getInt(1);
            System.out.println("Updated Age: "+age);

            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}