/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Conexion;
import modelo.Producto;

/**
 *
 * @author Usuario
 */
public class ControllerFactura {

    public ControllerFactura() {
    }

    public void rutinaCrearCliente(Cliente c){
    
        Conexion conecControl = new Conexion();
        Connection cn = conecControl.conectar();
        //llamar a una rutina creada en la base de datos
        try {
            CallableStatement llamar = cn.prepareCall("{call spcrearCliente(?,?)}");
            
            llamar.setString(1, "david");
            llamar.setString(2, "656565415");
            
        } catch (SQLException ex) {
           
        }
        
        
    }
    
    public void anadirProductoCliente(Producto p, Cliente c) {
        Conexion conecControl = new Conexion();
        Connection cn = conecControl.conectar();
        //crear la consulta, los ? smulan  las variables
        String sql1 = "INSERT INTO tbl_producto (pro_nom, pro_precio, pro_stock) VALUES (?,?,?)";
        String sql2 = "INSERT INTO tbl_cliente (cli_NIF, cli_nom) VALUES (?,?)";
        //pasar parametros a la consulta
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;

        try {
            //cuando esta en false ejecuta los 2 sql como si fuera una sola sentencia
            cn.setAutoCommit(false);
            //se podran instertar cosas
            pst1 = cn.prepareStatement(sql1);
            //montar tabla para insertar en la BBDD
            pst1.setString(1, p.getPro_nom());
            pst1.setDouble(2, p.getPro_precio());
            pst1.setString(3, p.getPro_stock());

            pst2 = cn.prepareStatement(sql2);
            //montar tabla para insertar en la BBDD
            pst2.setString(1, c.getCli_NIF());
            pst2.setString(2, c.getCli_nom());

            int n2 = pst2.executeUpdate();

            int n1 = pst1.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "UPPS! no se ha podido conectar a la base de datos");
            try {
                //si no se ha ejecutado algun de los dos sql, este comando deshace la unica sentencia sql
                cn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ControllerFactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    public void anadirProducto(Producto p) {
        Conexion conecControl = new Conexion();
        Connection cn = conecControl.conectar();
        //crear la consulta, los ? smulan  las variables
        String sql = "INSERT INTO tbl_producto (pro_nom, pro_precio, pro_stock) VALUES (?,?,?)";
        //pasar parametros a la consulta
        PreparedStatement pst = null;
        try {
            //se podran instertar cosas
            pst = cn.prepareStatement(sql);
            //montar tabla para insertar en la BBDD
            pst.setString(1, p.getPro_nom());
            pst.setDouble(2, p.getPro_precio());
            pst.setString(3, p.getPro_stock());
            //ejecutar la consulta del pst prepared statement
            //el executeUpdate devuelve un int, si funciona devuelve 1, si no, 0
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Enhorabuena! se ha insertado un nuevo registro.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido insertar el registro.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "UPPS! no se ha podido conectar a la base de datos");
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión");
            }
        }

    }

    public void nuevoCliente(Cliente c) {
        Conexion conecControl = new Conexion();
        Connection cn = conecControl.conectar();
        //crear la consulta, los ? smulan  las variables
        String sql = "INSERT INTO tbl_cliente (cli_NIF, cli_nom) VALUES (?,?)";
        //pasar parametros a la consulta
        PreparedStatement pst = null;
        try {
            //se podran instertar cosas
            pst = cn.prepareStatement(sql);
            //montar tabla para insertar en la BBDD
            pst.setString(1, c.getCli_NIF());
            pst.setString(2, c.getCli_nom());
            //ejecutar la consulta del pst prepared statement
            //el executeUpdate devuelve un int, si funciona devuelve 1, si no, 0
            int n = pst.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Enhorabuena! se ha insertado un nuevo registro.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido insertar el registro.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "UPPS! no se ha podido conectar a la base de datos");
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión");
            }
        }
    }

}
