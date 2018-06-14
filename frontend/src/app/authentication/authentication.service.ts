import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {URL} from "../core/constants";
import {CrudService} from "../core/services/crud.service";

@Injectable()
export class AuthenticationService extends CrudService {

  constructor(public http: HttpClient) { super(http);}

  login(username: string, password: string): Observable<any> {

    username = encodeURIComponent(username);
    password = encodeURIComponent(password);
    let body = 'j_username='+username+ "&j_password="+password;
    let headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/x-www-form-urlencoded'
      })
    };
    return this.http.post('http://localhost:8090/hobbinterest/login',body,httpOptions);
  }

  createUser(user: any): Observable<any> {
    return this.saveObject(URL + '/user/POST/create',user);
  }

}
