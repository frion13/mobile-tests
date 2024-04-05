package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic("tlom_l4GgJC", "t8vyqg2zsfJeMSZuqjz7")
                .get(url)
                .then()
                .statusCode(200)
                .log().status()
                .log().body()
                .extract().path("automation_session.video_url");
    }

}
