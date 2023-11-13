package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printHello();

        DateToVisit dateToVisit = inputView.inputDate();
        OrderList orderList = inputView.inputOrder();

        outputView.printDate(dateToVisit);
        outputView.printMenu(orderList);

        Event event = new Event(orderList, dateToVisit);
        outputView.printEvent(orderList, event);
    }
}
