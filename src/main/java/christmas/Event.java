package christmas;

public class Event {
    private final Boolean applyEvent;
    private final Integer giveawayEvent;
    private final Integer christmasEvent;
    private final Integer specialEvent;
    private final Integer sumOfEventPrice;

    public Event(OrderList orderList, DateToVisit dateToVisit) {
        GiveawayEvent giveaway = new GiveawayEvent();
        ChristmasEvent christmas = new ChristmasEvent();
        SpecialEvent special = new SpecialEvent();

        this.applyEvent = isOrderApplyEvent(orderList);
        this.giveawayEvent = giveaway.giveawayEvent(applyEvent, orderList.getOrderPrice());
        this.christmasEvent = christmas.applyChristmasEvent(applyEvent, dateToVisit.getVisitDate());
        this.specialEvent = special.applySpecialEvent(applyEvent, dateToVisit.getStarDate());
        this.sumOfEventPrice = sumEventPrice();
    }

    private Boolean isOrderApplyEvent(OrderList orderList) {
        return orderList.getOrderPrice() >= 10000;
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
