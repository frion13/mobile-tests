package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class GettinhStartedTests extends TestBase {

    @Tag("onboarding")
    @Test
    @DisplayName("Успешное отображение 4ех экранов онбординга при первом запуске")
    void CheckOnboardingInfoTest() {
        step("Проверка заголовка первой страницы", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });


        step("Проверка кнопки управления языками на первой странице", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton"))
                    .shouldHave(text("Add or edit languages"));
        });

        step("Проверка заголовка на второй странице", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Проверка заголовка третьей страницы", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));

        });

        step("Проверка заголовка четвертой страницы", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
        });

        step("Закончить онбординг и перейти к википедии", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar")).shouldBe(visible);
        });
    }


    @Tag("onboarding")
    @Test
    @DisplayName("Проверка выхода из онбординга при нажатии кнопки skip")
    void checkSkipButton() {
        step("Проверка выхода из онбординга при нажатии на skip", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar")).shouldBe(visible);
        });
}
    }




