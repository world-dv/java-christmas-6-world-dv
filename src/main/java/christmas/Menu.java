package christmas;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Integer> menu;

    public Menu() {
        this.menu = createMenu();
    }

    private Map<String, Integer> createMenu() {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("양송이수프", 6_000);
        menu.put("타파스", 5_500);
        menu.put("시저샐러드", 8_000);
        menu.put("티본스테이크", 55_000);
        menu.put("바비큐립", 54_000);
        menu.put("해산물파스타", 35_000);
        menu.put("크리스마스파스타", 25_000);
        menu.put("초코케이크", 15_000);
        menu.put("아이스크림", 5_000);
        menu.put("제로콜라", 3_000);
        menu.put("레드와인", 60_000);
        menu.put("샴페인", 25_000);
        return menu;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }
}
