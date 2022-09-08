import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    public formulario!: FormGroup;

    constructor(private form: FormBuilder, private router: Router) { }

    ngOnInit() {
        this.configurarFormulario();
        console.log(this.validarSessao() != null)
        if(this.validarSessao() != null) {
            this.getCampo('lembrarUsuario').setValue(true);
            this.validarSessao().tipoUsuario == 1 
                ? this.getCampo('email').setValue(this.validarSessao().usuario)
                : this.getCampo('matricula').setValue(this.validarSessao().usuario);
            this.getCampo('radioButton').setValue(this.validarSessao().tipoUsuario)  
        } else {
            this.getCampo('radioButton').setValue("1")  
        }
    }

    configurarFormulario(): void {
        this.formulario = this.form.group({
            radioButton: new FormControl(1, Validators.required),
            email: new FormControl(null, [Validators.required, Validators.email]),
            matricula: new FormControl(null, Validators.compose(
                                    [
                                        Validators.required, 
                                        Validators.minLength(3),
                                        Validators.maxLength(3),
                                    ])),
            senha: new FormControl(null, Validators.required),
            lembrarUsuario: new FormControl(false)
        })
    }

    getCampo(campo: string): AbstractControl {
        return this.formulario?.get(campo) as FormGroup;
    }

    validarFormulario(): boolean {
        return ((this.getCampo('email').valid || (this.getCampo('matricula').valid)) && this.getCampo('senha').valid)
    }

    validarSessao() {
        return JSON.parse(sessionStorage.getItem('login')!);
    }

    salvarSessao() {
        if(this.getCampo('radioButton').value == 1) {
            sessionStorage.setItem('login', JSON.stringify({"usuario": this.getCampo('email').value, "tipoUsuario": "1"}))
        }
        else {
            sessionStorage.setItem('login', JSON.stringify({"usuario": this.getCampo('matricula').value, "tipoUsuario": "2"}))
        }
    }

    login(): void {
       if(!this.validarFormulario()) {
            return;
       }
       if(this.getCampo('lembrarUsuario').value) {
            this.salvarSessao();
       }
    }

    telaCadastro(): void {
        this.router.navigate(['cadastro-cliente'])
    }
}
