import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TC04_DeleteDemo {

    @Test
    public void DeleteDemo(){

        when().delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).
                log().all();

    }

}
