import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteModule } from './cliente/cliente.module';
import { EmpresaModule } from './empresa/empresa.module';

@NgModule({
  imports: [
    CommonModule,
    ClienteModule,
    EmpresaModule
  ],
  declarations: []
})
export class PagesModule { }
