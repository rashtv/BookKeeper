public class Client {
    private int id;
    private String name;

    Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    Order makeOrder() {
//        return new Order();
//    }

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
}
