import { Component, OnInit } from '@angular/core';
import {ProfileService} from "../profile/profile.service";
import {NewsFeedService} from "./news-feed.service";

@Component({
  selector: 'app-news-feed',
  templateUrl: './news-feed.component.html',
  styleUrls: ['./news-feed.component.scss']
})
export class NewsFeedComponent implements OnInit {

  timeline: any;

  constructor(private newsFeedService: NewsFeedService)
  {
    //     this.profileService.timelineOnChanged.subscribe(timeline => {
    //         this.timeline = timeline;
    //     });
    this.timeline = []
  }

  ngOnInit()
  {

  }

}
