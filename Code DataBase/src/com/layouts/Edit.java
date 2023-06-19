package com.layouts;

import java.util.Scanner;
import com.controllers.DbController;
import com.models.Produk;

public class Edit {
    public static void showEditData(String name) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(15)+"Pilih Data yang Ingin Diedit"+" ".repeat(15));
        System.out.println("=".repeat(60));
        DbController.getDatabase();
        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(24)+"Input Nama Produk"+" ".repeat(10));
        System.out.println("=".repeat(60));
        System.out.print("Pilih Nama Produk :");
        name = sc.nextLine();

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(11)+"Silahkan Pilih Menu Yang Akan di Update"+" ".repeat(10));
        System.out.println("=".repeat(60));
        System.out.println("1. Update Name");
        System.out.println("2. Update Price");
        System.out.println("3. Update Stock");
        System.out.println("4. Back to Menu");

        System.out.println("=".repeat(60));
        System.out.print("Pilihan : ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    showEditNama(name);
                    break;
                case 2:
                    showEditHarga(name);
                    break;
                case 3:
                    showEditJumlah(name);
                    break;
                case 4:
                    Menu.showMenu();
                    break;
                default:
                    System.out.println("=".repeat(60));
                    System.out.println(" ".repeat(15)+"Maaf Produk Yang diPilih Kosong"+" ".repeat(10));
                    System.out.println("=".repeat(60));
                    Menu.showMenu();
            }
        } catch (Exception e) {
            System.out.println("=".repeat(60));
            System.out.println(" ".repeat(15)+"Maaf Produk Yang diPilih Kosong"+" ".repeat(10));
            System.out.println("=".repeat(60));
            Menu.showMenu();
        }
        System.out.println("*".repeat(60));
        Menu.showMenu();
        sc.close();
    }

    public static void showEditNama(String name) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(name);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(28)+"Edit Nama"+" ".repeat(10));
        System.out.println("=".repeat(60));
        System.out.println("Nama Awal\t:" + produk.getname());
        System.out.println("=".repeat(60));
        System.out.print("Nama Baru\t:");
        String namaBaru = sc.nextLine();
        DbController.updateNama(produk.getId(), namaBaru);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(20)+"Berhasil Update Data Nama"+" ".repeat(10));
        System.out.println("=".repeat(60));
        Menu.showMenu();
        sc.close();
    }

    public static void showEditHarga(String name) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(name);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(28)+"Edit Nama"+" ".repeat(10));
        System.out.println("=".repeat(60));
        System.out.println("Harga Awal\t:" + produk.getprice());
        System.out.println("=".repeat(60));
        System.out.print("Harga Baru\t:");
        long hargaBaru = sc.nextLong();
        DbController.updatePrice(produk.getId(), hargaBaru);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(20)+"Berhasil Update Data Harga"+" ".repeat(10));
        System.out.println("=".repeat(60));
        Menu.showMenu();
        sc.close();
    }

    public static void showEditJumlah(String name) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(name);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(28)+"Edit Nama"+" ".repeat(10));
        System.out.println("=".repeat(60));
        System.out.println("Jumlah Awal\t:" + produk.getstock());
        System.out.println("=".repeat(60));
        System.out.print("Jumlah Baru\t:");
        int jumlahBaru = sc.nextInt();
        DbController.updateStok(produk.getId(), jumlahBaru);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(18)+"Berhasil Update Data Stok"+" ".repeat(11));
        System.out.println("=".repeat(60));
        Menu.showMenu();
        sc.close();
    }
}

