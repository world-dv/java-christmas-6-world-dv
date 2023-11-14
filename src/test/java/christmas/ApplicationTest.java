package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_범위_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("13일");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-3,레드와인-3,코카콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_쉼표_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,타파스-2 시저샐러드-3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_바_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "아이스크림--1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_오입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크ㄹ");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-1,티본스테이크-2");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_범위_20개_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-23,아이스크림-8,제로콜라-10");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 주문_유효성_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 주문_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 크리스마스_할인_출력() {
        assertSimpleTest(() -> {
            run("17", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("크리스마스 디데이 할인:");
        });
    }

    @Test
    void 크리스마스_할인_미출력() {
        assertSimpleTest(() -> {
            run("26", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain("크리스마스 디데이 할인:");
        });
    }

    @Test
    void 평일_일요일_할인_출력() {
        assertSimpleTest(() -> {
            run("17", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("평일 할인: ");
        });
    }

    @Test
    void 평일_월요일_할인_출력() {
        assertSimpleTest(() -> {
            run("18", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("평일 할인: ");
        });
    }

    @Test
    void 평일_화요일_할인_출력() {
        assertSimpleTest(() -> {
            run("19", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("평일 할인: ");
        });
    }

    @Test
    void 평일_수요일_할인_출력() {
        assertSimpleTest(() -> {
            run("20", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("평일 할인: ");
        });
    }

    @Test
    void 평일_목요일_할인_출력() {
        assertSimpleTest(() -> {
            run("21", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("평일 할인: ");
        });
    }

    @Test
    void 주말_금요일_할인_출력() {
        assertSimpleTest(() -> {
            run("22", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("주말 할인: ");
        });
    }

    @Test
    void 주말_토요일_할인_출력() {
        assertSimpleTest(() -> {
            run("23", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("주말 할인: ");
        });
    }

    @Test
    void 평일_주말_할인_미출력() {
        assertSimpleTest(() -> {
            run("21", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain("주말 할인:");
        });
    }

    @Test
    void 주말_평일_할인_미출력() {
        assertSimpleTest(() -> {
            run("23", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain("평일 할인:");
        });
    }

    @Test
    void 특별_할인_출력() {
        assertSimpleTest(() -> {
            run("24", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("특별 할인:");
        });
    }

    @Test
    void 특별_할인_미출력() {
        assertSimpleTest(() -> {
            run("20", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain("특별 할인:");
        });
    }

    @Test
    void 증정_이벤트_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("증정 이벤트:");
        });
    }

    @Test
    void 증정_이벤트_미출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1");
            assertThat(output()).doesNotContain("증정 이벤트:");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
