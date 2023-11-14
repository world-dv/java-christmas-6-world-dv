package christmas;

public class OutputView {

    public void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(DateToVisit dateToVisit) {
        System.out.println("12월 " + dateToVisit.getVisitDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    private void printOrderMenu(OrderList orderList) {
        System.out.println("<주문 메뉴>");
        String orders = "";
        for (Order order : orderList.getOrderList()) {
            orders += order.getName() + " " + order.getCount() + "개\n";
        }
        System.out.println(orders);
    }

    private void printTotalPrice(OrderList orderList) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n".formatted(orderList.getOrderPrice()));
        System.out.println();
    }

    public void printMenu(OrderList orderList) {
        printOrderMenu(orderList);
        printTotalPrice(orderList);
    }

    private void printGiveaway(Promotion promotion) {
        System.out.println("<증정 메뉴>");
        System.out.printf(promotion.getChampagne());
        System.out.println();
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
        System.out.printf(eventList);
    }

    private void printPromotionPrice(Promotion promotion) {
        System.out.println("<총혜택 금액>");
        System.out.printf(promotion.getSumOfPromotionPrice());
        System.out.println();
    }

    private void printPromotionTotalPrice(Promotion promotion) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원".formatted(promotion.getTotalPromotionPrice()));
        System.out.println();
    }

    private void printBadge(Promotion promotion) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(promotion.getBadge());
    }

    public void printPromotion(Promotion promotion) {
        printGiveaway(promotion);
        System.out.println();
        printPromotionDetails(promotion);
        System.out.println();
        printPromotionPrice(promotion);
        System.out.println();
        printPromotionTotalPrice(promotion);
        System.out.println();
        printBadge(promotion);
    }
}
