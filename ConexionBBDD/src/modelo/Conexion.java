/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 1001489.joan23
 */
public class Conexion {
    
    public String bbdd = "bd_java_alumnos";
    
    //la url siempre tiene que tener el driver que utiliza jdbc 
    //y luego el tipo de driver de la bbdd que atacara.
    //si el puerto no es el por defecto hay que añadir con //3306
    public String url = "jdbc:mysql://localhost:3306/" + bbdd;
    
    public String user = "root";
    
    public String pass = "";
    
    //funcion para realizar la conexion con la bbdd, realiza el puente entre el programa y mysql
    public Connection conectar(){
        //los obtejos de tipo connection nos permiten crear los statement
                   //hay que indicar la ruta donde está mi driver
                   
                   Connection conexion = null;
                   
                   //primer paso establecer la conexion o puente
                  try {
                      //primero indicamos donde está el driver(la ruta del driver)
                      Class.forName("org.gjt.mm.mysql.Driver");
                      //ahora este driver es el driver manager nos devolvera un valor connection 
                   conexion = DriverManager.getConnection(url, user, pass);
                      System.out.println("conexion establecida con exito");
                      
        } catch (  ClassNotFoundException | SQLException e) {
                      System.out.println("Conexion erronea");
                      System.out.println(e);
        }finally{
                      //hay que añadirlo siempre
                      return conexion; 
                  }
                   
                   
                   
        
       
    }
}
