package br.com.vitor.campaign.controller;

import br.com.vitor.campaign.domain.Participant;
import br.com.vitor.campaign.exception.ParticipantNotFoundException;
import br.com.vitor.campaign.projection.SimpleParticipant;
import br.com.vitor.campaign.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/participant", produces = MediaType.APPLICATION_JSON_VALUE)
public class ParticipantController {


    private final ProjectionFactory projectionFactory = new SpelAwareProxyProjectionFactory();
    private final ParticipantService participantService;

    @Autowired
    @ConstructorProperties({"participantService"})
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public SimpleParticipant getCampaignById (@PathVariable("id") Optional<Participant> participant) {

        return this.projectionFactory.createProjection(SimpleParticipant.class, participant.orElseThrow(ParticipantNotFoundException::new));
    }

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public List<SimpleParticipant> list () {

        return participantService.list().stream()
                .map(c -> this.projectionFactory.createProjection(SimpleParticipant.class, c))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void remove(@PathVariable("id") Optional<Participant> campaign) {
        this.participantService.remove(campaign.orElseThrow(ParticipantNotFoundException::new));
    }

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody @Valid Participant participante) {
        this.participantService.merge(participante);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody @Valid Participant participante) {
        this.participantService.merge(participante);
    }
}
