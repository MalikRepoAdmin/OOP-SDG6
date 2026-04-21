package entity;

public class StatusSungai extends Sungai implements Statusinterface {

    private double ph;

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getPh() {
        return ph;
    }

    @Override
    public void kualitasAir() {
        if (ph < 7) {
            System.out.println("Kualitas Air Sungai : Asam");
        } else if (ph == 7) {
            System.out.println("Kualitas Air Sungai : Netral");
        } else {
            System.out.println("Kualitas Air Sungai : Basa");
        }
    }
}
