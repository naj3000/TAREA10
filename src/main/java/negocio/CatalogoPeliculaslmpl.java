/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.AccesoDatosAdiclmpl;
import datos.AccesoDatoslmpl;
import datos.ClsPeliculasJDBC;
import dominio.PeliculaAmpliado;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */

public class CatalogoPeliculaslmpl implements CatalogoPeliculas{


//    private final IAccesoDatos datos;
    private final datos.AccesoDatosAdiclmpl datos;
    private final ClsPeliculasJDBC pelis;

    public CatalogoPeliculaslmpl(){
//        this.datos= new AccesoDatosImpl(); 
        this.datos = new AccesoDatosAdiclmpl();
        this.pelis = new ClsPeliculasJDBC();
        
    }
    
   
    
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {
//        Pelicula pelicula = new Pelicula(nombrePelicula);
//        
//        boolean anexar = false;
//        
//        try {
//            
//            anexar = datos.existe(nombreArchivo);
//            datos.escribir(pelicula, nombreArchivo, anexar);
//           
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error al acceder al archivo");
//        }

        PeliculaAmpliado peli = new PeliculaAmpliado(nombrePelicula, nombreArchivo);
        pelis.insert(peli);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            
            List<PeliculaAmpliado> peli= datos.seleccion();
            for (PeliculaAmpliado peliculas: peli) {
            System.out.println("Pelicula: "+ peliculas);
            
        }
           
//            List<Pelicula> peliculas = datos.listar(nombreArchivo);
//            
//            System.out.println("===== Listar Peliculas =====");
//            for (Pelicula peli : peliculas) {               
//                System.out.println("Peli: "+ peli);              
//            }
        } catch (Exception e) {
            System.out.println("Clavos con el acceso a datos");
        }
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
//        String resultado= "No se encontro";
//        try {
//            
//            resultado = datos.Buscar(nombreArchivo, buscar);
//            
//            
//        } catch (Exception e) {
//            System.out.println("Error al buscar la peli");
//        }
//        System.out.println("Resultado: "+ resultado);

        PeliculaAmpliado peli = new PeliculaAmpliado(nombreArchivo, buscar);
        pelis.actualizar(peli);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
    
//        try {
//            if (datos.existe(nombreArchivo)) {
//                //Si existe se borra el archivo
//                datos.borrar(nombreArchivo);
//                
//            }else{
//                //Si no existe crea el archivo
//                datos.crear(nombreArchivo);
//            }
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error de acceso datos");
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa nombre de la Pelicula");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa año de produccion");
        String fproduccion = scanner.nextLine();
        
       PeliculaAmpliado peli = new PeliculaAmpliado(nombre, fproduccion);
       pelis.borrar(peli);

    }

    @Override
    public void ListarPeliculas(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}