package christmas;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printHello();

        DateToVisit dateToVisit = inputView.inputDate();
        OrderList orderList = inputView.inputOrder();

        outputView.printDate(dateToVisit);
        outputView.printMenu(orderList);

        Promotion event = new Promotion(orderList, dateToVisit);
        outputView.printPromotion(orderList, event);
    }
}
