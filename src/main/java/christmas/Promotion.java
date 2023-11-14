package christmas;

public class Promotion {
    private final Integer giveawayPromotion;
    private final Integer christmasPromotion;
    private final Integer specialPromotion;
    private final Integer weekdayPromotion;
    private final Integer weekendPromotion;
    private final Integer sumOfPromotionPrice;
    private final Integer totalPromotionPrice;
    private final String badge;

    public Promotion(OrderList orderList, DateToVisit dateToVisit) {
        this.giveawayPromotion = new GiveawayPromotion().giveawayPromotion(orderList);
        this.christmasPromotion = new ChristmasPromotion().christmasPromotion(orderList, dateToVisit);
        this.specialPromotion = new SpecialPromotion().specialPromotion(orderList, dateToVisit);
        this.weekdayPromotion = new WeekdayPromotion().weekdayPromotion(orderList, dateToVisit);
        this.weekendPromotion = new WeekendPromotion().weekendPromotion(orderList, dateToVisit);
        this.sumOfPromotionPrice = sumOfPromotionPrice();
        this.totalPromotionPrice = calculateTotalPromotionPrice(orderList);
        this.badge = calculateBadge();
    }

    private Integer sumOfPromotionPrice() {
        return christmasPromotion + specialPromotion + giveawayPromotion + weekdayPromotion + weekendPromotion;
    }

    private Integer sumPromotionPrice() {
        return christmasPromotion + specialPromotion + weekdayPromotion + weekendPromotion;
    }

    private Integer calculateTotalPromotionPrice(OrderList orderList) {
        return orderList.getOrderPrice() + sumPromotionPrice();
    }

    private String calculateBadge() {
        int eventPrice = sumOfPromotionPrice * -1;
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
        if (giveawayPromotion == 0) {
            return "없음\n";
        }
        return "샴페인 1개\n";
    }

    public String getChristmasPromotion() {
        if (christmasPromotion == 0) {
            return "";
        }
        return "크리스마스 디데이 할인 : %,d원\n".formatted(christmasPromotion);
    }

    public String getWeekendPromotion() {
        if (weekendPromotion == 0) {
            return "";
        }
        return "주말 할인 : %,d원\n".formatted(weekendPromotion);
    }

    public String getWeekdayPromotion() {
        if (weekdayPromotion == 0) {
            return "";
        }
        return "평일 할인 : %,d원\n".formatted(weekdayPromotion);
    }

    public String getSpecialPromotion() {
        if (specialPromotion == 0) {
            return "";
        }
        return "특별 할인 : %,d원\n".formatted(specialPromotion);
    }

    public String getGiveawayPromotion() {
        if (giveawayPromotion == 0) {
            return "";
        }
        return "증정 이벤트 : %,d원\n".formatted(giveawayPromotion);
    }

    public String getSumOfPromotionPrice() {
        return "%,d원\n".formatted(sumOfPromotionPrice);
    }

    public Integer getTotalPromotionPrice() {
        return totalPromotionPrice;
    }

    public String getBadge() {
        return badge;
    }
}
