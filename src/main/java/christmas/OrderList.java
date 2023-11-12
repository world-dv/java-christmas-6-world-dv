package christmas;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<Order> orderList;
    private final Integer orderNum;

    public OrderList(List<String> order) {
        List<Order> orders = createOrderList(order);
        validate(orders);

        this.orderList = orders;
        this.orderNum = numOrder(orders);
    }

    private void validate(List<Order> orders) {
        if (isCountOver20(orders)) {
            throw new IllegalArgumentException("[ERROR] 주문 음식이 20개가 넘을 경우 주문이 불가합니다.");
        }
    }

    private List<Order> createOrderList(List<String> orders) {
        List<Order> orderList = new ArrayList<>();
        for (String order : orders) {
            orderList.add(createOrder(splitOrder(order)));
        }
        return orderList;
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

    public void printOrderList() {
        String orders = "<주문 메뉴>\n";
        for (Order order : orderList) {
            orders += order.getName() + " " + order.getCount() + "개\n";
        }
        System.out.println(orders);
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
