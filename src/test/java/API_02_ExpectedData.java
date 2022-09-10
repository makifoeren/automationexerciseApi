import java.util.HashMap;
import java.util.Map;

public class API_02_ExpectedData {


    public static Map<String,Object> API02() {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("message","This request method is not supported.");
        expectedData.put("responseCode", 405);

        return expectedData; }



}
