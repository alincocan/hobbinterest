import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { MaterialModule } from './material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ColorPickerModule } from 'ngx-color-picker';
import { NgxDnDModule } from '@swimlane/ngx-dnd';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

import { FuseMatSidenavHelperDirective, FuseMatSidenavTogglerDirective } from '../directives/fuse-mat-sidenav-helper/fuse-mat-sidenav-helper.directive';
import { FuseMatSidenavHelperService } from '../directives/fuse-mat-sidenav-helper/fuse-mat-sidenav-helper.service';
import { FusePipesModule } from '../pipes/pipes.module';
import { FuseMatchMedia } from '../services/match-media.service';
import { FusePerfectScrollbarDirective } from '../directives/fuse-perfect-scrollbar/fuse-perfect-scrollbar.directive';
import { FuseIfOnDomDirective } from '../directives/fuse-if-on-dom/fuse-if-on-dom.directive';
import { FuseTranslationLoaderService } from '../services/translation-loader.service';
import { CookieService } from 'ngx-cookie-service';
import { TranslateModule } from '@ngx-translate/core';
import { ChartsModule } from 'ng2-charts';
import {CrudService} from "../services/crud.service";
import {FuseMaterialColorPickerComponent} from "../components/material-color-picker/material-color-picker.component";
import {FuseNavbarVerticalService} from "../../main/navbar/vertical/navbar-vertical.service";

@NgModule({
    declarations   : [
        FuseMatSidenavHelperDirective,
        FuseMatSidenavTogglerDirective,
        // FuseConfirmDialogComponent,
        // FuseCountdownComponent,
        // FuseHighlightComponent,
        FuseIfOnDomDirective,
        FusePerfectScrollbarDirective,
        FuseMaterialColorPickerComponent
    ],
    imports        : [
        FlexLayoutModule,
        MaterialModule,
        CommonModule,
        FormsModule,
        FusePipesModule,
        ReactiveFormsModule,
        ColorPickerModule,
        NgxDnDModule,
        NgxDatatableModule,
        ChartsModule
    ],
    exports        : [
        FlexLayoutModule,
        MaterialModule,
        CommonModule,
        FormsModule,
        FuseMatSidenavHelperDirective,
        FuseMatSidenavTogglerDirective,
        FusePipesModule,
        // FuseCountdownComponent,
        // FuseHighlightComponent,
        FusePerfectScrollbarDirective,
        ReactiveFormsModule,
        ColorPickerModule,
        NgxDnDModule,
        NgxDatatableModule,
        FuseIfOnDomDirective,
        FuseMaterialColorPickerComponent,
        TranslateModule,
        ChartsModule
    ],
    entryComponents: [
        // FuseConfirmDialogComponent
    ],
    providers      : [
        CookieService,
        FuseMatchMedia,
        FuseNavbarVerticalService,
        FuseMatSidenavHelperService,
        FuseTranslationLoaderService,
        CrudService
    ]
})

export class SharedModule
{

}
