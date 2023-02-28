package org.casestudyRDBMS;
import org.casestudyRDBMS.DTO.MagicOfBooks;
import org.casestudyRDBMS.service.Service;
import java.util.*;

public class App
{
    private Service serviceobj;
    private Scanner sc;
    public App()
    {
        sc=new Scanner(System.in);
        serviceobj=new Service();
        MagicOfBooks lib = new MagicOfBooks();
    }


    public void menu()
    {
    }

    public static void main( String[] args )
    {
        App apobj=new App();
        apobj.menu();
    }
}
