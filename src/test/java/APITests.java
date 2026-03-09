import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class APITests {

@Test
public void getUsers() {

RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

given()
.when()
.get("/contacts")
.then()
.statusCode(401);

}

}