package christmas;

import java.util.Arrays;
import java.util.List;

public class DateToVisit {
    private final Integer visitDate;
    private final Boolean startDate;
    private final String dayOfDate;
    private final List<Integer> starDateList = Arrays.asList(3, 10, 17, 24, 25, 31);
    private final List<String> day = Arrays.asList("금", "토", "일", "월", "화", "수", "목");

    public DateToVisit(Integer date) {
        validate(date);
        this.visitDate = date;
        this.startDate = isStarDate(date);
        this.dayOfDate = calculateDay(date);
    }

    private void validate(int date) {
        if (!isDateRangeRight(date)) {
            throw new IllegalArgumentException(ExceptionList.DATEEXCPTION.getContent());
        }
    }

    private Boolean isDateRangeRight(int date) {
        return date >= 1 && date <= 31;
    }

    private Boolean isStarDate(int date) {
        return starDateList.contains(date);
    }

    private String calculateDay(int date) {
        return day.get((date - 1) % 7);
    }

    public Integer getVisitDate() {
        return visitDate;
    }

    public Boolean getStarDate() {
        return startDate;
    }

    public String getDayOfDate() {
        return dayOfDate;
    }
}
