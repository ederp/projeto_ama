import { NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  mensagem!: string;
  
  constructor(private router: Router, private auth: AuthService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }

  login() {
    const loginSuccess = this.auth.login(this.loginForm.value);
    this.mensagem = loginSuccess ? "Login feito com sucesso!" : "E-mail ou a senha está errado!";
    if (loginSuccess) {
      this.loginForm.reset;
      this.router.navigate(['produtos']);
    }
  }
}
