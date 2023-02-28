package org.casestudyRDBMS.DTO;
import org.casestudyRDBMS.service.Service;
import java.util.*;


public class MagicOfBooks implements Runnable
{
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, User> users = new HashMap<String, User>();


    public MagicOfBooks()
    {
        while (true)
        {
            System.out.println("\nWelcome to Magic of Books\n");
            System.out.println("1. Register new user");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
    private static void registerUser() {
        User newUser = new User();
        users.put(newUser.getEmailID(), newUser);
        System.out.println("User registered successfully");
    }

    private static void login() {
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        if (!users.containsKey(email)) {
            System.out.println("User not found. Please register first.");
            return;
        }
        User user = users.get(email);
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password. Please try again.");
            return;
        }
        System.out.println("Logged in successfully!");
        Thread userThread = new Thread(() -> {
            System.out.println("Welcome " + user.getUserName() + "! You are now working on a new thread.");
            userMenu(user);
        });
        userThread.start();
    }

    private static void userMenu(User user)
    {
        while (true)
        {
            System.out.println("\nHello " + user.getUserName() + ", please choose an option:\n");
            System.out.println("1. Add new book");
            System.out.println("2. View new books");
            System.out.println("3. View favorite books");
            System.out.println("4. View completed books");
            System.out.println("5. Logout");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addNewBook(user);
                    break;
                case 2:
                    viewBooks(user, "new");
                    break;
                case 3:
                    viewBooks(user, "favorite");
                    break;
                case 4:
                    viewBooks(user, "completed");
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void viewBooks(User user, String key) {
        ArrayList<Book> books;
        switch (key) {
            case "completed":
                books = user.getCompletedBooks();
                System.out.println("\nCOMPLETED BOOKS\n");
                break;
            case "favorite":
                books = user.getFavoriteBooks();
                System.out.println("\nFAVORITE BOOKS\n");
                break;
            case "new":
                books = user.getNewBooks();
                System.out.println("\nNEW BOOKS\n");
                break;
            default:
                System.out.println("Invalid key.");
                return;
        }
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void addNewBook(User user) {
    }

    @Override
    public void run() {

    }
}
