public class WagonMaterialyCiekle  extends WagonTowarowyPodstawowy{
    private int parowanieCieczy;
    private int pojemnosc;

    public WagonMaterialyCiekle(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, int coIleSerwis, int parowanieCieczy, int pojemnosc1) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, coIleSerwis);
        this.parowanieCieczy = parowanieCieczy;
        this.pojemnosc = pojemnosc1;
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Ciekle: " +
                "parowanie cieczy: " + parowanieCieczy +
                ", pojemnosc: " + pojemnosc +
                '.';
    }
}
