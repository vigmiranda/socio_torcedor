"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var person_service_1 = require("../_services/person.service");
var person_1 = require("../_models/person");
var PersonComponent = /** @class */ (function () {
    function PersonComponent(personService) {
        this.personService = personService;
        this.persons = [];
        this.formActive = false;
        this.newPerson = new person_1.Person();
        this.loadPerson();
    }
    PersonComponent.prototype.ngOnInit = function () {
    };
    PersonComponent.prototype.loadPerson = function () {
        var _this = this;
        this.personService.getAll().subscribe(function (persons) { _this.persons = persons; });
    };
    PersonComponent.prototype.activeForm = function () {
        this.formActive = !this.formActive;
    };
    PersonComponent.prototype.save = function () {
        console.log(this.newPerson);
        //this.personService.create(person);
    };
    PersonComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            templateUrl: 'person.component.html'
        }),
        __metadata("design:paramtypes", [person_service_1.PersonService])
    ], PersonComponent);
    return PersonComponent;
}());
exports.PersonComponent = PersonComponent;
//# sourceMappingURL=person.component.js.map