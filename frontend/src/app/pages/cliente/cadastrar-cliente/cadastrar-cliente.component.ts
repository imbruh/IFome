import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastrar-cliente',
  templateUrl: './cadastrar-cliente.component.html',
  styleUrls: ['./cadastrar-cliente.component.scss']
})
export class CadastrarClienteComponent implements OnInit {

    public formulario!: FormGroup;

    constructor(private form: FormBuilder) { }

    ngOnInit() {
        this.configurarFormulario()
    }

    configurarFormulario(): void {
        this.formulario = this.form.group ({
            nome: new FormControl(null, Validators.required),
            dataNascimento: new FormControl('', Validators.required),
            cpf: new FormControl(null, Validators.required),
            telefone: new FormControl(null, Validators.required),
            endereco: new FormControl(null, Validators.required), 
            email: new FormControl(null, [Validators.required, Validators.email]),
            senha: new FormControl(null, Validators.required),
            confirmacaoSenha: new FormControl(null, Validators.required)
        })
    }

    getCampo(campo: string): AbstractControl {
        return this.formulario.get(campo) as FormGroup;
    }

    mascaraDataNascimento(){
        if (this.getCampo('dataNascimento').value.length == 2 || this.getCampo('dataNascimento').value.length == 5){
            this.getCampo('dataNascimento').setValue(this.getCampo('dataNascimento').value + "/");
        }
    } 

    mascaraCpf() {
        if (this.getCampo('cpf').value.length == 3 || this.getCampo('cpf').value.length == 7){
            this.getCampo('cpf').setValue(this.getCampo('cpf').value + ".");
        }else if (this.getCampo('cpf').value.length == 11){
            this.getCampo('cpf').setValue(this.getCampo('cpf').value + "-");
        }
    }

    cadastrar() {

    }
    
}
