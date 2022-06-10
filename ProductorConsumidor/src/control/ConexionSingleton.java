/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author macbook
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSingleton {
    
    private static Connection con = null;
   
    
    
    private ConexionSingleton(){
        
    }
    
    public static Connection getInstance(){
        if(con==null){
            
            try{
                String URL="jdbc:mysql://localhost:8889/BDProductorConsumidor";
                String USER="root";
                String PASSWORD="root";
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexion exitosa "+con);
            
            } catch(Exception e){
             System.out.println(e);
            }
        }
        return con;   
    }   
}