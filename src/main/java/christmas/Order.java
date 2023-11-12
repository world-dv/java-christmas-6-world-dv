package christmas;

public class Order {
    private final String name;
    private final Integer count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
    }

    private void validate(String name, int count) {

    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }
}
