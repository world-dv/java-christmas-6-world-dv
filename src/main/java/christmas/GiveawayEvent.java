package christmas;

public class GiveawayEvent {
    public Integer giveawayEvent(boolean applyEvent, int orderPrice) {
        return applyGiveawayEvent(applyEvent, orderPrice);
    }

    private Boolean isOrderApplyGiveawayEvent(int orderPrice) {
        return orderPrice >= 120000;
    }

    private Integer applyGiveawayEvent(boolean applyEvent, int orderPrice) {
        if (isOrderApplyGiveawayEvent(orderPrice) && applyEvent) {
            return -25000;
        }
        return 0;
    }
}
