package post_request;

import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post_05 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Request Parameter: search_product (For example: top, tshirt, jean)
Response Code: 200
Response JSON: Searched products list
     */


    @Test
    public void test01() {

        spec.pathParams("first", "api", "second", "searchProduct");

        Response response = given().spec(spec).formParam("search_product","jean").when().post("/{first}/{second}");

        response.jsonPath().prettyPrint();



    }
}