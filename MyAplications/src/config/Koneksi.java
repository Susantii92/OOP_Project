/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import config.MyConfig;
import java.sql.Connection;

/**
 *
 * @author SUSANTI
 */
public class Koneksi {
    MyConfig Con = new MyConfig();
    Connection MyConfig = Con.getConnect();
}
