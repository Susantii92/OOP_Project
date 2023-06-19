package com.layouts;

import java.util.Scanner;
import com.controllers.DbController;

public class Read {
    public static void showReadData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(25)+"Data Produk"+ " ".repeat(12));
        System.out.println("=".repeat(60));
        DbController.getDatabase();
        System.out.println("=".repeat(60));

        System.out.println("1. Menu");
        System.out.println("2. Exit");
        System.out.print("Pilihan: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    Menu.showMenu();
                    break;
                case 2:
                    System.out.println("*".repeat(60));
                    System.out.println(" ".repeat(24)+"Thank You !!!"+" ".repeat(12));
                    System.out.println("*".repeat(60));
                    System.exit(0);
                default:
                    System.out.println("*".repeat(60));
                    System.out.println(" "+"Menu Yang di Pilih Tidak ada"+" ");
                    System.out.println("*".repeat(60));
                    Menu.showMenu();
                    System.exit(0);
                    break;
            }
        } catch (Exception e) {
            System.out.println("*".repeat(60));
            System.out.println(" ".repeat(4)+"Maaf Inputan Error"+" ".repeat(4));
            System.out.println("*".repeat(60));
            System.exit(0);
        }

        System.out.println("*".repeat(60));
        Menu.showMenu();

        sc.close();
    }
}

