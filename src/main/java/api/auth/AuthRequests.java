package api.auth;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class AuthRequests {
    public static Response loginAndResponse(String username, String password) {
        JSONObject request = new JSONObject();
        request.put("username", username);
        request.put("password", password);
        return
                given()
                        .body(request.toJSONString())
                        .contentType(ContentType.JSON)
                        .when()
                        .post("auth")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public static String parseForAccessToken(Response loginResponse) {
        return loginResponse.jsonPath().getString("token");
    }

}
