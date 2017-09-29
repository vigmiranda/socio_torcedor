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
var http_1 = require("@angular/http");
var PersonService = /** @class */ (function () {
    function PersonService(http) {
        this.http = http;
    }
    PersonService.prototype.getAll = function () {
        return this.http.get('http://localhost:8090/person/').map(function (response) { return response.json(); });
    };
    PersonService.prototype.create = function (person) {
        return this.http.post('http://localhost:8090/person/', person).map(function (response) { return response.json(); });
    };
    /*
       getById(id: number) {
           return this.http.get('/campaign/' + id, this.jwt()).map((response: Response) => response.json());
       }

         /!* create(user: User) {
              return this.http.post('/api/users', user, this.jwt()).map((response: Response) => response.json());
          }

          update(user: User) {
              return this.http.put('/api/users/' + user.id, user, this.jwt()).map((response: Response) => response.json());
          }

          delete(id: number) {
              return this.http.delete('/api/users/' + id, this.jwt()).map((response: Response) => response.json());
          }

          // private helper methods*!/
      */
    PersonService.prototype.handleError = function (error) {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    };
    PersonService.prototype.jwt = function () {
        // create authorization header with jwt token
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            var headers = new http_1.Headers({ 'Authorization': 'Bearer ' + currentUser.token });
            return new http_1.RequestOptions({ headers: headers });
        }
    };
    PersonService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.Http])
    ], PersonService);
    return PersonService;
}());
exports.PersonService = PersonService;
//# sourceMappingURL=person.service.js.map