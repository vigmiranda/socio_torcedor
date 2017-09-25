import { Component, OnInit } from '@angular/core';
import {CampaignService} from "../_services/campaing.service";

@Component({
    moduleId: module.id,
    templateUrl: 'campaign.component.html'
})

export class CampaignComponent implements OnInit  {
    campaigns: any[] = [];

    constructor(private campaignServer: CampaignService) {
        this.loadCampaign();

    }

    ngOnInit(){
        console.log("chegou aqui");
    }

    private loadCampaign() {
        this.campaignServer.getAll().subscribe( campaigns => { this.campaigns = campaigns; });
    }

}