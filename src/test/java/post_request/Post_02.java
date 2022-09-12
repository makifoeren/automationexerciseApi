package post_request;

import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post_02 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/productsList
Request Method: POST
Response Code: 405
Response Message: This request method is not supported.
     */


    @Test
    public void test01() {

        spec.pathParams("first", "api", "second", "productsList");

        Response response = given().contentType(ContentType.JSON).spec(spec).when().post("/{first}/{second}");

        response.jsonPath().prettyPrint();


        JsonPath actualData = response.jsonPath();

        Assert.assertEquals("This request method is not supported.", actualData.getString("message"));
        Assert.assertEquals("405", actualData.getString("responseCode"));
        System.out.println(actualData.getString("message"));

    }


}
