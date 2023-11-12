package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderList {
    private final List<Order> orderList;
    private final Integer orderPrice;

    public OrderList(List<String> order) {
        List<Order> orders = createOrderList(order);
        validate(orders);

        this.orderList = orders;
        this.orderPrice = sumOrderPrice();
    }

    private void validate(List<Order> orders) {
        if (isCountOver20(orders)) {
            throw new IllegalArgumentException("[ERROR] 주문 음식이 20개가 넘을 경우 주문이 불가합니다.");
        }

        if (isDuplicatedMenu(orders)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private List<Order> createOrderList(List<String> orders) {
        List<Order> orderList = new ArrayList<>();
        for (String order : orders) {
            if (!isContainBarOrComma(order)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            orderList.add(createOrder(splitOrder(order)));
        }
        return orderList;
    }

    private Boolean isContainBarOrComma(String order) {
        return order.contains("-") || order.contains(",");
    }

    private List<String> splitOrder(String order) {
        return List.of(order.split("-"));
    }

    private Order createOrder(List<String> order) {
        return new Order(order.get(0), Integer.parseInt(order.get(1)));
    }

    private Integer numOrder(List<Order> orders) {
        int numCount = 0;
        for (Order order : orders) {
            numCount += order.getCount();
        }
        return numCount;
    }

    private Boolean isCountOver20(List<Order> orders) {
        return numOrder(orders) > 20;
    }

    private Boolean isDuplicatedMenu(List<Order> orders) {
        List<String> menu = new ArrayList<>();
        for (Order order : orders) {
            String name = order.getName();
            if (!menu.contains(name)) {
                menu.add(name);
            }
        }
        return menu.size() != orders.size();
    }

    private Integer sumOrderPrice() {
        Menu menu = new Menu();
        Map<String, Integer> menus = menu.getMenu();
        int sumPrice = 0;
        for (Order order : orderList) {
            sumPrice += menus.get(order.getName()) * order.getCount();
        }
        return sumPrice;
    }

    public void printOrderList() {
        String orders = "<주문 메뉴>\n";
        for (Order order : orderList) {
            orders += order.getName() + " " + order.getCount() + "개\n";
        }
        System.out.println(orders);
    }

    public void printOrderPrice() {
        System.out.printf("<할인 전 총주문 금액>\n%,d원\n".formatted(orderPrice));
    }
}
