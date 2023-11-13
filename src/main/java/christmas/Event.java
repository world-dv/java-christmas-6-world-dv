package christmas;

public class Event {
    private final Integer giveawayEvent;
    private final Integer christmasEvent;
    private final Integer specialEvent;
    private final Integer weekdayEvent;
    private final Integer sumOfEventPrice;

    public Event(OrderList orderList, DateToVisit dateToVisit) {
        GiveawayEvent giveaway = new GiveawayEvent();
        ChristmasEvent christmas = new ChristmasEvent();
        SpecialEvent special = new SpecialEvent();
        WeekdayEvent weekday = new WeekdayEvent();

        this.giveawayEvent = giveaway.giveawayEvent(orderList);
        this.christmasEvent = christmas.christmasEvent(orderList, dateToVisit);
        this.specialEvent = special.specialEvent(orderList, dateToVisit);
        this.weekdayEvent = weekday.weekdayEvent(orderList, dateToVisit);
        this.sumOfEventPrice = sumEventPrice();
    }

    private Integer sumEventPrice() {
        return christmasEvent + specialEvent + giveawayEvent + weekdayEvent;
    }

    private String getChampagne() {
        if (giveawayEvent == 0) {
            return "없음";
        }
        return "샴페인 1개";
    }

    public Integer getWeekdayEvent() {
        return weekdayEvent;
    }

    public void printGiveawayEvent() {
        System.out.println("<증정 메뉴>\n" + getChampagne());
    }
}
