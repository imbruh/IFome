import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarEmpresaComponent } from './pages/empresa/cadastrar-empresa/cadastrarEmpresa.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
    {
        path: "login",
        component: LoginComponent
    },
    {
        path:"cadastrar-empresa",
        component:CadastrarEmpresaComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
