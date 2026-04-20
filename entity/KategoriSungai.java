package entity;

public class KategoriSungai extends Sungai implements Detailkategori { // child class 1

    private String debit;
    private String sumber;

    @Override
    public void debitSungai() {
        System.out.println("Debit Sungai : " + debit);
    }

    @Override
    public void sumberSungai() {
        System.out.println("Sumber Sungai : " + sumber);
    }
}
