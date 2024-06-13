import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, map, tap, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth';

  /* New Implementation */
  authChanged = new EventEmitter<Boolean>();

  constructor(private http?: HttpClient, private router?: Router) {}

  login(username: string, password: string): Observable<any> {
    if (!this.http) {
      throw new Error('Http client no inicializado');
    }
    return this.http
      ?.post<any>(`${this.baseUrl}/login`, { username, password })
      ?.pipe(
        tap((response) => {
          console.log('Respuesta del servidor : ', response);
        }),
        map((response) => {
          if (response && response.token) {
            localStorage.setItem('token', response.token);
            /* New Implementation */
            this.authChanged.emit(true);
            return response;
          } else {
            throw new Error(
              'No se recibió un token de acceso válido en la respuesta del servidor'
            );
          }
        }),
        catchError((error) => {
          console.log('Error en la solicitud', error);
          return throwError(() => error);
        })
      );
  }

  register(username: string, password: string): Observable<any> {
    if (!this.http) {
      throw new Error('Http client no inicializado');
    }
    return this.http
      ?.post<any>(`${this.baseUrl}/registro`, { username, password })
      ?.pipe(catchError(this.handleError));
  }

  registere(username:string, password:string):Observable<any>{
    if(!this.http){
      throw new Error('Http client no inicializado');
    }
    return this.http
      ?.post<any>(`${this.baseUrl}/registroe`,{username,password})
      ?.pipe(catchError(this.handleError));
      }

  logout() {
    localStorage.removeItem('token');
    /* New Implementation */
    this.authChanged.emit(false);
    this.router?.navigate(['/login']);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    return !!token;
  }

  handleError(error: any) {
    console.error('Error en la solicitud : ', error);
    return throwError(() => error);
  }
}
