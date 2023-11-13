package christmas;

public class GiveawayPromotion {
    public Integer giveawayPromotion(OrderList orderList) {
        return applyGiveawayPromotion(orderList);
    }

    private Integer applyGiveawayPromotion(OrderList orderList) {
        if (isOrderApplyGiveawayPromotion(orderList)) {
            return -25000;
        }
        return 0;
    }

    private Boolean isOrderApplyGiveawayPromotion(OrderList orderList) {
        return orderList.getOrderPrice() >= 120000;
    }
}
