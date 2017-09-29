package br.com.vitor.campaign.service;


import br.com.vitor.campaign.domain.Campaign;
import br.com.vitor.campaign.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    public void merge(Campaign campaign) {campaignRepository.save(campaign);}

    public void remove(Campaign campaign) {campaignRepository.delete(campaign.getId());}

    public List<Campaign> list() {return (List<Campaign>) campaignRepository.findAll();}
}
