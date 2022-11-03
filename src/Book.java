public class Book {
    private int id;
    private String name;
    private boolean isAvailable;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
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
