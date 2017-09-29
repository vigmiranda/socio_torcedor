package br.com.vitor.campaign.service;


import br.com.vitor.campaign.domain.HeartClub;
import br.com.vitor.campaign.domain.Participant;
import br.com.vitor.campaign.repository.HeartClubRepository;
import br.com.vitor.campaign.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartClubService {

    @Autowired
    HeartClubRepository heartClubRepository;

    public HeartClub getByName(String name) {
        return null;
        //return this.heartClubRepository.findHeartClubByName(name).orElse(new HeartClub());
    }

}
