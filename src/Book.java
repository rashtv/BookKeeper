public class Book {
    private int id;
    private String name;
    private String author;
    private boolean isAvailable;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.author = "Unknown";
        this.isAvailable = true;
    }
    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isAvailable = true;
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

    void setName() {
        this.name = name;
    }

    boolean isAvailable() {
        return this.isAvailable;
    }

    void setAvailable() {
        this.isAvailable = true;
    }

    void setUnavailable() {
        this.isAvailable = false;
    }
}
