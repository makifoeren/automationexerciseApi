package get_request;

import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_14 extends AutomationExercise {


    /*
    API URL: https://automationexercise.com/api/getUserDetailByEmail
Request Method: GET
Request Parameters: email
Response Code: 200
Response JSON: User Detail
     */

    @Test
    public void test01() {

        spec.pathParams("first", "api", "second", "getUserDetailByEmail");

        Response response=given().spec(spec).formParams("email","mahmut@gmail.com").when().get("/{first}/{second}");

        response.then().assertThat().statusCode(200);

        response.jsonPath().prettyPrint();

        JsonPath actualDate=response.jsonPath();

        Assert.assertEquals("200",actualDate.getString("responseCode"));



    }
}
