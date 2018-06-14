import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewsFeedComponent } from './news-feed.component';
import {FuseProfileComponent} from "../profile/profile.component";
import {NewsFeedService} from "./news-feed.service";
import {SharedModule} from "../../../core/modules/shared.module";
import {RouterModule} from "@angular/router";



const routes = [
  {
    path     : '',
    component: NewsFeedComponent
    // resolve  : {
    //     profile: ProfileService
    // }
  }
];

@NgModule({
  imports: [
    SharedModule,
    RouterModule.forChild(routes)

  ],
  declarations: [NewsFeedComponent],
  providers: [NewsFeedService]
})
export class NewsFeedModule { }
