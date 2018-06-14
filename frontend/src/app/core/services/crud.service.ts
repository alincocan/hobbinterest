import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {map} from "rxjs/operator/map";

@Injectable()
export class CrudService {

  public readonly URL = "http://localhost:8090/hobbinterest/service/";

  constructor(public httpClient: HttpClient) { }

  protected getObjects(url: string): Observable<any> {

    return this.httpClient.get(url);

  }

  saveObject(url: string, object: any ): Observable<any> {

    return this.httpClient.post(url, object);

  }
}
