package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        InputView inputView = new InputView();
        DateToVisit dateToVisit = inputView.inputDate();
        OrderList orderList = inputView.inputOrder();

        System.out.println("12월 " + dateToVisit.getVisitDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리보기!\n");
        orderList.printOrderList();
        orderList.printOrderPrice();

        Event event = new Event(orderList, dateToVisit);
        event.printGiveawayEvent();
    }
}
