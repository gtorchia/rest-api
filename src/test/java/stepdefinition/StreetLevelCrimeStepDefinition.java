package stepdefs;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import services.ConfigurationURI;

import java.util.Map;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;



public class StreetLevelCrimeStepDefinition {

    private Response response;
    private RequestSpecification request;
    private ValidatableResponse json;

    private String ENDPOINT_GET_ALL_CRIMES = "https://data.police.uk/api/crimes-street/all-crime";




    @Given("^I have  one point on map \"([^\"]*)\" longitude \"([^\"]*)\"  latitude$")
    public void iHaveOnePointOnMapLongitudeLatitude(String arg0, String arg1) throws Throwable {


        request=given().contentType(ContentType.JSON).baseUri(ConfigurationURI.OPEN_NOTIFY_API_URI).param("lat",arg0).and().param("lng",arg1);

    }

   

    @When("^a user retrieves the specific response$")
    public void aUserRetrievesTheSpecificResponse()  {

        response = request.when().get(ENDPOINT_GET_ALL_CRIMES);
        System.out.println("response: "+response.prettyPrint());

    }

    @Then("^the status code is (\\d+)$")
    public void theStatusCodeIs(int arg0)  {
        json = response.then().statusCode(arg0);

    }

    @And("^response includes the following$")
    public void responseIncludesTheFollowing(Map<String,String> responseFields) {
        for (Map.Entry<String,String> field : responseFields.entrySet()){
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(),equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(),equalTo(field.getValue()));
            }
        }
    }



}

