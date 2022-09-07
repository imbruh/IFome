import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
