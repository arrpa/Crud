package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiPostgresql {
    private Connection connect;
    private String driverName = "org.postgresql.Driver"; //Driver untuk koneksi ke postgresql
    private String jdbc = "jdbc:postgresql://";
    private String host = "localhost:"; //bisa menggunakan ip kita
    private String port = "5432/"; //port ini port mysql
    private String database = "crud256"; //ini database yang akan digunakan
    private String url = jdbc + host + port + database;
    private String username = "postgres"; //
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
