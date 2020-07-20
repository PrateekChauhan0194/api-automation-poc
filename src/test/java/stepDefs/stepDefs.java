package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefs extends Utils {
    ResponseSpecification resspec;
    RequestSpecification res;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Logger file {string} is ready for logging")
    public void loggerFileIsReadyForLogging(String logFileName) throws IOException {
        createLogFile(logFileName);
    }

    @Given("user has request payload ready for {string}")
    public void user_has_request_payload_ready(String serviceName, DataTable dt) throws IOException {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = given().spec(requestSpecification())
                .body(data.addPlacePayload(list));
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        response =res.when().post("/maps/api/place/add/json").
                then().spec(resspec).extract().response();
    }

    @Then("API call is successful with status code {int}")
    public void api_call_is_successful_with_status_code(int expectedStatusCode) {
        System.out.println(response.getStatusCode());
        assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String expectedValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        System.out.println(response.asString());
        assertEquals(js.get(key).toString(), expectedValue);
    }
}
