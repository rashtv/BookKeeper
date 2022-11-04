import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Library Initialization
        Library library = new Library(0, "National Library", "Some Location");

        // Clients Initialization
        Client client1 = new Client(1, "Ilyas");
        Client client2 = new Client(2, "John");
        Client client3 = new Client(3, "Simon");

        // Books Initialization
        Book book1 = new Book(1, "Harry Potter and the Sorcerer's Stone");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets");
        Book book3 = new Book(3, "Harry Potter and the Prisoner of Azkaban");
        Book book4 = new Book(4, "Harry Potter and the Goblet of Fire");
        Book book5 = new Book(5, "Harry Potter and the Half-Blood Prince");
        Book book6 = new Book(6, "Harry Potter and the Deathly Hallows");
        Book book7 = new Book(7, "Harry Potter and the Cursed Child");

        // Orders Initialization
        Order order1 = new Order(1, book1, client1);
        Order order2 = new Order(2, book2, client2);
        Order order3 = new Order(3, book3, client2);
        Order order4 = new Order(4, book4, client3);
        Order order5 = new Order(5, book5, client3);
        Order order6 = new Order(6, book6, client3);

        // Check
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        library.getOrderList().add(order1);
        library.getOrderList().add(order2);
        library.getOrderList().add(order3);
        library.getOrderList().add(order4);
        library.getOrderList().add(order5);
        library.getOrderList().add(order6);

        library.registerClient(client1);
        library.registerClient(client2);
        library.registerClient(client3);

        ArrayList<Book> books = library.getBooks();
        for (int i = 0; i < library.getNumberOfBooks(); i++) {
            System.out.println("ID:" + books.get(i).getId());
            System.out.println("Name:" + books.get(i).getName());
            System.out.println("Status:" + books.get(i).isAvailable());
            System.out.println();
        }
    }
}