public class Main {
    public static void main(String[] args) {
        Client client = new Client(0, "Ilyas");
        Book book = new Book(0, "Harry Potter and the Philosopher's Stone");
        Order order = new Order(0, book, client);
        System.out.println(order.getId());
        System.out.println(order.getBorrowedBook().getName());
        System.out.println(order.getBorrower().getName());
    }
}