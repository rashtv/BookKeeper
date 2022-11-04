import java.util.ArrayList;

public class Library {
    private int id;
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Client> clientBase;

    Library(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
        this.clientBase = new ArrayList<>();
    }

    void addBook(Book book) {
        this.books.add(book);
    }

    void removeBook(Book book) {
        this.books.remove(book);
    }

    int getNumberOfBooks() {
        return this.books.size();
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

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    ArrayList<Book> getBooks() {
        return this.books;
    }

    void setClientBase(ArrayList<Client> clientBase) {
        this.clientBase = clientBase;
    }

    ArrayList<Client> getClientBase() {
        return this.clientBase;
    }
}
