package apiTests.positive;

import core.BaseTest;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

import static api.auth.AuthRequests.*;

public class AuthTest extends BaseTest {

    @Test
    public void verifyLoggedInUserAndToken() {
        Response login = loginAndResponse("admin", "password123");
        String accessToken = parseForAccessToken(login);
        Assert.assertNotNull(accessToken);
    }
}
