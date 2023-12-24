import { NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, NgIf, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  mensagem!: string;

  accessToken!: string;
  refreshToken!: string;
  tokenType!: string;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }

  login() {
    this.http.post<any>("http://localhost:8080/auth/token", this.loginForm.value)
      .subscribe((data) => {
        //accessToken: data.accessToken;
        //refreshToken: data.refreshToken;
        //tokenType: data.tokenType;
        this.mensagem = "Login feito com sucesso!";
        this.loginForm.reset;
      },
        (error) => {
          //console.log(error);
          this.mensagem = "E-mail ou a senha está errado!";
      });
  }
}
