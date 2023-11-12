package christmas;

public class Event {
    private final Boolean applyEvent;
    private final Boolean giveawayEvent;

    public Event(OrderList orderList) {
        this.applyEvent = isOrderApplyEvent(orderList);
        this.giveawayEvent = isOrderApplyGiveawayEvent(orderList);
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }

    private Boolean isOrderApplyGiveawayEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 120000;
    }

    private String applyGiveawayEvent() {
        if (giveawayEvent) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public void printGiveawayEvent() {
        System.out.println("<증정 메뉴>\n" + applyGiveawayEvent());
    }
}
