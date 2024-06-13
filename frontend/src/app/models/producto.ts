import { Empresa } from "./empresa";

export interface Productos{
    id?: number;
    nombre: string;
    descripcion: string;
    precioOriginal: string;
    precioOferta: string;
    cant_disponible: string;
    empresa? : Empresa;
}