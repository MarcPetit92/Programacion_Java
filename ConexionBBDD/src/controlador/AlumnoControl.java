/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Conexion;

/**
 *
 * @author 1001489.joan23
 */
//1 driver manager
//2 establecer conexion
//3 ejecutar sentencia sql con un objeto statem
//4 leer el resultado de sql (objeto tipo presteatmen)
public class AlumnoControl {

    Conexion conexion = new Conexion();

    Connection miConexion = conexion.conectar();

    //esta funcion recupera los datos del resulset y los añade a la array list
    public ArrayList<Alumno> mostrarAlumno()  {

        //primero paso hacer la conexion a la base de datos
        Conexion conex = new Conexion();

        Connection cn = conex.conectar();
        String SQL = "SELECT * FROM tbl_alumnos";

        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

        try {
            //segundo paso crear el objeto de tipo statement
            Statement st = cn.createStatement();
            //este objeto permite realizar las consultas sql
            //tercer paso lanzar la consulta
            ResultSet rs = st.executeQuery(SQL);

            
            while (rs.next()) {
                //cuarto y quinto paso recorrer el resulset y leer los datos mientras se guardan en la arraylist
                Alumno al = new Alumno();
                al.setAlu_id(rs.getInt("alu_id"));
                al.setAlu_nombre(rs.getString("alu_nombre"));
                al.setAlu_apellido(rs.getString("alu_apellido"));
                al.setAlu_email(rs.getString("alu_email"));
                al.setAlu_edad(rs.getInt("alu_edad"));
                listaAlumnos.add(al);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se ha realizado correctamente la consulta");
        } finally {
           
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoControl.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
return listaAlumnos;
    }

}
