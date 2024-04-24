package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMysql {
    private Connection connect;
    private final String driverName = "com.mysql.jdbc.Driver"; //Driver untuk koneksi ke mysql
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:"; //bisa menggunakan ip kita
    private String port = "3306/"; //port ini port mysql
    private String database = "crud256"; //ini database yang akan digunakan
    private String url = jdbc + host + port + database;
    private String username = "root"; // username default mysql
    private String password = "";
    public Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class Driver Ditemukan");
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi databse gagal : " + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver tidak ditemukan, Terjadi kesalahan pada : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
}
