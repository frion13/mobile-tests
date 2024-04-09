package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
//        System.setProperty("deviceHost", System.getProperty("deviceHost", "emulator"));
        switch (System.getProperty("deviceHost")) {
            case "browserstack" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "emulator" -> Configuration.browser = EmulatorDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        if (System.getProperty("deviceHost").equals("browserstack")){
            Attach.addVideo(sessionId);
        } else {
            Attach.screenshotAs("screenshot");
        }
        closeWebDriver();
    }
}

