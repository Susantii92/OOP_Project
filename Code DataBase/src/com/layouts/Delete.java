package com.layouts;

import java.util.Scanner;
import com.controllers.DbController;

public class Delete {
    public static void showDeleteData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(11)+"Silahkan Pilih Data yang Ingin Dihapus"+" ".repeat(10));
        System.out.println("=".repeat(60));
        DbController.getDatabase();
        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(15)+"Input nama produk dengan benar!!"+" ".repeat(8));
        System.out.println("=".repeat(60));
        System.out.print("Pilih Nama Produk: ");
        String nama = sc.nextLine();
        System.out.println("=".repeat(60));

        if (DbController.deleteData(nama)) {
            System.out.println("=".repeat(60));
            System.out.println("Berhasil Delete Data");
        } else {
            System.out.println("=".repeat(60));
            System.out.println("Gagal Delete Data");
        }

        System.out.println("*".repeat(60));
        Menu.showMenu();
        sc.close();
    }
}
