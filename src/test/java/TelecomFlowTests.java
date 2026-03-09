import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class TelecomFlowTests extends BaseTest {

static String token;
static String contactId;

@Test(priority = 1)
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

@Test(priority = 2)
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

Response response =

given()
.header("Authorization","Bearer " + token)
.header("Content-Type","application/json")
.body(payload)

.when()
.post("/contacts");

response.then().statusCode(201);

contactId = response.jsonPath().getString("_id");

System.out.println("Contact ID: " + contactId);

}

@Test(priority = 3)
public void getContactList() {

given()
.header("Authorization","Bearer " + token)

.when()
.get("/contacts")

.then()
.statusCode(200);

}

@Test(priority = 4)
public void getContact() {

given()
.header("Authorization","Bearer " + token)

.when()
.get("/contacts/" + contactId)

.then()
.statusCode(200);

}

@Test(priority = 5)
public void logoutUser() {

given()
.header("Authorization","Bearer " + token)

.when()
.post("/users/logout")

.then()
.statusCode(200);

}

}