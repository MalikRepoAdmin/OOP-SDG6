package entity;

public class KategoriSungai extends Sungai implements KategoriInterface { // child class 1

    private double ph;

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getPh() {
        return ph;
    }

    @Override
    public void sumberAir() {
        switch (getSumber()) {
            case "hujan":
                setKategori("kategori A");
                break;
            case "pegunungan":
                setKategori("kategori B");
                break;
            case "laut":
                setKategori("kategori C");
                break;
            case "danau":
                setKategori("kategori D");
                break;

            default:
                System.out.println("Sumber Air Sungai : Tidak diketahui");
        }
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
