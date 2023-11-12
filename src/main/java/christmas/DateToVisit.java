package christmas;

import java.util.Arrays;
import java.util.List;

public class DateToVisit {
    private final Integer visitDate;
    private final Boolean startDate;
    List<Integer> starDateList = Arrays.asList(3, 10, 17, 24, 25, 31);

    public DateToVisit(Integer date) {
        validate(date);
        this.visitDate = date;
        this.startDate = isStarDate(date);
    }

    private void validate(int date) {
        if (!isDateRangeRight(date)) {
            throw new IllegalArgumentException("[ERROR] 식당 방문 예정 날짜는 1에서 31사이 숫자여야 합니다.");
        }
    }

    private Boolean isDateRangeRight(int date) {
        return date >= 1 && date <= 31;
    }

    private Boolean isStarDate(int date) {
        return starDateList.contains(date);
    }

    public Integer getVisitDate() {
        return visitDate;
    }

    public Boolean getStartDate() {
        return startDate;
    }
}
