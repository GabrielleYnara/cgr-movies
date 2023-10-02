package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.logging.Logger;

import static definitions.GenreControllerTestDefs.response;

public class UserControllerTestDefs  extends SetupTestDefs{
    private final Logger logger = Logger.getLogger(UserControllerTestDefs.class.getName());

    @When("A registered user logs in")
    public String aRegisteredUserLogsIn() throws JSONException {
        logger.info("Calling: A registered user logs in.");
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("emailAddress", "example@email.com");
        requestBody.put("password", "password");
        Response response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/users/login/");

        logger.info(response.jsonPath().getString("jwt"));
        return response.jsonPath().getString("jwt");
    }

    @Then("A user is authenticated")
    public void aUserIsAuthenticated() {
    }

    /**
     * When I add a new user.
     * @throws JSONException
     */
    @When("I add a new user")//create user
    public void iAddANewUser() throws JSONException {
        logger.info("Calling: I add a new user.");
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("emailAddress", "newuser@email.com");
        requestBody.put("password", "password123");
        requestBody.put("name", "New User");
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/users/register/");

        logger.info("User created with email: newuser@email.com");
    }

    @Then("A user is registered")
    public void aUserIsRegistered() {
    }
}