import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthenticationRoutingModule } from './authentication-routing.module';
import {ForgotPasswordModule} from './forgot-password/forgot-password.module';
import {LockModule} from './lock/lock.module';
import {MailConfirmModule} from './mail-confirm/mail-confirm.module';
import {RegisterModule} from './register/register.module';
import {ResetPasswordModule} from './reset-password/reset-password.module';
import {AuthenticationService} from "./authentication.service";

@NgModule({
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    ForgotPasswordModule,
    LockModule,
    MailConfirmModule,
    RegisterModule,
    ResetPasswordModule
  ],
  declarations: [],
  providers: [AuthenticationService]
})
export class AuthenticationModule { }
