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
            System.out.println("-- enter '7' to get information about library.");
            System.out.println("-- enter '8' to get information about current user-client.");
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
                    case 7 -> {
                        System.out.println("Library:");
                        System.out.println("Name: " + library.getName());
                        System.out.println("Location: " + library.getLocation());
                        System.out.println();
                    }
                    case 8 -> {
                        System.out.println("Current user information:");
                        currentClient.printInfo();
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

                    default -> System.out.println("Unknown command!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect Input!");
            }
        }
    }
}