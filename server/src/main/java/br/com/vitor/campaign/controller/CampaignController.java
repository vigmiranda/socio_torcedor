package br.com.vitor.campaign.controller;

import br.com.vitor.campaign.domain.Campaign;
import br.com.vitor.campaign.exception.CampaignNotFoundException;
import br.com.vitor.campaign.projection.SimpleCampaign;
import br.com.vitor.campaign.service.CampaignService;
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
@RequestMapping(value = "/campaign", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignController {


    private final ProjectionFactory projectionFactory = new SpelAwareProxyProjectionFactory();
    private final CampaignService campaignService;

    @Autowired
    @ConstructorProperties({"campaignService"})
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public SimpleCampaign getCampaignById (@PathVariable("id") Optional<Campaign> campaign) {

        return this.projectionFactory.createProjection(SimpleCampaign.class, campaign.orElseThrow(CampaignNotFoundException::new));
    }

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public List<SimpleCampaign> list () {

        return campaignService.list().stream()
                .filter(c -> c.isActual())
                .map(c -> this.projectionFactory.createProjection(SimpleCampaign.class, c))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
    public void remove(@PathVariable("id") Optional<Campaign> campaign) {
        this.campaignService.remove(campaign.orElseThrow(CampaignNotFoundException::new));
    }

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody @Valid Campaign campaign) {
        this.campaignService.merge(campaign);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody @Valid Campaign campaign) {
        this.campaignService.merge(campaign);
    }
}
