package christmas;

public class Event {
    private final Integer giveawayEvent;
    private final Integer christmasEvent;
    private final Integer specialEvent;
    private final Integer weekdayEvent;
    private final Integer weekendEvent;
    private final Integer sumOfEventPrice;
    private final Integer sumEventPrice;
    private final String badge;

    public Event(OrderList orderList, DateToVisit dateToVisit) {
        GiveawayEvent giveaway = new GiveawayEvent();
        ChristmasEvent christmas = new ChristmasEvent();
        SpecialEvent special = new SpecialEvent();
        WeekdayEvent weekday = new WeekdayEvent();
        WeekendEvent weekend = new WeekendEvent();

        this.giveawayEvent = giveaway.giveawayEvent(orderList);
        this.christmasEvent = christmas.christmasEvent(orderList, dateToVisit);
        this.specialEvent = special.specialEvent(orderList, dateToVisit);
        this.weekdayEvent = weekday.weekdayEvent(orderList, dateToVisit);
        this.weekendEvent = weekend.weekendEvent(orderList, dateToVisit);
        this.sumOfEventPrice = sumOfEventPrice();
        this.sumEventPrice = sumEventPrice();
        this.badge = calculateBadge();
    }

    private Integer sumOfEventPrice() {
        return christmasEvent + specialEvent + giveawayEvent + weekdayEvent + weekendEvent;
    }

    private Integer sumEventPrice() {
        return christmasEvent + specialEvent + weekdayEvent + weekendEvent;
    }

    private String calculateBadge() {
        int eventPrice = sumOfEventPrice * -1;
        if (eventPrice < 5000) {
            return "없음";
        }
        if (eventPrice < 10000) {
            return "별";
        }
        if (eventPrice < 20000) {
            return "트리";
        }
        return "산타";
    }

    public String getChampagne() {
        if (giveawayEvent == 0) {
            return "없음\n";
        }
        return "샴페인 1개\n";
    }

    public String getChristmasEvent() {
        if (christmasEvent == 0) {
            return "";
        }
        return "크리스마스 디데이 할인 : %,d원\n".formatted(christmasEvent);
    }

    public String getWeekendEvent() {
        if (weekendEvent == 0) {
            return "";
        }
        return "주말 할인 : %,d원\n".formatted(weekendEvent);
    }

    public String getWeekdayEvent() {
        if (weekdayEvent == 0) {
            return "";
        }
        return "평일 할인 : %,d원\n".formatted(weekdayEvent);
    }

    public String getSpecialEvent() {
        if (specialEvent == 0) {
            return "";
        }
        return "특별 할인 : %,d원\n".formatted(specialEvent);
    }

    public String getGiveawayEvent() {
        if (giveawayEvent == 0) {
            return "";
        }
        return "증정 이벤트 : %,d원\n".formatted(giveawayEvent);
    }

    public String getSumOfEventPrice() {
        return "%,d원\n".formatted(sumOfEventPrice);
    }

    public Integer getSumEventPrice() {
        return sumEventPrice;
    }

    public String getBadge() {
        return badge;
    }
}
