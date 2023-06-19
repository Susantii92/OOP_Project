/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author SUSANTI
 */
public class MyConfig {
    private Connection Con;
    
    public Connection getConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            
        }
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/natalia_database","root","");
            if(Con != null){
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
        return Con;
    }
    
}
