package org.casestudyRDBMS.DTO;

import java.util.UUID;
import java.util.Scanner;
public class Book
{
    String bookName;
    String authorName;
    String description;
    String bookID;
    Scanner sc = new Scanner(System.in);

    public Book()
    {
        System.out.println("Enter Bookname: "); bookName = sc.nextLine();
        System.out.println("Enter Author name: "); authorName = sc.nextLine();
        System.out.println("Enter Description: "); description = sc.nextLine();
        bookID = UUID.randomUUID().toString();
        System.out.println("Book ID is : " + bookID);
    }

    public String getBookName() { return bookName; }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
}
