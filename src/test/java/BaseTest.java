import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

@BeforeClass
public void setup() {

RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

}

}