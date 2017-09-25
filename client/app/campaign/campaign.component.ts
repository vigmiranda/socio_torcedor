import {Component, OnInit} from '@angular/core';

@Component({
    moduleId: module.id,
    templateUrl: 'campaign.component.html'
})

export class CampaignComponent implements OnInit  {


    constructor() {

    }

    ngOnInit(){
        console.log("chegou aqui");
    }

}