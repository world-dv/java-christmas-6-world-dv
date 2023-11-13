package christmas;

public class WeekdayPromotion {
    public Integer weekdayPromotion(OrderList orderList, DateToVisit dateToVisit) {
        return applyWeekdayPromotion(orderList, dateToVisit);
    }

    private Integer applyWeekdayPromotion(OrderList orderList, DateToVisit dateToVisit) {
        if (isOrderApplyPromotion(orderList) && !isDateFriOrSaturday(dateToVisit)) {
            return orderList.getOrderType().get("디저트") * 2023 * -1;
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
