import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { SharedModule } from '../core/modules/shared.module';

import { FuseMainComponent } from './main.component';
// import { FuseContentComponent } from './content/content.component';
import { FuseFooterComponent } from './footer/footer.component';
import { FuseNavbarVerticalComponent } from './navbar/vertical/navbar-vertical.component';
import { FuseToolbarComponent } from './toolbar/toolbar.component';
import { FuseNavbarVerticalToggleDirective } from './navbar/vertical/navbar-vertical-toggle.directive';
import { FuseNavbarHorizontalComponent } from './navbar/horizontal/navbar-horizontal.component';
import { FuseQuickPanelComponent } from './quick-panel/quick-panel.component';
import {FuseThemeOptionsComponent} from "../core/components/theme-options/theme-options.component";
import {FuseNavigationModule} from "../core/components/navigation/navigation.module";
import {FuseSearchBarModule} from "../core/components/search-bar/search-bar.module";
import {FuseShortcutsModule} from "../core/components/shortcuts/shortcuts.module";
import {FuseContentComponent} from "./content/content.component";


const routes  = [
  {
    path: '',
    component: FuseMainComponent,
    children: [
      {
        path: 'newsfeed',
        loadChildren: './content/news-feed/news-feed.module#NewsFeedModule'

      } ,
      {
        path: 'profile',
        loadChildren: './content/profile/profile.module#ProfileModule'

      }
    ]
  }

];

@NgModule({
    declarations: [
        FuseFooterComponent,
        FuseMainComponent,
        FuseNavbarVerticalComponent,
        FuseNavbarHorizontalComponent,
        FuseToolbarComponent,
        FuseNavbarVerticalToggleDirective,
        FuseQuickPanelComponent,
        FuseThemeOptionsComponent,
        FuseContentComponent
    ],
    imports     : [
        SharedModule,
        RouterModule,
        RouterModule.forChild(routes),
        FuseNavigationModule,
        FuseSearchBarModule,
        FuseShortcutsModule

    ],
    exports     : [
        FuseMainComponent
    ]
})

export class FuseMainModule
{
1}
