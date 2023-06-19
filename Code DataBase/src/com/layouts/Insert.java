package com.layouts;

import java.util.Scanner;
import com.controllers.DbController;

public class Insert {
    public static void showInsertData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(60));
        System.out.println("Silahkan Input Data Produk");
        System.out.println("=".repeat(60));

        System.out.print("Name Produk\t:");
        String name = sc.nextLine();
        System.out.print("Price\t\t:");
        long harga = sc.nextLong();
        System.out.print("Stock\t\t:");
        int stok = sc.nextInt();
        System.out.println("=".repeat(60));

        if (DbController.insertData(name, harga, stok)) {
            System.out.println("Berhasil Insert Data");
        } else {
            System.out.println("Gagal Insert Data");
        }

        System.out.println("*".repeat(60));
        Menu.showMenu();
        sc.close();
    }
}
