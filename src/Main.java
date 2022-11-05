import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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
        Client client1 = new Client(1, "Ilyas", "+010-5826-9410");
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