package christmas;

public class WeekdayEvent {
    public Integer weekdayEvent(OrderList orderList, DateToVisit dateToVisit) {
        return applyWeekdayEvent(orderList, dateToVisit);
    }

    private Integer applyWeekdayEvent(OrderList orderList, DateToVisit dateToVisit) {
        if (!isDateFriOrSaturday(dateToVisit) && isOrderApplyEvent(orderList)) {
            return orderList.getOrderType().get("디저트") * 2023 * -1;
        }
        return 0;
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }

    private Boolean isDateFriOrSaturday(DateToVisit dateToVisit) {
        return "금토".contains(dateToVisit.getDayOfDate());
    }
}
