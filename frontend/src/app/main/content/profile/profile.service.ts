import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {CrudService} from "../../../core/services/crud.service";

@Injectable()
export class ProfileService/* implements Resolve<any>*/ extends CrudService
{
    timeline: any;
    about: any;
    photosVideos: any;

    timelineOnChanged: BehaviorSubject<any> = new BehaviorSubject({});
    aboutOnChanged: BehaviorSubject<any> = new BehaviorSubject({});
    photosVideosOnChanged: BehaviorSubject<any> = new BehaviorSubject({});

    constructor( http: HttpClient)
    {
      super(http);
    }

    public getAboutByUser(): Observable<any> {
      let url: string = this.URL + 'GET/about';
      return this.getObjects(url);
    }
}
