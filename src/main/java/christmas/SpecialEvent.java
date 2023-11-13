package christmas;

public class SpecialEvent {
    public Integer specialEvent(OrderList orderList, DateToVisit dateToVisit) {
        return applySpecialEvent(orderList, dateToVisit);
    }

    private Integer applySpecialEvent(OrderList orderList, DateToVisit dateToVisit) {
        if (dateToVisit.getStarDate() && isOrderApplyEvent(orderList)) {
            return -1000;
        }
        return 0;
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }
}
