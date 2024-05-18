import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserregistrationService {
  constructor(private http: HttpClient) {}

  public doRegistration(user: any) {
    return this.http.post('http://localhost:2023/api/authenticate', user, {
      responseType: 'text' as 'json',
      observe: 'response',
    });
  }

  public getUsers() {
    return this.http.get('http://localhost:8080/api/getallUsers');
  }

  public deleteUser(id: number) {
    return this.http.get('http://localhost:8080/api/deleteUser/' + id);
  }
}
