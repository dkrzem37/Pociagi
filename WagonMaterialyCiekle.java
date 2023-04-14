public class WagonMaterialyCiekle  extends WagonTowarowyPodstawowy{
    private int parowanieCieczy;
    private int pojemnoscNaPaliwo;

    public WagonMaterialyCiekle(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, int coIleSerwis, int parowanieCieczy, int pojemnosc1) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, coIleSerwis);
        this.parowanieCieczy = parowanieCieczy;
        this.pojemnoscNaPaliwo = pojemnosc1;
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Ciekle: " +
                "parowanie cieczy: " + parowanieCieczy +
                ", pojemnosc: " + pojemnoscNaPaliwo +
                '.';
    }
}
