import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class c1 extends AutomationExercise {

    @Test
    public void test01() {

        spec.pathParams("p1", "api", "p2", "productsList");

        Map<String,Object> expectedData= API_02_ExpectedData.API02();


        Response rp = given().
                contentType(ContentType.JSON).
                spec(spec).
                when().
                post("/{p1}/{p2}");


        JsonPath actualData=rp.jsonPath();
        System.out.println(actualData);





        Assert.assertEquals(expectedData.get("message"),actualData.getString("message"));
        Assert.assertEquals(expectedData.get("responseCode"),actualData.getInt("responseCode"));


    }
}
