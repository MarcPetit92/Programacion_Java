/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 1001489.joan23
 */
public class Alumno {
    
        private Integer alu_id;
        
        private String alu_nombre;
        
        private String alu_apellido;
        
        private Integer alu_edad;
        
        private String alu_email;

    public Alumno(Integer alu_id, String alu_nombre, String alu_apellido, Integer alu_edad, String alu_email) {
        this.alu_id = alu_id;
        this.alu_nombre = alu_nombre;
        this.alu_apellido = alu_apellido;
        this.alu_edad = alu_edad;
        this.alu_email = alu_email;
    }

    public Alumno() {
    }

    public Integer getAlu_id() {
        return alu_id;
    }

    public String getAlu_nombre() {
        return alu_nombre;
    }

    public String getAlu_apellido() {
        return alu_apellido;
    }

    public Integer getAlu_edad() {
        return alu_edad;
    }

    public String getAlu_email() {
        return alu_email;
    }

    public void setAlu_id(Integer alu_id) {
        this.alu_id = alu_id;
    }

    public void setAlu_nombre(String alu_nombre) {
        this.alu_nombre = alu_nombre;
    }

    public void setAlu_apellido(String alu_apellido) {
        this.alu_apellido = alu_apellido;
    }

    public void setAlu_edad(Integer alu_edad) {
        this.alu_edad = alu_edad;
    }

    public void setAlu_email(String alu_email) {
        this.alu_email = alu_email;
    }
        
        
        
        
}
