package christmas;

public class Order {
    private final String name;
    private final Integer count;

    public Order(String name, int count) {
        validate(name, count);
        this.name = name;
        this.count = count;
    }

    private void validate(String name, int count) {
        if (!isContainMenu(name)) {
            throw new IllegalArgumentException(ExceptionList.ORDEREXCEPTION.getContent());
        }
    }

    private Boolean isContainMenu(String name) {
        Menu menu = new Menu();
        return menu.getMenu().containsKey(name);
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }
}
