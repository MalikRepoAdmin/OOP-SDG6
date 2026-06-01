package controller;

import services.SungaiService;
import model.Sungai;
import java.util.List;

public class SungaiController {

    private SungaiService sungaiService;

    public SungaiController() {
        sungaiService = new SungaiService();
    }

    public void tambahSungai(Sungai sungai) {
        sungaiService.tambahSungai(sungai);
    }

    public List<Sungai> getAllSungai() {
        return sungaiService.getAllSungai();
    }

    public Sungai getSungaiById(int id) {
        return sungaiService.getSungaiById(id);
    }

    public boolean updateSungai(int id, Sungai sungai) {
        return sungaiService.updateSungai(id, sungai);
    }

    public boolean deleteSungai(int id) {
        return sungaiService.deleteSungai(id);
    }
}