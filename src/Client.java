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

    Order makeOrder(Book book, Library library) {
        return new Order(library.getOrderList().size() + 1, book, this);
    }

    void returnBook(Order order) {
        order.closeOrder();
        order.getBorrowedBook().setAvailable();
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
