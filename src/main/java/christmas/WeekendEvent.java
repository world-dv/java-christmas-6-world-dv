package christmas;

public class WeekendEvent {
    public Integer weekendEvent(OrderList orderList, DateToVisit dateToVisit) {
        return applyWeekendEvent(orderList, dateToVisit);
    }

    private Integer applyWeekendEvent(OrderList orderList, DateToVisit dateToVisit) {
        if (isOrderApplyEvent(orderList) && isDateFriOrSaturday(dateToVisit)) {
            return orderList.getOrderType().get("메인") * 2023 * -1;
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
