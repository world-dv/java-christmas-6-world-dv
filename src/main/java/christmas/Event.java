package christmas;

public class Event {
    private final Boolean applyEvent;
    private final Integer giveawayEvent;
    private final Integer christmasEvent;
    private final Integer specialEvent;
    private final Integer sumOfEventPrice;

    public Event(OrderList orderList, DateToVisit dateToVisit) {
        this.applyEvent = isOrderApplyEvent(orderList);
        this.giveawayEvent = applyGiveawayEvent(orderList.getOrderPrice());
        this.christmasEvent = applyChristmasEvent(dateToVisit.getVisitDate());
        this.specialEvent = applySpecialEvent(dateToVisit.getStarDate());
        this.sumOfEventPrice = sumEventPrice();
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
    }

    private Boolean isOrderApplyGiveawayEvent(int orderPrice) {
        return orderPrice >= 120000;
    }
    
    private Integer applyGiveawayEvent(int orderPrice) {
        if (isOrderApplyGiveawayEvent(orderPrice) && applyEvent) {
            return -25000;
        }
        return 0;
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
        if (star && applyEvent) {
            return -1000;
        }
        return 0;
    }

    private Integer sumEventPrice() {
        return christmasEvent + specialEvent + giveawayEvent;
    }

    private String getChampagne() {
        if (giveawayEvent == 0) {
            return "없음";
        }
        return "샴페인 1개";
    }
    
    public void printGiveawayEvent() {
        System.out.println("<증정 메뉴>\n" + getChampagne());
    }
}
