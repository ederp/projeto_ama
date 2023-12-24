import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutoListComponent } from './produtos/produtos-list/produtos-list.component';
import { CreateProdutoComponent } from './produtos/create-produtos/create-produtos.component';
import { UpdateProdutoComponent } from './produtos/update-produtos/update-produtos.component';
import { ProdutoDetailsComponent } from './produtos/produtos-details/produtos-details.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  { path: 'produtos', component: ProdutoListComponent },
  { path: 'create-produto', component: CreateProdutoComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'update-produto/:id', component: UpdateProdutoComponent },
  { path: 'produto-details/:id', component: ProdutoDetailsComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutes { }
