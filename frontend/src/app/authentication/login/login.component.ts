import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {fuseAnimations} from '../../core/animations';
import {FuseConfigService} from '../../core/services/config.service';
import {AuthenticationService} from "../authentication.service";
import {Router} from "@angular/router";

@Component({
    selector   : 'fuse-login',
    templateUrl: './login.component.html',
    styleUrls  : ['./login.component.scss'],
    animations : fuseAnimations
})
export class FuseLoginComponent implements OnInit
{
    loginForm: FormGroup;
    loginFormErrors: any;
    errorMsg: string;
    constructor(
        private fuseConfig: FuseConfigService,
        private formBuilder: FormBuilder,
        private authenticationService: AuthenticationService,
        private router: Router
    )
    {
        this.fuseConfig.setSettings({
            layout: {
                navigation: 'none',
                toolbar   : 'none',
                footer    : 'none'
            }
        });

        this.loginFormErrors = {
            email   : {},
            password: {}
        };
    }

    ngOnInit()
    {
        this.loginForm = this.formBuilder.group({
            email   : ['', [Validators.required, Validators.email]],
            password: ['', Validators.required]
        });

        this.loginForm.valueChanges.subscribe(() => {
            this.onLoginFormValuesChanged();
        });
    }

    onLoginFormValuesChanged()
    {
        for ( const field in this.loginFormErrors )
        {
            if ( !this.loginFormErrors.hasOwnProperty(field) )
            {
                continue;
            }

            // Clear previous errors
            this.loginFormErrors[field] = {};

            // Get the control
            const control = this.loginForm.get(field);

            if ( control && control.dirty && !control.valid )
            {
                this.loginFormErrors[field] = control.errors;
            }
        }
    }

    onSubmit(value) {
      this.authenticationService.login(value.email, value.password).subscribe(
        response => {
          if(response.status === 200) {
            this.router.navigate(['/home']);
          } else {
            this.errorMsg = response.messages[0];
          }
        }, error=> {
            this.errorMsg = error;
        }
      )
    }
}
