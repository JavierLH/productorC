/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.ConexionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class Productor {
    
    private int ID;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String telefono;
    private String cargo;
    private String password;

    

    
    public Productor(){
        
    }
    
    public Productor(int ID, String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String cargo, String password) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Productor> getProductor(){
        Connection con = ConexionSingleton.getInstance();
        ArrayList<Productor> listaClintes = new ArrayList<>();
        try {
            //(2) Crear un objeto statement
            Statement st = (Statement) con.createStatement();
            // (3) crear un String de mi consulta
            String consulta = "SELECT * FROM `Productor`";
            // (4) Crear un ResultSet
            ResultSet rs = st.executeQuery(consulta);
            // (5) Recorres el resultSet
            while (rs.next()) {
                Productor datosProductor = new Productor();
                datosProductor.setID(rs.getInt("iD"));
                datosProductor.setNombre(rs.getString("Nombre"));
                datosProductor.setApellidoM(rs.getString("ApellidoM"));
                datosProductor.setApellidoP(rs.getString("ApellidoP"));
                datosProductor.setCargo(rs.getString("Cargo"));
                datosProductor.setTelefono(rs.getString("Telefono"));
                datosProductor.setDireccion(rs.getString("Direccion"));
                datosProductor.setPassword(rs.getString("Password"));
                listaClintes.add(datosProductor);
                //nombreClientes.addItem(rs.getString(consulta));

            }
            // (6) 

            rs.close();

        } catch (SQLException e) {

            System.out.println(e);

        }

        
        return listaClintes;
        
    }
    
    
    
}
