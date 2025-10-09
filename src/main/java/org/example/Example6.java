package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Example6 {
    public static void main(String[] args) {
       try {
            Connection con = DbConnection.takeConnection();

            CallableStatement ps = con.prepareCall("{call getRecord(?,?)}");
            ps.setInt(1,65);
            ps.registerOutParameter(2, Types.VARCHAR);
            ps.execute();

            String name = ps.getString(2);
            System.out.println(name);

            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}