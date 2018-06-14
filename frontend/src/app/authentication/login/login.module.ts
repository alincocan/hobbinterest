import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseLoginComponent } from './login.component';
import {SharedModule} from '../../core/modules/shared.module';

const routes = [
    {
        path     : '',
        component: FuseLoginComponent
    }
];

@NgModule({
    declarations: [
        FuseLoginComponent
    ],
    imports     : [
        SharedModule,
        RouterModule.forChild(routes)
    ]
})

export class LoginModule
{

}
