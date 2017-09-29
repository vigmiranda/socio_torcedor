import { Component, OnInit } from '@angular/core';
import {PersonService} from "../_services/person.service";
import {Person} from "../_models/person";

@Component({
    moduleId: module.id,
    templateUrl: 'person.component.html'
})

export class PersonComponent implements OnInit  {
    persons: Person[] = [];
    formActive: boolean = false;
    newPerson: Person = new Person();

    constructor(private personService: PersonService) {
        this.loadPerson();
    }

    ngOnInit(){

    }

    private loadPerson() {
        this.personService.getAll().subscribe( persons => { this.persons = persons; });
    }

    private activeForm() {
        this.formActive = !this.formActive;

    }

    private save(){
        console.log(this.newPerson);
        //this.personService.create(person);
    }

}