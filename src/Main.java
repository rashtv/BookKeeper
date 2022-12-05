import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(0, "National Library", "201 Banpo-daero, Seocho-gu, Seoul");
        Client defaultClient = new Client(0, "Default", "+010-0000-0000");
        Client currentClient = defaultClient;
        library.registerClient(defaultClient);

        while(true) {
            System.out.println("What would you like to do?");
            System.out.println("-- enter '0' to exit.");
            System.out.println("-- enter '1' to register new client.");
            System.out.println("-- enter '2' to add new book.");
            System.out.println("-- enter '3' to order a book.");
            System.out.println("-- enter '4' to return a book.");
            System.out.println("-- enter '5' to get list of books in the library.");
            System.out.println("-- enter '6' to get list of clients in the library.");
            System.out.println("-- enter '9' to change user-client.");
            int k;
            try {
                k = scanner.next().charAt(0) - 48;
                switch (k) {
                    case 0 -> {
                        System.out.println("System exit successfully!");
                        return;
                    }
                    case 1 -> {
                        System.out.println("Enter your name (without spaces):");
                        String clientName = scanner.next();
                        System.out.println("Enter your phone number (optional):");
                        String phoneNumber = scanner.next();
                        Client client = new Client(library.getClientBase().size(), clientName, phoneNumber);
                        library.registerClient(client);
                        System.out.println("New client has been registered!");
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.println("Enter the name of the book:");
                        String bookName = scanner.next();
                        System.out.println("Enter author's name of the book:");
                        String authorName = scanner.next();
                        Book book = new Book(library.getNumberOfBooks(), bookName, authorName);
                        library.addBook(book);
                        System.out.println("New book has been added!");
                        System.out.println();
                    }
                    case 3 -> {
                        System.out.println("Enter the name of the book, which you'd like to order:");
                        String orderBookName = scanner.next();
                        currentClient.makeOrder(orderBookName, library);
                        System.out.println();
                    }
                    case 4 -> {
                        System.out.println("Enter the name of the book, which you'd like to return:");
                        String returnBookName = scanner.next();
                        currentClient.returnBook(returnBookName, library);
                        System.out.println();
                    }
                    case 5 -> {
                        System.out.println("Books:");
                        for (Book book : library.getBooks()) {
                            System.out.println(book.getId() + " : " + book.getName() + " : " + book.getAuthor());
                        }
                        System.out.println();
                    }
                    case 6 -> {
                        System.out.println("Clients:");
                        for (Client client : library.getClientBase()) {
                            System.out.println(client.getId() + " : " + client.getName() + " : " + client.getPhoneNumber());
                        }
                        System.out.println();
                    }
                    case 9 -> {
                        System.out.println("Enter the name of the user-client to change:");
                        String name = scanner.next();
                        boolean found = false;
                        for (Client client : library.getClientBase()) {
                            if (client.getName().equals(name)) {
                                currentClient = client;
                                System.out.println("Successfully changed!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("User name not found!");
                            System.out.println("Returning to main menu...");
                        }
                        System.out.println();
                    }

                    default -> System.out.println("Unknown command!" + k);
                }
            } catch (Exception e) {
                System.out.println("Incorrect Input!");
            }
        }
    }

    static void Test3() {
        Library library = new Library(0, "National Library", "");
        Client client = new Client(0, "Name");
        Book book = new Book(0, "BookName");

        library.addBook(book);
        if(client.checkBook("BookName", library)) {
            client.makeOrder(book.getName(), library);
        }

        client.returnBook(book.getName(), library);
    }

    static void Test2() {
        // Library Initialization
        Library library = new Library(0, "National Library", "Some Location");

        // Clients Initialization
        Client client0 = new Client(0, "", "");
        Client client1 = new Client(1, "Ilyas");
        Client client2 = new Client(2, "John");
        Client client3 = new Client(3, "Simon");

        // Books Initialization
        Book book0 = new Book(0, "");
        Book book1 = new Book(1, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets", "J.K. Rowling");
        Book book3 = new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling");
        Book book4 = new Book(4, "Harry Potter and the Goblet of Fire", "J.K. Rowling");
        Book book5 = new Book(5, "Harry Potter and the Half-Blood Prince", "J.K. Rowling");
        Book book6 = new Book(6, "Harry Potter and the Deathly Hallows", "J.K. Rowling");
        Book book7 = new Book(7, "Harry Potter and the Cursed Child", "J.K. Rowling");

        // Orders Initialization
        Order order1 = new Order(1, book1, client1);
        Order order2 = new Order(2, book2, client2);
        Order order3 = new Order(3, book3, client2);
        Order order4 = new Order(4, book4, client3);
        Order order5 = new Order(5, book5, client3);
        Order order6 = new Order(6, book6, client3);

        // Check

        library.addBook(book0);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.removeBook(book0);

        library.getOrderList().add(order1);
        library.getOrderList().add(order2);
        library.getOrderList().add(order3);
        library.getOrderList().add(order4);
        library.getOrderList().add(order5);
        library.getOrderList().add(order6);

        library.registerClient(client0);
        library.registerClient(client1);
        library.registerClient(client2);
        library.registerClient(client3);
        library.unregisterClient(client0);

        ArrayList<Book> books = library.getBooks();
        for (int i = 0; i < library.getNumberOfBooks(); i++) {
            System.out.println("ID:" + books.get(i).getId());
            System.out.println("Name:" + books.get(i).getName());
            System.out.println("Status:" + books.get(i).isAvailable());
            System.out.println();
        }

        System.out.println(client1.checkBook("How to QWE", library));
        System.out.println(client1.checkBook("Harry Potter and the Half-Blood Prince", library));

        System.out.println();

        Client borrower;

        borrower = client2.checkBorrower("How to ZXC", library);
        if (borrower != null) {
            System.out.println(borrower.getName());
        }

        borrower = client2.checkBorrower("Harry Potter and the Half-Blood Prince", library);
        if (borrower != null) {
            System.out.println(borrower.getName());
        }
    }

    static void Test1() {
        Client client0 = new Client(0, "", "");
        Book book0 = new Book(0, "", "");

        client0.setId(Integer.MAX_VALUE);
        client0.setId(0);
        System.out.println(client0.getId());
        client0.setName("Anonymous");
        client0.setName("Nameless");
        System.out.println(client0.getName());
        client0.setPhoneNumber("+010-0000-0000");
        client0.setPhoneNumber("+010-0000-0001");
        System.out.println(client0.getPhoneNumber());

        System.out.println();

        book0.setId(Integer.MAX_VALUE);
        book0.setId(0);
        System.out.println(book0.getId());
        book0.setName("Unknown");
        book0.setName("Nameless");
        System.out.println(book0.getName());
        book0.setAuthor("Unknown");
        book0.setAuthor("Anonymous");
        System.out.println(book0.getAuthor());
    }
}