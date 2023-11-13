package christmas;

public class OutputView {

    public void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(DateToVisit dateToVisit) {
        System.out.println("12월 " + dateToVisit.getVisitDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리보기!\n");
    }

    public void printMenu(OrderList orderList) {
        String orders = "<주문 메뉴>\n";
        for (Order order : orderList.getOrderList()) {
            orders += order.getName() + " " + order.getCount() + "개\n";
        }
        System.out.println(orders);

        System.out.printf("<할인 전 총주문 금액>\n%,d원\n\n".formatted(orderList.getOrderPrice()));
    }

    public void printEvent(Event event) {
        System.out.println("<증정 메뉴>\n" + event.getChampagne());

        System.out.println("<혜택 내역>");
        String eventList = "";
        eventList += event.getChristmasEvent();
        eventList += event.getWeekdayEvent();
        eventList += event.getWeekendEvent();
        eventList += event.getSpecialEvent();
        eventList += event.getGiveawayEvent();

        if (eventList.equals("")) {
            eventList = "없음\n";
        }
        System.out.printf(eventList + "\n");

        System.out.printf("<총혜택 내역>\n" + event.getSumOfEventPrice());
    }
}
