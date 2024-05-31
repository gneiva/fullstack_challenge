import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, catchError, map, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  //TODO RETURN FALSE / JUST TO TEST
  private isAuthenticated = false;
  private apiUrl = 'http://localhost:8080/api/v1/auth';

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string): Observable<boolean> {
    return this.http.post<{ token: string, type: string, expiresIn: number }>(`${this.apiUrl}`, { username, password })
      .pipe(
        map(response => {
          console.log(response);
          this.isAuthenticated = true;
          localStorage.setItem('authToken', response.token);
          this.router.navigate(['/products']);
          return this.isAuthenticated;
        }),
        catchError(() => of(false))
      );
  }

  logout() {
    this.isAuthenticated = false;
    localStorage.removeItem('authToken');
    this.router.navigate(['/login']);
  }

  get isLoggedIn(): boolean {
    return !!localStorage.getItem('authToken');;
  }

  getAuthToken(): string | null {
    return localStorage.getItem('authToken');
  }
}
