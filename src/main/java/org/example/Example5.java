package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String loc = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        try {
            Connection con = DbConnection.takeConnection();

            CallableStatement ps = con.prepareCall("{call insertPerson(?,?,?)}");

            ps.setString(1,name);
            ps.setString(2,loc);
            ps.setInt(3,age);
            ps.execute();

            System.out.println("Record inserted");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}