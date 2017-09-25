package br.com.vitor.campaign.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface SimplePerson {

    Integer getId();
    String  getName();
    String getDateOfBirth();
    String getEmail();
    SimpleHeartClub getHeartClub();

    interface SimpleHeartClub {
        String getName();
    }

}
