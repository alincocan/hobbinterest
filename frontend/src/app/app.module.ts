import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SharedModule} from './core/modules/shared.module';
import {FuseConfigService} from './core/services/config.service';
import {FuseSplashScreenService} from './core/services/splash-screen.service';
import {FuseMainModule} from "./main/main.module";
import {FuseNavigationService} from "./core/components/navigation/navigation.service";
import {TranslateModule} from "@ngx-translate/core";


const appRoutes: Routes = [
  {
    path        : '',
    loadChildren: './authentication/authentication.module#AuthenticationModule'
  },
  {
    path        : 'home',
    loadChildren: './main/main.module#FuseMainModule'
  }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports     : [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    SharedModule,
    TranslateModule.forRoot(),
    FuseMainModule
  ],
  providers   : [
    FuseSplashScreenService,
    FuseConfigService,
    FuseNavigationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
