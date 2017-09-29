package br.com.vitor.controller;

import br.com.vitor.PartnerFanApplicationTest;
import br.com.vitor.campaign.domain.HeartClub;
import br.com.vitor.campaign.domain.Participant;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParticipantControllerTest extends PartnerFanApplicationTest {

    private static String URL_CAMPAIGN = "/participant/{id}";

    @Test
    public void getCampaignById() throws Exception {
        given()
                .pathParams("id", 1)
                .get(URL_CAMPAIGN)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", equalTo("Vitor"));
    }

    @Test
    public void removeCampaign() throws Exception {
        given()
                .pathParams("id", 1)
                .delete(URL_CAMPAIGN)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void saveCampaign() throws Exception {

        final Participant participant = buildParticipant("Vitor", "Botafogo");

        given()
                .request().header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(participant)
                .when()
                .post("/participant")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void updateCampaign() throws Exception {

        final Participant participant = buildParticipant("Vitor", "Botafogo");
        participant.setId(1);

        given().request().header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(participant)
                .when()
                .put("/participant")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.SC_OK);
    }

    private Participant buildParticipant(String participantName, String heartClubName) {
        final Participant participante = new Participant();
        final HeartClub heartClub = new HeartClub();

        heartClub.setName(participantName);

        participante.setName(heartClubName);
        participante.setBirthday(new Date());
        participante.setEmail("teste@email.com");
        participante.setHeartClub(heartClub);
        return participante;
    }


}

