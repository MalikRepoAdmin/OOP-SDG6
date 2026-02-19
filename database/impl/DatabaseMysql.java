package database.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.Database;


//TODO: Modify query based on mysql database schema we will create
/// Class untuk initialisasi Database MySQL
public class DatabaseMysql implements Database{
    private static Connection DB_CONNECTION = null;


    // Constructor
    public DatabaseMysql(String DB_URL, String DB_USER, String DB_PASSWORD) {
        try {
            DB_CONNECTION = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            DB_CONNECTION.setAutoCommit(false);
            System.out.println("Connection to DB Established Successfully");
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    private void executeDML(PreparedStatement pStatement){
        try {
                pStatement.executeUpdate();
                DB_CONNECTION.commit();
            } catch (Exception e){
                try {
                    DB_CONNECTION.rollback();
                } catch (SQLException sqlex){
                    System.err.println(e);
                    e.printStackTrace();
                }
                System.err.println(e);
                e.printStackTrace();
            }
    }

    @Override
    public void closeConnection(){
        try {
            DB_CONNECTION.close();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (NullPointerException nilex){
            // Do Nothing...
        }
    }

    @Override
    public void createTo_komentar(String id_user, String isi_komentar, LocalDate tgl_dibuat){
        String query = """
                INSERT INTO tbl_komentar (id_user, isi_komentar, tgl_dibuat) 
                VALUES (?,?,?);
                """;
        
        PreparedStatement pStatement;

        try {
            pStatement = DB_CONNECTION.prepareStatement(query);
            pStatement.setString(1, id_user);
            pStatement.setString(2, isi_komentar);
            pStatement.setObject(3, tgl_dibuat);

            executeDML(pStatement);
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void updateTo_komentar(String id_komentar, String isi_komentar, LocalDate tgl_modified){
        String query = """
                UPDATE tbl_komentar 
                SET isi_komentar = ?, 
                tgl_modified = ? 
                WHERE id_komentar = ?;
                """;
        
        PreparedStatement pStatement;

        try {
            pStatement = DB_CONNECTION.prepareStatement(query);
            pStatement.setString(1, isi_komentar);
            pStatement.setObject(2, tgl_modified);
            pStatement.setString(3, id_komentar);

            executeDML(pStatement);
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTo_komentar(String id_komentar){
        String query = """
                DELETE FROM tbl_komentar 
                WHERE id_komentar = ?;
                """;
        
        PreparedStatement pStatement;

        try {
            pStatement = DB_CONNECTION.prepareStatement(query);
            pStatement.setString(1, id_komentar);

            executeDML(pStatement);
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Object> getOneComment(String id_komentar){
        String query = """
                SELECT (id_komentar, id_user, isi_komentar, tgl_dibuat, tgl_modified)
                FROM tbl_komentar
                WHERE id_komentar = ?;
                """;

        PreparedStatement pStatement;
        Map<String, Object> resultMap = null;

        try {
            pStatement = DB_CONNECTION.prepareStatement(query);
            pStatement.setString(1, id_komentar);

            ResultSet resultSet = pStatement.executeQuery();

            if (resultSet.next()){
                resultMap = new HashMap<>();

                resultMap.put("id_komentar", resultSet.getInt("id_komentar"));
                resultMap.put("id_user", resultSet.getString("id_user"));
                resultMap.put("isi_komentar", resultSet.getString("isi_komentar"));
                resultMap.put("tgl_dibuat", resultSet.getObject("tgl_dibuat"));
                resultMap.put("tgl_modified", resultSet.getObject("tgl_modified"));
            }
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }

        return resultMap;
    }

    @Override
    public List<Map<String, Object>> getAllComment(){
        String query = """
                SELECT (id_komentar, id_user, isi_komentar, tgl_dibuat, tgl_modified)
                FROM tbl_komentar;
                """;

        PreparedStatement pStatement;
        List<Map<String, Object>> resultMap = new ArrayList<>();

        try {
            pStatement = DB_CONNECTION.prepareStatement(query);

            ResultSet resultSet = pStatement.executeQuery();

            while (resultSet.next()){
                Map<String, Object> rows = new HashMap<>();

                rows.put("id_komentar", resultSet.getInt("id_komentar"));
                rows.put("id_user", resultSet.getString("id_user"));
                rows.put("isi_komentar", resultSet.getString("isi_komentar"));
                rows.put("tgl_dibuat", resultSet.getObject("tgl_dibuat"));
                rows.put("tgl_modified", resultSet.getObject("tgl_modified"));
                resultMap.add(rows);
            }
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }

        return resultMap;
    }
    
}
