package christmas;

import java.util.HashMap;
import java.util.Map;

public class MenuType {
    private final Map<String, String> menuType;
    private final Map<String, Integer> menuTypeCount;

    public MenuType() {
        this.menuType = createMenuTypeList();
        this.menuTypeCount = createMenuTypeCountList();
    }

    private Map<String, String> createMenuTypeList() {
        Map<String, String> menuType = new HashMap<>();
        menuType.put("양송이수프", "애피타이저");
        menuType.put("타파스", "애피타이저");
        menuType.put("시저샐러드", "애피타이저");
        menuType.put("티본스테이크", "메인");
        menuType.put("바비큐립", "메인");
        menuType.put("해산물파스타", "메인");
        menuType.put("크리스마스파스타", "메인");
        menuType.put("초코케이크", "디저트");
        menuType.put("아이스크림", "디저트");
        menuType.put("제로콜라", "음료");
        menuType.put("레드와인", "음료");
        menuType.put("샴페인", "음료");
        return menuType;
    }

    private Map<String, Integer> createMenuTypeCountList() {
        Map<String, Integer> menuCount = new HashMap<>();
        menuCount.put("애피타이저", 0);
        menuCount.put("메인", 0);
        menuCount.put("디저트", 0);
        menuCount.put("음료", 0);
        return menuCount;
    }

    public Map<String, Integer> getMenuTypeCount() {
        return menuTypeCount;
    }

    public Map<String, String> getMenuType() {
        return menuType;
    }
}
