package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        DateToVisit dateToVisit = inputDate();
        OrderList orderList = inputOrder();

        System.out.println("12월 " + dateToVisit.getVisitDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리보기!\n");
        orderList.printOrderList();
        orderList.printOrderPrice();

        Event event = new Event(orderList, dateToVisit.getVisitDate());
        event.printGiveawayEvent();
    }

    public static DateToVisit inputDate() {
        while(true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)");
            try {
                int date = Integer.parseInt(Console.readLine());
                return new DateToVisit(date);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 식당 예상 방문 날짜는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static OrderList inputOrder() {
        while(true) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            try {
                List<String> orders = List.of(Console.readLine().split(","));
                return new OrderList(orders);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 메뉴의 개수는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
