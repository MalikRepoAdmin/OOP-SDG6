package entity;

public class KategoriSungai extends Sungai implements KategoriInterface { // child class 1

    @Override
    public void debitAir() {
        System.out.println("Debit Air Sungai : " + getDebit());
    }

    @Override
    public void sumberAir() {
        System.out.println("Sumber Air Sungai : " + getSumber());
    }

}
