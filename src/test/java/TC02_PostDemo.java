import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC02_PostDemo {

    @Test(invocationCount = 10)
    public void postDemo(){
        given().
                contentType("application/json").
                body(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\data.json")).
        when().
                post("https://reqres.in/api/users").
        then().
               log().all().
                statusCode(201).
                body("name",equalTo("Santosh")).
                body("id",notNullValue()).
                body("createdAt",notNullValue());
    }

}
