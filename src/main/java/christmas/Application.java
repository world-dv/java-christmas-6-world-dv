package christmas;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        DateToVisit dateToVisit = inputDate();
    }

    public static DateToVisit inputDate() {
        while(true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주새요!)");
            try {
                int date = Integer.parseInt(Console.readLine());
                return new DateToVisit(date);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 식당 예상 방문 날짜는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
