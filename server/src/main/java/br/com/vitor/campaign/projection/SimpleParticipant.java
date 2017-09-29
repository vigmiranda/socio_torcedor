package br.com.vitor.campaign.projection;

public interface SimpleParticipant {

    Integer getId();
    String  getName();
    String getBirthday();
    String getEmail();
    SimpleHeartClub getHeartClub();

    interface SimpleHeartClub {
        String getName();
    }

}
