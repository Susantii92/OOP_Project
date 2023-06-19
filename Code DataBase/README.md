# src
Terdapat beberapa package pada src, yaitu :
1. com
2. App.java

## App.java
App.java terdapat di dalam folder src, dimana didalam file App.java itu sendiri terdapat 7 line code yang terdiri dari:
- import com.layouts.Menu 
-> ini tujuannya agar dapat menggunakan class Menu  di class App.

- public class App
-> Terdapat class App yang didalamnya terdapat method main yang menerima argumen bertipe String[] args. Method main ini merupakan titik awal eksekusi program java.

- Menu.showMenu():
-> Ini tujuannya memanggil methode showMenu() dari kelas Menu,nantinya program akan menampilkan menu pada saat dijalankan.

## Com
Terdapat beberapa package yaitu :
1. config
2. controllers
3. layouts
4. models

## 1. config
   MyConfig.java
- import java.sql.Connection; , import java.sql.DriverManager; , import java.sql.PreparedStatement; , import java.sql.ResultSet; dan import java.   sql.SQLException;
    Mengimpor kelas-kelas(Connection, DriverManager, PreparedStatement, ResultSet, dan SQLException) untuk mengakses dan mengelola DataBase.
- public class MyConfig
    Kode ini bertujuan untuk mendefinisikan kelas MyConfig, yang bertindak sebagai konfigurasi untuk mengakses database.
- private static final String DB_URL
    Bertujuan untuk menghubungkan kedatabase, di sini URL JDBC yang di gunakan adalah "jdbc:mysql://localhost:3306/produk"
- private static final String DB_USER 
    Gunanya untuk mengautentikasi koneksi ke database, di sini nama pengguna adalah "root".
- private static final String DB_PASS 
    Variabel ini berisi password yang akan digunakan untuk mengautentikasi koneksi ke database. Di dalam kode ini password kosong (" ").
- Variabel terkait dengan DataBase
    Yang dimaksud adalah connection (objek Connection untuk mengelola koneksi), preparedStatement (objek PreparedStatement untuk mengeksekusi pernyataan SQL yang telah diprepare sebelumnya), resultSet (objek ResultSet yang berisi hasil dari kueri database), dan query (string yang berisi pernyataan SQL yang akan dieksekusi).
- Method Connection
    Tujuannya untuk membuat koneksi ke DataBase menggunakan informasi yang diberikan dalam variabel konfigurasi. Di sini terdapat try catch(pengecualian), jika koneksi berhasil, pesan "Data Base Connected Success" akan dicetak ke konsol. Jika terjadi kesalahan, pengecualian SQLException akan dicetak. 

## 2. controllers
    DbController.java

- Terdapat class DbController yang merupakan turunan dari kelas MyConfig.
- Terdapat method getDatabase dan memanggil metode connection() dari class MyConfig. 
- Eksekusi query 
    Disini terdapat kode yang berfungsi untuk menjalankan query SQL, di kode query nya adalah "SELECT NAME, PRICE, STOCK FROM tb_produk", yang akan mengambil kolom NAME, PRICE, dan STOCK dari tabel tb_produk.
- Pemrosesan Hasil 
    Hasilnya diproses dalam loop while(resultSet.next()).
- Penutupan Pernyataan
    Setelah semua baris hasil diproses, pernyataan (preparedStatement) ditutup dengan memanggil metode close().
-  catch (SQLException e) {
            e.printStackTrace();
        }
    Kode ini berfungsi untuk menangani pengecualian.
- public static Produk getProdukByNama(String name)
    Method ini menerima parameter name yang merupakan nama produk dan mengembalikan objek Produk. Didalam kode ini terdapat objek produk dan menginisialisasinya dengan null.
- public static boolean insertData(String name, long price, int stock)
    Method ini menerima parameter name, price, dan stock untuk memasukkan data produk baru ke dalam database. Lalu Mengatur nilai parameter pada pernyataan menggunakan:
    preparedStatement.setString(), preparedStatement.setLong(), dan preparedStatement.setInt().
- public static void updateNama(int id, String name)
    Method ini menerima parameter id dan name untuk mengupdate nama produk dalam database berdasarkan ID.
- public static void updatePrice(int id, long price)
    Method ini menerima parameter id dan price untuk mengupdate harga produk dalam database berdasarkan ID. Metode ini melakukan langkah-langkah serupa dengan updateNama(), tetapi dengan query SQL yang berbeda untuk mengubah kolom PRICE.
- public static void updateStok(int id, int stock)
    Method ini menerima parameter id dan stock untuk mengupdate stok produk dalam database berdasarkan ID. Metode ini melakukan langkah-langkah serupa dengan updateNama(),
- public static boolean deleteData(String name)
   Ini merupakan method static yang berfungsi untuk menghapus data produk dari database berdasarkan nama.

## 3. layouts
1. Delete.java
    Kode pada class Delete ini berfungsi untuk menampilkan pilihan data yang ingin dihapus, menghapus data tersebut menggunakan metode deleteData(nama) dari DbController, dan menampilkan pesan berhasil atau gagal setelah penghapusan data dilakukan. Setelah itu, kembali menampilkan menu atau pilihan kepada pengguna. Di kode ini juga memiliki satu method static showDeleteData().
2. Edit.java
    Edit.java merupakan sebuah class Java dengan nama Edit yang memiliki beberapa method static untuk mengedit data. Terdapat method showEditData(String name) digunakan untuk menampilkan menu edit data dan melakukan pengeditan data sesuai pilihan pengguna. Kode menggunakan pernyataan switch untuk mengevaluasi selectMenu:
    Jika selectMenu bernilai 1, maka metode showEditNama(name) akan dipanggil untuk mengedit nama produk.
    Jika selectMenu bernilai 2, maka metode showEditHarga(name) akan dipanggil untuk mengedit harga produk.
    Jika selectMenu bernilai 3, maka metode showEditJumlah(name) akan dipanggil untuk mengedit jumlah stok produk.
    Jika selectMenu bernilai 4, maka metode showMenu() dari kelas Menu akan dipanggil untuk kembali ke menu utama.
3. Insert.java
    Terdapat class Insert yang memiliki satu method static showInsertData().  Pengguna di minta untuk memasukkan semua data produk. 
    - if (DbController.insertData(name, harga, stok))
    System.out.println("Berhasil Insert Data");
    Kode memanggil metode insertData(name, harga, stok) dari kelas DbController untuk menyisipkan data produk ke dalam database. Jika true maka akan mengeluarkan output "Berhasil Insert Data""
    - else {
            System.out.println("Gagal Insert Data");
    } 
    jika false artinya penyisipan data gagal, maka kode mencetak pesan "Gagal Insert Data".
4. Menu.java
    - Method showMenu(): Method ini digunakan untuk menampilkan menu utama kepada pengguna.
    - public static void selectMenu() {
        Scanner sc = new Scanner(System.in); }
      Method ini digunakan untuk memproses pilihan menu yang dipilih pengguna dan membuat objek Scanner untuk membaca input dari pengguna.
    - Menggunakan blok try-catch untuk menangani kesalahan yang terjadi saat membaca input pengguna.

    Intinya  kelas Menu digunakan untuk menampilkan menu utama kepada pengguna, memproses pilihan menu yang dipilih, dan memanggil metode yang sesuai dari kelas Read, Insert, Edit, atau Delete berdasarkan pilihan menu pengguna.
5. Read.java
   - public static void showReadData()
     Method ini digunakan untuk menampilkan data produk dan memberikan opsi kepada pengguna untuk kembali ke menu utama atau keluar dari program.
   - Menggunakan blok try-catch(pengecualian), membaca input pengguna dengan sc.nextInt() dan menyimpannya dalam variabel dan menyimpannya di selectMenu. 
    Dengan demikian, kelas Read digunakan untuk menampilkan data produk dan memberikan opsi kepada pengguna untuk kembali ke menu utama atau keluar dari program.

## 4. models
1. Produk.java
    private int id;
    private String name;
    private long price;
    private int stock;
    Pada class Produk terdapat 4 atribut bersifat private yaitu id dan stock bertipe data integer, name dengan tipe data String, price dengan tipe data long.

    public Produk(int id, String name, long price, int stock ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    Membuat konstruktor yang digunakan untuk membuat objek Produk baru dengan memberikan nilai awal untuk setiap properti. Selanjutnya kita membuat setter(mengatur nilai) dan getter(mengembalikan) dari atribut-atributnya.


The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
