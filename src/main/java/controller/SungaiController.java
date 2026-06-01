package controller;

import services.SungaiService;
import entity.Sungai;
import java.util.List;

public class SungaiController {

    private SungaiService sungaiService;

    public SungaiController() {
        sungaiService = new SungaiService();
    }

    public void tambahSungai(Sungai sungai) {
        sungaiService.create(sungai);
    }

    public List<Sungai> getAllSungai() {
        return sungaiService.getAll();
    }

    public Sungai getSungaiById(int id) {
        return sungaiService.getById(id);
    }

    public boolean updateSungai(int id, Sungai sungai) {
        return sungaiService.update(id, sungai);
    }

    public boolean deleteSungai(int id) {
        return sungaiService.delete(id);
    }
}