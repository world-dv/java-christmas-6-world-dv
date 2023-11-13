package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderList {
    private final List<Order> orderList;
    private final Integer orderPrice;
    private final Map<String, Integer> orderType;

    public OrderList(List<String> order) {
        List<Order> orders = createOrderList(order);
        Map<String, Integer> orderTypes = calculateOrderType(orders);
        validate(orders, orderTypes);

        this.orderList = orders;
        this.orderPrice = sumOrderPrice();
        this.orderType = orderTypes;
    }

    private void validate(List<Order> orders, Map<String, Integer> orderTypes) {
        if (isCountOver20(orders)) {
            throw new IllegalArgumentException(ExceptionList.ORDERCOUNTEXCEPTION.getContent());
        }

        if (isDuplicatedMenu(orders)) {
            throw new IllegalArgumentException(ExceptionList.ORDEREXCEPTION.getContent());
        }

        if (isOrderOnlyDrink(orderTypes, orders)) {
            throw new IllegalArgumentException(ExceptionList.DRINKEXCEPTION.getContent());
        }
    }

    private List<Order> createOrderList(List<String> orders) {
        List<Order> orderList = new ArrayList<>();
        for (String order : orders) {
            if (!isContainBarOrComma(order)) {
                throw new IllegalArgumentException(ExceptionList.ORDEREXCEPTION.getContent());
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

    private Boolean isOrderOnlyDrink(Map<String, Integer> orderTypes, List<Order> orders) {
        return orderTypes.get("음료") == numOrder(orders);
    }

    private Integer sumOrderPrice() {
        Map<String, Integer> menus = new Menu().getMenu();
        int sumPrice = 0;
        for (Order order : orderList) {
            sumPrice += menus.get(order.getName()) * order.getCount();
        }
        return sumPrice;
    }

    private Map<String, Integer> calculateOrderType(List<Order> orders) {
        Map<String, Integer> orderType = new MenuType().getMenuTypeCount();
        Map<String, String> menuType = new MenuType().getMenuType();
        for (int order = 0; order < orders.size(); order++) {
            String menu = menuType.get(orders.get(order).getName());
            orderType.put(menu, orderType.get(menu) + orders.get(order).getCount());
        }
        return orderType;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public Map<String, Integer> getOrderType() {
        return orderType;
    }
}