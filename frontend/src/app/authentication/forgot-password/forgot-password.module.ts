import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseForgotPasswordComponent } from './forgot-password.component';
import {SharedModule} from '../../core/modules/shared.module';

const routes = [
    {
        path     : 'auth/forgot-password',
        component: FuseForgotPasswordComponent
    }
];

@NgModule({
    declarations: [
        FuseForgotPasswordComponent
    ],
    imports     : [
        SharedModule,
        RouterModule.forChild(routes)
    ]
})

export class ForgotPasswordModule
{

}
