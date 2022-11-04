import java.util.ArrayList;

public class Library {
    private int id;
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Client> clientBase;
    private ArrayList<Order> orderList;
    private String location;

    Library(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
        this.clientBase = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.location = location;
    }

    void addBook(Book book) {
        this.books.add(book);
    }

    void removeBook(Book book) {
        this.books.remove(book);
    }

    void registerClient(Client client) {
        this.clientBase.add(client);
    }

    void unregisterClient(Client client) {
        this.clientBase.remove(client);
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

    void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    void setLocation(String location) {
        this.location = location;
    }

    String getLocation() {
        return this.location;
    }
}
