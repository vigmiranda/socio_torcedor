import { Component, OnInit } from '@angular/core';
import {PersonService} from "../_services/person.service";
import {Person} from "../_models/person";

@Component({
    moduleId: module.id,
    templateUrl: 'person.component.html'
})

export class PersonComponent implements OnInit  {
    persons: Person[] = [];

    constructor(private personService: PersonService) {
        this.loadPerson();

    }

    ngOnInit(){
        console.log("chegou aqui");
    }

    private loadPerson() {
        this.personService.getAll().subscribe( persons => { this.persons = persons; });
    }

}