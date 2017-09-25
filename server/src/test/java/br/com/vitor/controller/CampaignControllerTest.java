package br.com.vitor.controller;

import br.com.vitor.PartnerFanApplicationTest;
import br.com.vitor.campaign.domain.Campaign;
import br.com.vitor.campaign.domain.HeartClub;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CampaignControllerTest extends PartnerFanApplicationTest {

    private static String URL_CAMPAIGN = "/campaign/{id}";

    @Test
    public void getCampaignById() throws Exception {
        given()
                .pathParams("id", 1)
                .get(URL_CAMPAIGN)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", equalTo("Brasileiro"));
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

        final Campaign campaign = buildCampaign("Cruzeiro", "Copa do Basil");

        given()
                .request().header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(campaign)
                .when()
                .post("/campaign")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void updateCampaign() throws Exception {

        final Campaign campaign = buildCampaign("Cruzeiro", "Copa do Basil");
        campaign.setId(1);

        given().request().header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(campaign)
                .when()
                .put("/campaign")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.SC_OK);
    }

    private Campaign buildCampaign(String campaignName, String heartClubName) {
        final Campaign campaign = new Campaign();
        final HeartClub heartClub = new HeartClub();

        heartClub.setName(campaignName);

        campaign.setName(heartClubName);
        campaign.setStartDate(new Date());
        campaign.setEndDate(new Date());
        campaign.setHeartClub(heartClub);
        return campaign;
    }


}

