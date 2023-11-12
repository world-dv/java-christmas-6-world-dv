package christmas;

public class Event {
    private final Boolean applyEvent;
    private final Boolean giveawayEvent;
    private final Integer christmasEvent;
    private final Integer specialEvent;

    public Event(OrderList orderList, DateToVisit dateToVisit) {
        this.applyEvent = isOrderApplyEvent(orderList);
        this.giveawayEvent = isOrderApplyGiveawayEvent(orderList);
        this.christmasEvent = applyChristmasEvent(dateToVisit.getVisitDate());
        this.specialEvent = applySpecialEvent(dateToVisit.getStarDate());
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }

    private Boolean isOrderApplyGiveawayEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 120000;
    }

    private String applyGiveawayEvent() {
        if (giveawayEvent && applyEvent) {
            return "샴페인 1개";
        }
        return "없음";
    }

    private Boolean isOrderApplyChristmasEvent(int visitDate) {
        return visitDate <= 25;
    }

    private Integer applyChristmasEvent(int visitDate) {
        if (isOrderApplyChristmasEvent(visitDate) && applyEvent) {
            return (1000 + 100 * (visitDate - 1)) * -1;
        }
        return 0;
    }

    private Integer applySpecialEvent(Boolean star) {
        if (star) {
            return -1000;
        }
        return 0;
    }

    public void printGiveawayEvent() {
        System.out.println("<증정 메뉴>\n" + applyGiveawayEvent());
    }
}
