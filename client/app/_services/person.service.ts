import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import {Person} from "../_models/person";



@Injectable()
export class PersonService {
    constructor(private http: Http) { }

    public getAll() {
        return this.http.get('http://localhost:8090/participant/').map((response: Response) => response.json());
    }

    create(person: Person) {
        return this.http.post('http://localhost:8090/participant/', person).map((response: Response) => response.json());
    }
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

        private handleError(error: any): Promise<any> {
            console.error('An error occurred', error); // for demo purposes only
            return Promise.reject(error.message || error);
        }
       private jwt() {
           // create authorization header with jwt token
           let currentUser = JSON.parse(localStorage.getItem('currentUser'));
           if (currentUser && currentUser.token) {
               let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
               return new RequestOptions({ headers: headers });
           }
       }
}