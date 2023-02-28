package org.casestudyRDBMS.DTO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User
{
    Scanner sc = new Scanner(System.in);
    String userName;
    String emailID;
    String password;
    String userID;
    ArrayList<Book> completedBooks = new ArrayList<>();
    ArrayList<Book> favoriteBooks = new ArrayList<>();
    ArrayList<Book> newBooks = new ArrayList<>();

    public User()
    {
        userID = UUID.randomUUID().toString();
        System.out.println("Registering new user\n");
        while(true) {
            System.out.println("Enter email: ");
            String inputEmail = sc.nextLine().trim();
            if (isValidEmail(inputEmail)) { this.emailID = inputEmail; break; }
            else { System.out.println("Invalid email address, please try again."); } }
        System.out.println("Enter username: "); this.userName = sc.nextLine();
        System.out.println("Enter password: "); this.password = sc.nextLine();
        System.out.println("Enter completed books"); insertBooks(completedBooks);
        System.out.println("Enter favorite books"); insertBooks(favoriteBooks);
        System.out.println("Enter new books"); insertBooks(newBooks);
    }

    private void insertBooks(ArrayList<Book> b)
    {
        System.out.println("1. Insert Book");
        System.out.println("2. Done inserting");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1: b.add(new Book()); break;
            case 2: return;
            default: System.out.println("Enter 1 or 2"); break;
        }
        insertBooks(b);
    }

    private boolean isValidEmail(String email)
    {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ArrayList<Book> getNewBooks() {
        return newBooks;
    }

    public ArrayList<Book> getCompletedBooks() {
        return completedBooks;
    }

    public ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }


    @Override
    public String toString() {
        return "User{" +
                "sc=" + sc +
                ", userName='" + userName + '\'' +
                ", emailID='" + emailID + '\'' +
                ", password='" + password + '\'' +
                ", userID='" + userID + '\'' +
                ", newBooks=" + newBooks +
                ", completedBooks=" + completedBooks +
                ", favorites=" + favoriteBooks +
                '}';
    }
}