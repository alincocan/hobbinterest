import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseMailConfirmComponent } from './mail-confirm.component';
import {SharedModule} from '../../core/modules/shared.module';

const routes = [
    {
        path     : 'auth/mail-confirm',
        component: FuseMailConfirmComponent
    }
];

@NgModule({
    declarations: [
        FuseMailConfirmComponent
    ],
    imports     : [
        SharedModule,
        RouterModule.forChild(routes)
    ]
})

export class MailConfirmModule
{

}
