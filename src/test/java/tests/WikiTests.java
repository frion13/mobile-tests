package tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {
    @Test
    @Tag("mobile")
    void successfulSearchTest() {
        step(" Click open article", () -> {
            $(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text")).click();
        });
        step("Check opening", () ->
                $$(id("org.wikipedia.alpha:id/view_news_fullscreen_link_card_list"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Check opening", () ->
                $(className("android.widget.TextView")).shouldHave(text("A severe-rated earthquake strikes near Hualien City, Taiwan (damage pictured).")));


    }
}



