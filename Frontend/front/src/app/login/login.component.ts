import { NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormsModule, ReactiveFormsModule, } from '@angular/forms';

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

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      usuario: new FormControl('', Validators.required),
      senha: new FormControl('', Validators.required)
    });
  }

  login() {
    if (this.loginForm.valid) {
      this.mensagem = "Login feito com sucesso!";
    } else {
      this.mensagem = "E-mail ou a senha estar errado!";
    }
  }
}
