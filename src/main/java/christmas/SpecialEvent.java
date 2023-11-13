package christmas;

public class SpecialEvent {
    public Integer applySpecialEvent(Boolean applyEvent, Boolean star) {
        if (star && applyEvent) {
            return -1000;
        }
        return 0;
    }
}
