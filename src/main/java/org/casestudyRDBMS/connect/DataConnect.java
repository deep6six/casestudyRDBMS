package org.casestudyRDBMS.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DataConnect
{
    private static Connection con;
    private DataConnect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter DB password: ");
            String pw = sc.nextLine();
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DataConnect", "root", pw);
            System.out.println("Data connected");
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public static Connection getConnect()
    {
        DataConnect d1 = new DataConnect();
        return con;
    }

    public static void main( String[] args )
    {
        getConnect();
    }
}
