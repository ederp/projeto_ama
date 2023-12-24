import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutes } from './app.routes';
import { AppComponent } from './app.component';
import { ProdutoListComponent } from './produtos/produtos-list/produtos-list.component';
import { CreateProdutoComponent } from './produtos/create-produtos/create-produtos.component';
import { FormsModule } from '@angular/forms';
import { UpdateProdutoComponent } from './produtos/update-produtos/update-produtos.component';
import { ProdutoDetailsComponent } from './produtos/produtos-details/produtos-details.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    ProdutoListComponent,
    CreateProdutoComponent,
    UpdateProdutoComponent,
    ProdutoDetailsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutes,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
