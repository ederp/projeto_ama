import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Token } from './auth.token';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isAuthenticated = new BehaviorSubject<boolean>(false);
  isAuthenticated$ = this.isAuthenticated.asObservable();
  private token: Token = new Token;

  constructor(private http: HttpClient, private router: Router) { }

  login(body: any) {
    this.http.post<any>("http://localhost:8080/auth/token", body)
      .subscribe((data) => {
        this.token.accessToken = data.accessToken;
        this.token.refreshToken = data.refreshToken;
        this.token.tokenType = data.tokenType;
        this.isAuthenticated.next(true);
      });
    return this.isLoggedIn();
  }

  isLoggedIn(): Observable<boolean> {
    return this.isAuthenticated$;
  }

  logout() {
    this.isAuthenticated.next(false);
  }

  authToken(): Token{
    return this.token;
  }
}
