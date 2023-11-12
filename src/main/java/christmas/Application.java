package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        DateToVisit dateToVisit = inputDate();
        OrderList orderList = inputOrder();
        orderList.printOrderList();
    }

    public static DateToVisit inputDate() {
        while(true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주새요!)");
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
                OrderList orderList = new OrderList(orders);
                return orderList;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 메뉴의 개수는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
