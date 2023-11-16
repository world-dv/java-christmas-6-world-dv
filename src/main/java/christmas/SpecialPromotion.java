package christmas;

public class SpecialPromotion {
    public Integer specialPromotion(OrderList orderList, DateToVisit dateToVisit) {
        return applySpecialPromotion(orderList, dateToVisit);
    }

    private Integer applySpecialPromotion(OrderList orderList, DateToVisit dateToVisit) {
        if (isOrderApplyPromotion(orderList) && dateToVisit.getStarDate()) {
            return -1000;
        }
        return 0;
    }

    private Boolean isOrderApplyPromotion(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }
}
