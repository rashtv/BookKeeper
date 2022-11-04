import java.util.Date;

public class Order {
    private int id;
    private Book borrowedBook;
    private Client borrower;
    private boolean isClosed;
    private Date date;

    Order(int id, Book borrowedBook, Client borrower) {
        if (!borrowedBook.isAvailable()) {
            System.out.println("The book is currently unavailable.");
            return;
        }

        this.id = id;
        this.borrowedBook = borrowedBook;
        this.borrower = borrower;
        this.isClosed = false;
        this.date = new Date();

        this.borrowedBook.setUnavailable();
    }

    void closeOrder() {
        this.isClosed = true;
        this.borrowedBook.setAvailable();
    }

    //
    // setters & getters
    //

    void setId(int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    Book getBorrowedBook() {
        return this.borrowedBook;
    }

    void setBorrower(Client borrower) {
        this.borrower = borrower;
    }

    Client getBorrower() {
        return this.borrower;
    }

    void setClosed() {
        this.isClosed = true;
    }

    boolean isClosed() {
        return this.isClosed;
    }

    void setDate(Date date) {
        this.date = date;
    }

    Date getDate() {
        return this.date;
    }
}
