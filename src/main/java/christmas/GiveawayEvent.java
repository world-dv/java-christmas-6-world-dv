package christmas;

public class GiveawayEvent {
    public Integer giveawayEvent(OrderList orderList) {
        return applyGiveawayEvent(orderList);
    }

    private Integer applyGiveawayEvent(OrderList orderList) {
        if (isOrderApplyGiveawayEvent(orderList)) {
            return -25000;
        }
        return 0;
    }

    private Boolean isOrderApplyGiveawayEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 120000;
    }
}
