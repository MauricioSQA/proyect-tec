import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  /*   usernameValid = '';
  passwordValid = ''; */

  username: string = '';
  password: string = '';
  nombre:  string = '';
  error: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  /*  onSubmit(): void {
    this.authService.login(this.username, this.password).subscribe({
      next: () => {
        Swal.fire({
          title: 'Usuario autenticado',
          text: 'Bienvenido ' + this.username,
          icon: 'success',
        });
        this.router.navigate(['/home']);
        console.log('Token de acceso : ' + this.authService.getToken());
      },
      error: () => {
        Swal.fire({
          title: 'Credenciales inválidas',
          text: 'Verifique sus credenciales',
          icon: 'error',
        });
        this.error = 'Credenciales inválidas';
      },
    });
  } */
  onSubmit(): void {
    this.authService.login(this.username, this.password).subscribe({
      next: () => {
        Swal.fire({
          title: 'Usuario autenticado',
          text: 'Bienvenido ' + this.nombre,
          icon: 'success',
        });
        this.router.navigate(['/home']);
        console.log('Token de acceso : ' + this.authService.getToken());
      },
      error: () => {
        Swal.fire({
          title: 'Credenciales inválidas',
          text: 'Verifique sus credenciales',
          icon: 'error',
        });
      },
    });
  }
}
