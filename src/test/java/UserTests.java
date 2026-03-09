import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class UserTests extends BaseTest {

public static String token;

@Test(priority=1)
public void addUser() {
	String email = "apiuser" + System.currentTimeMillis() + "@fake.com";
	String payload = "{\n" +
			"\"firstName\": \"Test\",\n" +
			"\"lastName\": \"User\",\n" +
			"\"email\": \"" + email + "\",\n" +
			"\"password\": \"myPassword\"\n" +
			"}";

Response response =

given()
.header("Content-Type","application/json")
.body(payload)

.when()
.post("/users");

response.then().statusCode(201);

token = response.jsonPath().getString("token");

System.out.println("Generated Token: " + token);

}

}