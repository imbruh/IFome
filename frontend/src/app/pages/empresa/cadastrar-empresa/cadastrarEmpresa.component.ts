import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-cadastrarEmpresa',
    templateUrl: './cadastrarEmpresa.component.html',
    styleUrls: ['./cadastrarEmpresa.component.scss']
})
export class CadastrarEmpresaComponent implements OnInit {
    
    public categorias!: String[];

    public formulario!: FormGroup;

    constructor(private form: FormBuilder) { }

    ngOnInit() {
        this.configurarFormulario();
        // CONSULTAR LISTA DE CATEGORIAS DO BACK
        this.categorias = ["Restaurante","Lanche","Bebida"];
    }

    configurarFormulario() {
        this.formulario = this.form.group({
            nome: new FormControl(null, [Validators.required]),
            cnpj: new FormControl("", Validators.compose(
                [
                    Validators.required,
                    Validators.minLength(18),
                    Validators.maxLength(18)
                ])),
            categoria: new FormControl([], [Validators.required])
        })
    }
    
    getCampo(campo: string): AbstractControl {
        return this.formulario?.get(campo) as FormGroup;
    }

    validarFormulario(): boolean {
        return this.getCampo('nome').valid && this.getCampo('cnpj').valid && this.getCampo('categoria').valid
    }

    mascaraCNPJ() {
        if (this.getCampo("cnpj").value.length == 2 || this.getCampo("cnpj").value.length == 6 ) {
            this.getCampo("cnpj").setValue(this.getCampo("cnpj").value + ".")
        } else if (this.getCampo("cnpj").value.length == 10){
            this.getCampo("cnpj").setValue(this.getCampo("cnpj").value + "/")
        } else if (this.getCampo("cnpj").value.length == 15){
            this.getCampo("cnpj").setValue(this.getCampo("cnpj").value + "-")
        }
    }

    cadastrar() {
        if (!this.validarFormulario()) {
            window.alert("INVALIDO")
            return
        }
        // ENVIAR INFOMAÇÕES PARA O BACK
        window.alert(this.getCampo('categoria').value)
    }

}
