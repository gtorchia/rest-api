
package services;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class StreetLevelCrimeTest {

    private String ENDPOINT_GET_ALL_CRIMES = "https://data.police.uk/api/crimes-street/all-crime";


    @Test
    public void testStreetLevelCrime() {

        double latitude = 52.629729;
        double longitude = -1.131592;

        given().
                param("lat",String.valueOf(latitude)+"&").
                param("lon",String.valueOf(longitude)).
                get(ConfigurationURI.OPEN_NOTIFY_API_URI).
                then().
                statusCode(HttpStatus.SC_OK).
                body("category",equalTo( "anti-social-behaviour"),
                        "location_type",containsInAnyOrder("Force"));

    }


}

