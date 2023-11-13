package christmas;

public class ChristmasEvent {
    public Integer applyChristmasEvent(Boolean applyEvent, int visitDate) {
        if (isOrderApplyChristmasEvent(visitDate) && applyEvent) {
            return (1000 + 100 * (visitDate - 1)) * -1;
        }
        return 0;
    }

    private Boolean isOrderApplyChristmasEvent(int visitDate) {
        return visitDate <= 25;
    }
}
