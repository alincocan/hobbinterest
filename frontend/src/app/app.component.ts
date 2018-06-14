import { Component } from '@angular/core';
import {FuseNavigationModel} from "./navigation/navigation.model";
import {FuseTranslationLoaderService} from "./core/services/translation-loader.service";
import {TranslateService} from "@ngx-translate/core";
import {FuseSplashScreenService} from "./core/services/splash-screen.service";
import {FuseNavigationService} from "./core/components/navigation/navigation.service";

import { locale as navigationEnglish } from './navigation/i18n/en';
import { locale as navigationTurkish } from './navigation/i18n/tr';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(
    private fuseNavigationService: FuseNavigationService,
    private fuseSplashScreen: FuseSplashScreenService,
    private translate: TranslateService,
    private translationLoader: FuseTranslationLoaderService
  )
  {
    // Add languages
    this.translate.addLangs(['en', 'tr']);

    // Set the default language
    this.translate.setDefaultLang('en');

    // Use a language
    this.translate.use('en');

    // Set the navigation model
    this.fuseNavigationService.setNavigationModel(new FuseNavigationModel());

    // Set the navigation translations
    this.translationLoader.loadTranslations(navigationEnglish, navigationTurkish);
  }
}
