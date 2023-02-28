package org.casestudyRDBMS.DAO;
import java.sql.*;
import java.util.ArrayList;

import org.casestudyRDBMS.DTO.Book;
import org.casestudyRDBMS.connect.DataConnect;

public class DAO
{
    private Connection c;
    private PreparedStatement ps;

    public DAO() { c = DataConnect.getConnect(); }

    public void insertData(ArrayList<Book> b)
    {
        try {
            String sql = "INSERT INTO books (book_name, author_name, description, book_id) VALUES (?, ?, ?, ?)";
            ps = c.prepareStatement(sql);
            for (Book book : b) {
                ps.setString(1, book.getBookName());
                ps.setString(2, book.getAuthorName());
                ps.setString(3, book.getDescription());
                ps.setString(4, book.getBookID());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    public void deleteData(ArrayList<Book> b)
    {
        try {
            String sql = "DELETE FROM books WHERE book_id = ?";
            ps = c.prepareStatement(sql);
            for (Book book : b) {
                ps.setString(1, book.getBookID());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }

    public void updateData(ArrayList<Book> b)
    {
        try {
            String sql = "UPDATE books SET book_name = ?, author_name = ?, description = ? WHERE book_id = ?";
            ps = c.prepareStatement(sql);
            for (Book book : b) {
                ps.setString(1, book.getBookName());
                ps.setString(2, book.getAuthorName());
                ps.setString(3, book.getDescription());
                ps.setString(4, book.getBookID());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }

    public void retreiveData()
    {
        try {
            String sql = "SELECT * FROM books";
            ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<>();
            while (rs.next()) {
                String bookName = rs.getString("book_name");
                String authorName = rs.getString("author_name");
                String description = rs.getString("description");
                String bookID = rs.getString("book_id");
                Book book = new Book();
                book.setBookName(bookName);
                book.setAuthorName(authorName);
                book.setDescription(description);
                book.setBookID(bookID);
                books.add(book);
            }
            // do something with the array list of books
        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }

}
