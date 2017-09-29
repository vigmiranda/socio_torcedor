package br.com.vitor.campaign.service;


import br.com.vitor.campaign.domain.Participant;
import br.com.vitor.campaign.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    public void merge(Participant participante) {
        participantRepository.save(participante);}

    public void remove(Participant participante) {
        participantRepository.delete(participante.getId());}

    public List<Participant> list() {return (List<Participant>) participantRepository.findAll();}
}
