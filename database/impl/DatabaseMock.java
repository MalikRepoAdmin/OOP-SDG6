package database.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.Database;

public class DatabaseMock implements Database{
    public static Map<Integer, HashMap<String, Object>> tbl_komentar = new HashMap<Integer, HashMap<String, Object>>();

    // String merepresentasikan Column
    public String id_komentar = "id_komentar";
    public String id_user = "id_user";
    public String isi_komentar = "isi_komentar";
    public String tgl_dibuat = "tgl_dibuat";
    public String tgl_modified = "tgl_modified";


    @Override
    @Deprecated
    /** 
    *@deprecated no need to close connection
    */
    public void closeConnection(){}

    @Override
    public void createTo_komentar(String id_user, String isi_komentar, LocalDate tgl_dibuat){
        Integer currentId = tbl_komentar.size();

        HashMap<String, Object> row = tbl_komentar.computeIfAbsent(currentId, k -> new HashMap<String, Object>());
        row.put(this.id_komentar, tbl_komentar.size());
        row.put(this.id_user, id_user);
        row.put(this.isi_komentar, isi_komentar);
        row.put(this.tgl_dibuat, tgl_dibuat);
        row.put(this.tgl_modified, null);
        
        tbl_komentar.put(Integer.valueOf(tbl_komentar.size()), row);

    }

    @Override
    public void updateTo_komentar(String id_komentar, String isi_komentar, LocalDate tgl_modified){
        tbl_komentar.computeIfPresent(Integer.valueOf(id_komentar), (key, columnMap) -> {
            columnMap.put(this.id_komentar, Integer.valueOf(id_komentar));
            columnMap.put(this.isi_komentar, isi_komentar);
            columnMap.put(this.tgl_modified, tgl_modified);

            return columnMap;
        });
    }

    @Override
    public void deleteTo_komentar(String id_komentar){
        tbl_komentar.remove(Integer.valueOf(id_komentar));
    }

    @Override
    public Map<String, Object> getOneComment(String id_komentar){
        return tbl_komentar.get(Integer.valueOf(id_komentar));
    }

    @Override
    public List<Map<String, Object>> getAllComment(){
        List<Map<String, Object>> commentList = new ArrayList<Map<String, Object>>();

        for (HashMap<String, Object> value : tbl_komentar.values()) {
            commentList.add(value);
        }

        return commentList;
    }
}
