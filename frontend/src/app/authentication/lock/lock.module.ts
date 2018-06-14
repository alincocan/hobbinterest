import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseLockComponent } from './lock.component';
import {SharedModule} from '../../core/modules/shared.module';

const routes = [
    {
        path     : 'auth/lock',
        component: FuseLockComponent
    }
];

@NgModule({
    declarations: [
        FuseLockComponent
    ],
    imports     : [
        SharedModule,
        RouterModule.forChild(routes)
    ]
})

export class LockModule
{

}
