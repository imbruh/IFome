import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteModule } from './cliente/cliente.module';
import { EmpresaModule } from './empresa/empresa.module';
import { LoginComponent } from './login/login.component';

import {MatCardModule} from '@angular/material/card';
import {MatRadioModule} from '@angular/material/radio';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { CadastrarClienteComponent } from './cliente/cadastrar-cliente/cadastrar-cliente.component';

@NgModule({
  imports: [
    CommonModule,
    ClienteModule,
    EmpresaModule,

    FormsModule,
    ReactiveFormsModule,

    MatCardModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatButtonModule,
    MatCheckboxModule
  ],
  declarations: [LoginComponent]
})
export class PagesModule { }
