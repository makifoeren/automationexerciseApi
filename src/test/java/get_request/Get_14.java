package get_request;

import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_date.AutomationExerciseTestData;

import java.util.HashMap;
import java.util.Map;

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

        AutomationExerciseTestData dataKey = new AutomationExerciseTestData();// gerekli methodun cagrilmasi icin obje olusturuyoruz

        Map<String, String> dataKeyIcMap = // ic map olusuturoyrz
                dataKey.dataKeyMap("mahmut", "mahmut@gmail.com", "Mr");

        System.out.println("dataKeyIcMap = " + dataKeyIcMap);

        Map<String, Object> expectedData = dataKey.expectedDateMap(200, dataKeyIcMap);

        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).formParams("email", "mahmut@gmail.com").when().
                get("/{first}/{second}");

        response.jsonPath().prettyPrint();
        response.then().assertThat().statusCode(200);
        JsonPath actualDateMap = response.jsonPath();
        //Map<String, Object> actualDateMap = response.jsonPath(); //  De-Serialization ==> Json formatindan Java obj cevirme


        Assert.assertEquals(expectedData.get("responseCode"), actualDateMap.get("200"));
        Assert.assertEquals(expectedData.get("name"), ((Map) actualDateMap.get("user")).get("name"));
        Assert.assertEquals(expectedData.get("email"), ((Map) actualDateMap.get("user")).get("email"));
        Assert.assertEquals(expectedData.get("title"), ((Map) actualDateMap.get("user")).get("title"));


    }
}
