import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC03_PutDemo {

    @Test
    public void putDemo(){
        given().
                contentType("application/json").
                body("{\n" +
                        "    \"name\": \"Santosh\",\n" +
                        "    \"job\": \"QA\"\n" +
                        "}").
        when().
                put("https://reqres.in/api/users/2").
        then().
                body("updatedAt",notNullValue()).
                body("job",equalTo("DEV")).
                statusCode(200).
                log().all();

    }

}
