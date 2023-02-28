package org.casestudyRDBMS.service;
import java.util.*;
import org.casestudyRDBMS.DAO.DAO;
import org.casestudyRDBMS.DTO.Book;
import org.casestudyRDBMS.DTO.User;
import org.casestudyRDBMS.DTO.MagicOfBooks;

public class Service
{
    DAO uDAO;
    private Scanner sc;

    public Service()
    {
        sc = new Scanner(System.in);
        uDAO = new DAO();
    }

    public void insert()
    {
        ArrayList<Book> books = new ArrayList<Book>();

        while (true) {
            System.out.print("Enter book name (or 'done' to exit): ");
            String bookName = sc.nextLine();
            if (bookName.equals("done")) { break; }

            System.out.print("Enter author name: ");
            String authorName = sc.nextLine();

            System.out.print("Enter description: ");
            String description = sc.nextLine();

            System.out.print("Enter book ID: ");
            String bookID = sc.nextLine();

            Book book = new Book();
            book.setBookName(bookName);
            book.setAuthorName(authorName);
            book.setDescription(description);
            book.setBookID(bookID);

            books.add(book);
        }

        uDAO.insertData(books);
    }
    public void delete()
    {
        System.out.println("Enter the book ID you want to delete:");
        String bookID = sc.nextLine();
        ArrayList<Book> booksToDelete = new ArrayList<>();
        Book book = new Book();
        book.setBookID(bookID);
        booksToDelete.add(book);
        uDAO.deleteData(booksToDelete);
        System.out.println("Book deleted successfully!");
    }

    public void update()
    {
        System.out.println("Enter the book ID you want to update:");
        String bookID = sc.nextLine();
        ArrayList<Book> booksToUpdate = new ArrayList<>();
        Book book = new Book();
        book.setBookID(bookID);
        System.out.println("Enter the new book name:");
        book.setBookName(sc.nextLine());
        System.out.println("Enter the new author name:");
        book.setAuthorName(sc.nextLine());
        System.out.println("Enter the new description:");
        book.setDescription(sc.nextLine());
        booksToUpdate.add(book);
        uDAO.updateData(booksToUpdate);
        System.out.println("Book updated successfully!");
    }

    public void retrieve() {
        uDAO.retreiveData();
    }
}
