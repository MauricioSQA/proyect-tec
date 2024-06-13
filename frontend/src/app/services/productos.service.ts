import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Productos } from '../models/producto';
import { Observable } from 'rxjs';
import { Empresa } from '../models/empresa';

const BASIC_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root',
})
export class ProductosService {
  constructor(private http: HttpClient) {}

  create(productos: Productos): Observable<Productos> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<Productos>(`${BASIC_URL}/api/productos`, productos, {
      headers,
    });
  }

  eliminar(id: number): Observable<Productos> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete<Productos>(`${BASIC_URL}/api/productos/${id}`, {
      headers,
    });
  }

  findById(id: number): Observable<Productos> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Productos>(`${BASIC_URL}/api/productos/${id}`, {
      headers,
    });
  }

  update(id: number, productos: Productos): Observable<Productos> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<Productos>(`${BASIC_URL}/api/productos/${id}`, productos, {
      headers,
    });
  }

  findAll(): Observable<Productos[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Productos[]>(`${BASIC_URL}/api/productos`, { headers });
  }

  findAllByEmpresa(id:number):Observable<Productos[]>{
    const token = localStorage.getItem('token');
    const headers =  new HttpHeaders().set('Authorization',`Bearer ${token}`);
    return this.http.get<Productos[]>(`${BASIC_URL}/api/productos/empresa/${id}`,{headers});
  }
}
