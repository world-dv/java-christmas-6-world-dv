package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public DateToVisit inputDate() {
        while(true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)");
            try {
                int date = Integer.parseInt(Console.readLine().strip());
                return new DateToVisit(date);
            } catch (NumberFormatException e) {
                System.out.println(ExceptionList.DATEEXCPTION.getContent());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static OrderList inputOrder() {
        while(true) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            try {
                List<String> orders = List.of(Console.readLine().strip().split(","));
                return new OrderList(orders);
            } catch (NumberFormatException e) {
                System.out.println(ExceptionList.ORDEREXCEPTION.getContent());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
