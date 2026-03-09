
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ContactTests extends BaseTest {

@Test(priority=2)
public void addContact() {

String payload = "{\n" +
"\"firstName\": \"John\",\n" +
"\"lastName\": \"Doe\",\n" +
"\"birthdate\": \"1970-01-01\",\n" +
"\"email\": \"jdoe@fake.com\",\n" +
"\"phone\": \"8005555555\",\n" +
"\"street1\": \"1 Main St.\",\n" +
"\"street2\": \"Apartment A\",\n" +
"\"city\": \"Anytown\",\n" +
"\"stateProvince\": \"KS\",\n" +
"\"postalCode\": \"12345\",\n" +
"\"country\": \"USA\"\n" +
"}";

given()
.header("Authorization", "Bearer " + UserTests.token)
.header("Content-Type","application/json")
.body(payload)

.when()
.post("/contacts")

.then()
.statusCode(201);

}

}