/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Config;

import java.sql.SQLException;
import Com.Config.MyConfig;
import model.Produk;
//import com.models.Produk;
/**
 *
 * @author SUSANTI
 */
public class DbController extends MyConfig{
     public static void getDatabase() {
        connection();
        try {
            query = "SELECT NAME, PRICE, STOCK FROM tb_produk";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(
                    String.format("%s - Rp.%d - Stok %d", resultSet.getString("NAME"), resultSet.getInt("PRICE"), resultSet.getInt("STOCK"))
                );
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Produk getProdukByNama(String name) {
        Produk produk = null;
        connection();
        query = "SELECT * FROM tb_produk WHERE NAME=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getLong("PRICE"), resultSet.getInt("STOCK"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }

    public static boolean insertData(String name, long price, int stock) {
        connection();
        query = "INSERT INTO tb_produk (NAME, PRICE, STOCK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, price);
            preparedStatement.setInt(3, stock);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateNama(int id, String name) {
        connection();
        query = "UPDATE tb_produk SET NAME=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePrice(int id, long price) {
        connection();
        query = "UPDATE tb_produk SET PRICE=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStok(int id, int stock) {
        connection();
        query = "UPDATE tb_produk SET STOCK=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(String name) {
        connection();
        query = "DELETE FROM tb_produk WHERE NAME=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            int affectedRowDelete = preparedStatement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


