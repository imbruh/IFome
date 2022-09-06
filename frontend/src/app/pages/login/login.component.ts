import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    public formulario!: FormGroup;

    constructor(private form: FormBuilder) { }

    ngOnInit() {
    }

    configurarFormulario(): void {
        this.formulario = this.form.group({
            email: new FormControl("", [Validators.required, Validators.email]),
            senha: new FormControl(null, Validators.required)
        })
    }

    getCampo(campo: string) {
        return this.formulario.get(campo)?.value;
    }

}
