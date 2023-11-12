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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
