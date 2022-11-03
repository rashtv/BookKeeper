import java.util.ArrayList;

public class Library {
    int id;
    String name;
    ArrayList<Book> books;

    Library(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<Book>();
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


}
