package christmas;

public class ChristmasEvent {
    public Integer christmasEvent(OrderList orderList, DateToVisit dateToVisit) {
        return applyChristmasEvent(orderList, dateToVisit);
    }

    private Integer applyChristmasEvent(OrderList orderList, DateToVisit dateToVisit) {
        if (isOrderApplyChristmasEvent(dateToVisit.getVisitDate()) && isOrderApplyEvent(orderList)) {
            return (1000 + 100 * (dateToVisit.getVisitDate() - 1)) * -1;
        }
        return 0;
    }

    private Boolean isOrderApplyChristmasEvent(int visitDate) {
        return visitDate <= 25;
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }
}
