package christmas;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<Order> orderList;

    public OrderList(List<String> orders) {
        List<Order> orderList = new ArrayList<>();

        for (String order : orders) {
            orderList.add(createOrder(splitOrder(order)));
        }

        this.orderList = orderList;
    }

    private List<String> splitOrder(String order) {
        return List.of(order.split("-"));
    }

    private Order createOrder(List<String> order) {
        return new Order(order.get(0), Integer.parseInt(order.get(1)));
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
