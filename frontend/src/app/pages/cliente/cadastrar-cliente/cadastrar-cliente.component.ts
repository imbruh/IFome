import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cadastrar-cliente',
  templateUrl: './cadastrar-cliente.component.html',
  styleUrls: ['./cadastrar-cliente.component.scss']
})
export class CadastrarClienteComponent implements OnInit {

    public formulario!: FormGroup;
    public ehFuncionario: boolean = false;

    constructor(private form: FormBuilder, private rotaAtual: ActivatedRoute) {
        if(this.rotaAtual.snapshot.url[0].path === 'cadastro-funcionario') {
            this.ehFuncionario = true;
        }
    }

    ngOnInit() {
        this.configurarFormulario()
        if(this.ehFuncionario) {
            this.getCampo('senha').disable();
            this.getCampo('matricula').disable();
            this.getCampo('nome').disable();
            this.getCampo('telefone').disable();
            this.getCampo('dataNascimento').disable();
            this.getCampo('cep').disable();
            this.getCampo('rua').disable();
            this.getCampo('bairro').disable();
            this.getCampo('numero').disable();
            this.getCampo('cidade').disable();
            this.getCampo('estado').disable();
            this.getCampo('complemento').disable();
        }        
    }

    configurarFormulario(): void {
        this.formulario = this.form.group ({
            nome: new FormControl('', Validators.required),
            dataNascimento: new FormControl('', Validators.required),
            cpf: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(14), Validators.minLength(14)])),
            telefone: new FormControl('', Validators.required),
            cep: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(8), Validators.minLength(8)])), 
            rua: new FormControl('', Validators.required),
            bairro: new FormControl('', Validators.required),
            numero: new FormControl('', Validators.required),
            cidade: new FormControl('', Validators.required),
            estado: new FormControl('', Validators.required),
            complemento: new FormControl(''),
            email: new FormControl('', [Validators.required, Validators.email]),
            matricula: new FormControl('', Validators.required),
            senha: new FormControl('', Validators.required),
            confirmacaoSenha: new FormControl('', Validators.compose([Validators.required]))
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

    pesquisarPorCpf() { 
        if(this.getCampo('cpf').valid) {
            //Adicionar a função de busca de um usuario pelo cpf e colocar
            //esses codigos abaixo no subscribe
           this.getCampo('nome').enable();
           this.getCampo('dataNascimento').enable();
           this.getCampo('telefone').enable();
           this.getCampo('endereco').enable();
        }
    }

    pesquisarPorCep() {
       fetch(`https://viacep.com.br/ws/${this.getCampo('cep').value}/json/`)
                        .then(res => res.json())
                        .then(json => this.setarEndereco(json));
    }

    setarEndereco(endereco: any) {
        this.getCampo('bairro').setValue(endereco.bairro);
        this.getCampo('rua').setValue(endereco.logradouro);
        this.getCampo('cidade').setValue(endereco.localidade);
        this.getCampo('estado').setValue(endereco.uf);
    }

    passwordMatch() {
        if(this.getCampo('senha').value !== this.getCampo('confirmacaoSenha').value) {
            this.getCampo('confirmacaoSenha').setErrors({noMatchPassword: true})
        }
        else{
            this.getCampo('confirmacaoSenha').updateValueAndValidity();
        }
    }

    cadastrar() { 
        this.passwordMatch();
        this.formulario.valid;
    }
    
}
