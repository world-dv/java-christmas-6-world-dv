package christmas;

public class WeekendPromotion {
    public Integer weekendPromotion(OrderList orderList, DateToVisit dateToVisit) {
        return applyWeekendPromotion(orderList, dateToVisit);
    }

    private Integer applyWeekendPromotion(OrderList orderList, DateToVisit dateToVisit) {
        if (isOrderApplyPromotion(orderList) && isDateFriOrSaturday(dateToVisit)) {
            return orderList.getOrderType().get("메인") * 2023 * -1;
        }
        return 0;
    }

    private Boolean isOrderApplyPromotion(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }

    private Boolean isDateFriOrSaturday(DateToVisit dateToVisit) {
        return "금토".contains(dateToVisit.getDayOfDate());
    }
}
