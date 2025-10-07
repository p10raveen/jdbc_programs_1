package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Example2 {
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
            Statement st = con.createStatement();
            String q = "insert into person(name,location,age) values('"+name+"','"+loc+"',"+age+")";
            st.execute(q);
            System.out.println("Record inserted");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}