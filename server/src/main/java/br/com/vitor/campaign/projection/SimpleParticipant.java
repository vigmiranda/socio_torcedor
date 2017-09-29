package br.com.vitor.campaign.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface SimpleCampaign {

    Integer getId();
    String  getName();
    String getStartDate();
    String getEndDate();
    SimpleHeartClub getHeartClub();

    interface SimpleHeartClub {
        String getName();
    }

}
