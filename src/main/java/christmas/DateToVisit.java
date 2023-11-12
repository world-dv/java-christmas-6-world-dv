package christmas;

public class DateToVisit {
    private final Integer visitDate;

    DateToVisit(Integer date) {
        validate(date);
        this.visitDate = date;
    }

    private void validate(int date) {
        if (!isDateRangeRight(date)) {
            throw new IllegalArgumentException("[ERROR] 식당 방문 예정 날짜는 1에서 31사이 숫자여야 합니다.");
        }
    }

    private Boolean isDateRangeRight(int date) {
        return date >= 1 && date <= 31;
    }
}
