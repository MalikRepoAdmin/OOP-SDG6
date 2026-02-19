package database;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


/// Interface untuk menambah DBMS baru
public interface Database {
    void closeConnection();

    void createTo_komentar(String id_user, String isi_komentar, LocalDate tgl_dibuat);
    void updateTo_komentar(String id_komentar, String isi_komentar, LocalDate tgl_modified);
    void deleteTo_komentar(String id_komentar);

    Map<String, Object> getOneComment(String id_komentar);
    List<Map<String, Object>> getAllComment();
    
}

// TODO: Create MySQL schema in ./database/schema/init.sql
