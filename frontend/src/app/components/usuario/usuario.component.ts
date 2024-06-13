import { Component } from '@angular/core';
import * as Aos from 'aos';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
})
export class UsuarioComponent {
  ngOnInit(): void {
    Aos.init();
  }
}
