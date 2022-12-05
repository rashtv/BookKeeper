import java.util.ArrayList;

public class Client {
    private int id;
    private String name;
    private String phoneNumber;

    Client(int id, String name) {
        this.id = id;
        this.name = name;
        this.phoneNumber = "+010-0000-0000";
    }

    Client(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    boolean checkBook(String bookName, Library library) {
        ArrayList<Book> books = library.getBooks();
        for(Book book : books) {
            if (book.getName().equals(bookName)) return true;
        }
        return false;
    }

    Client checkBorrower(String bookName, Library library) {
        if (!checkBook(bookName, library)) {
            return null;
        }
        ArrayList<Order> orders = library.getOrderList();
        for (Order order : orders) {
            if (order.getBorrowedBook().getName().equals(bookName)) {
                return order.getBorrower();
            }
        }
        return null;
    }

    void makeOrder(String bookName, Library library) {
        ArrayList<Book> books = library.getBooks();
        for(Book book : books) {
            if (book.getName().equals(bookName)) {
                if (book.isAvailable()) {
                    library.getOrderList().add(new Order(library.getOrderList().size() + 1, book, this));
                    System.out.println("The book has been received!");
                    System.out.println("The order has been created");
                    return;
                } else {
                    for (Order order : library.getOrderList()) {
                        if (order.getBorrowedBook().equals(book)) {
                            System.out.println("The book is currently unavailable.");
                            System.out.println("To get the book, please contact this person.");
                            System.out.println("Name: " + order.getBorrower().getName());
                            System.out.println("Phone Number: " + order.getBorrower().getPhoneNumber());
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("The book has not been found in the library!");
        System.out.println("The order has not been created!");
    }

    void returnBook(String bookName, Library library) {
        ArrayList<Order> orders = library.getOrderList();
        for (Order order : orders) {
            if (order.getBorrowedBook().getName().equals(bookName) && !order.isClosed()) {
                order.closeOrder();
                System.out.println("The book has been returned!");
                System.out.println("The order has been closed!");
                return;
            }
        }
        System.out.println("Unpredicted error in the process of the return of the book...");
    }

    //
    // getters & setters
    //

    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPhoneNumber() {
        return this.phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
