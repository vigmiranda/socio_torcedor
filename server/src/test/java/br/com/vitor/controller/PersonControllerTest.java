package br.com.vitor.controller;

import br.com.vitor.PartnerFanApplicationTest;
import br.com.vitor.campaign.domain.Person;
import br.com.vitor.campaign.domain.HeartClub;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PersonControllerTest extends PartnerFanApplicationTest {

    private static String URL_PERSON= "/person/{id}";

    @Test
    public void getPersonById() throws Exception {
        given()
                .pathParams("id", 1)
                .get(URL_PERSON)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", equalTo("Vitor"));
    }

    @Test
    public void removeCampaign() throws Exception {
        given()
                .pathParams("id", 1)
                .delete(URL_PERSON)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void saveCampaign() throws Exception {

        final Person person = buildCampaign("Vitor", "Botafogo", "email_fake@gmail.com");

        given()
                .request().header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(person)
                .when()
                .post("/person")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void updateCampaign() throws Exception {

        final Person person = buildCampaign("Vitor", "Botafogo", "email_fake@gmail.com");
        person.setId(1);

        given().request().header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(person)
                .when()
                .put("/person")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.SC_OK);
    }

    private Person buildCampaign(String campaignName, String heartClubName, String email) {
        final Person person = new Person();
        final HeartClub heartClub = new HeartClub();

        heartClub.setName(campaignName);

        person.setName(heartClubName);
        person.setDateOfBirth(new Date());
        person.setEmail(email);
        person.setHeartClub(heartClub);
        return person;
    }


}

