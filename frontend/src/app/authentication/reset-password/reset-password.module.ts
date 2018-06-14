import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseResetPasswordComponent } from './reset-password.component';
import {SharedModule} from '../../core/modules/shared.module';

const routes = [
    {
        path     : '',
        component: FuseResetPasswordComponent
    }
];

@NgModule({
    declarations: [
        FuseResetPasswordComponent
    ],
    imports     : [
        SharedModule,
        RouterModule.forChild(routes)
    ]
})

export class ResetPasswordModule
{

}
