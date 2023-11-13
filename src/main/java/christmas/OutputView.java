package christmas;

public class OutputView {

    public void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(DateToVisit dateToVisit) {
        System.out.println("12월 " + dateToVisit.getVisitDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리보기!\n");
    }

    private void printOrderMenu(OrderList orderList) {
        String orders = "<주문 메뉴>\n";
        for (Order order : orderList.getOrderList()) {
            orders += order.getName() + " " + order.getCount() + "개\n";
        }
        System.out.println(orders);
    }

    private void printTotalPrice(OrderList orderList) {
        System.out.printf("<할인 전 총주문 금액>\n%,d원\n\n".formatted(orderList.getOrderPrice()));
    }

    public void printMenu(OrderList orderList) {
        printOrderMenu(orderList);
        printTotalPrice(orderList);
    }

    private void printGiveaway(Promotion promotion) {
        System.out.println("<증정 메뉴>\n" + promotion.getChampagne());
    }

    private void printPromotionDetails(Promotion promotion) {
        System.out.println("<혜택 내역>");
        String eventList = "";
        eventList += promotion.getChristmasPromotion();
        eventList += promotion.getWeekdayPromotion();
        eventList += promotion.getWeekendPromotion();
        eventList += promotion.getSpecialPromotion();
        eventList += promotion.getGiveawayPromotion();

        if (eventList.equals("")) {
            eventList = "없음\n";
        }
        System.out.printf(eventList + "\n");
    }

    public void printPromotion(OrderList orderList, Promotion promotion) {
        printGiveaway(promotion);
        printPromotionDetails(promotion);

        System.out.printf("<총혜택 금액>\n" + promotion.getSumOfPromotionPrice() + "\n");

        System.out.printf("<할인 후 예상 결제 금액>\n%,d원\n\n".formatted(orderList.getOrderPrice() + promotion.getSumPromotionPrice()));

        System.out.println("<12월 이벤트 배지>\n" + promotion.getBadge());
    }
}
