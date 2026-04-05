package database;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

// Open/Closed Principle
// Dependency Inversion Principle
/// Interface for adding new Database Implementation without modify Dependency Injection Code
public interface Database {
    void closeConnection();

    void createTo_komentar(String id_user, String isi_komentar, LocalDate tgl_dibuat);
    void updateTo_komentar(String id_komentar, String isi_komentar, LocalDate tgl_modified);
    void deleteTo_komentar(String id_komentar);

    Map<String, Object> getOneComment(String id_komentar);
    List<Map<String, Object>> getAllComment();
    
}

// TODO: Create MySQL schema in ./database/schema/init.sql
