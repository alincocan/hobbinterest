import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseRegisterComponent } from './register.component';
import {SharedModule} from '../../core/modules/shared.module';

const routes = [
    {
        path     : '',
        component: FuseRegisterComponent
    }
];

@NgModule({
    declarations: [
        FuseRegisterComponent
    ],
    imports     : [
        SharedModule,
        RouterModule.forChild(routes)
    ]
})

export class RegisterModule
{

}
