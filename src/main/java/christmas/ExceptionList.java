package christmas;

public enum ExceptionList {
    DATEEXCPTION("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDEREXCEPTION("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DRINKEXCEPTION("음료만 주문할 수 없습니다."),
    ORDERCOUNTEXCEPTION("주문 음식이 20개가 넘을 경우 주문이 불가합니다.");

    private final String content;

    ExceptionList(String content) {
        this.content = "[ERROR] " + content;
    }

    public String getContent() {
        return content;
    }
}
