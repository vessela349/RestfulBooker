package core;


import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class BaseTest {

    @BeforeClass
    public static void baseSetup() {
        RestAssured.useRelaxedHTTPSValidation();

    }

    @BeforeMethod
    public void testSetup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
    }

    @AfterMethod
    public void testTearDown() {
        RestAssured.baseURI = "";
    }
}