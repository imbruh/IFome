import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarEmpresaComponent } from './pages/empresa/cadastrar-empresa/cadastrarEmpresa.component';
import { CadastrarClienteComponent } from './pages/cliente/cadastrar-cliente/cadastrar-cliente.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: "cadastro-cliente",
        component: CadastrarClienteComponent
    },
    {
        path: "cadastro-funcionario",
        component: CadastrarClienteComponent
    },
    {
        path:"cadastro-empresa",
        component:CadastrarEmpresaComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
