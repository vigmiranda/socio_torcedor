package br.com.vitor.campaign.controller;

import br.com.vitor.campaign.domain.Person;
import br.com.vitor.campaign.exception.PersonNotFoundException;
import br.com.vitor.campaign.projection.SimplePerson;
import br.com.vitor.campaign.service.PersonService;
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
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {


    private final ProjectionFactory projectionFactory = new SpelAwareProxyProjectionFactory();
    private final PersonService personService;

    @Autowired
    @ConstructorProperties({"campaignService"})
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public SimplePerson getCampaignById (@PathVariable("id") Optional<Person> campaign) {

        return this.projectionFactory.createProjection(SimplePerson.class, campaign.orElseThrow(PersonNotFoundException::new));
    }

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public List<SimplePerson> list () {

        return personService.list().stream()
                .map(c -> this.projectionFactory.createProjection(SimplePerson.class, c))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void remove(@PathVariable("id") Optional<Person> campaign) {
        this.personService.remove(campaign.orElseThrow(PersonNotFoundException::new));
    }

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody @Valid Person person) {
        this.personService.merge(person);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody @Valid Person person) {
        this.personService.merge(person);
    }
}
