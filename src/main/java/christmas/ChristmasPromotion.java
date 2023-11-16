package christmas;

public class ChristmasPromotion {
    public Integer christmasPromotion(OrderList orderList, DateToVisit dateToVisit) {
        return applyChristmasPromotion(orderList, dateToVisit);
    }

    private Integer applyChristmasPromotion(OrderList orderList, DateToVisit dateToVisit) {
        if (isOrderApplyPromotion(orderList) && isOrderApplyChristmasPromotion(dateToVisit.getVisitDate())) {
            return (1000 + 100 * (dateToVisit.getVisitDate() - 1)) * -1;
        }
        return 0;
    }

    private Boolean isOrderApplyChristmasPromotion(int visitDate) {
        return visitDate <= 25;
    }

    private Boolean isOrderApplyPromotion(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }
}
