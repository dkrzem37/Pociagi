public class WagonMaterialyGazowe extends WagonTowarowyPodstawowy{
    private double maxCisnieniePa;
    private double uciekanieGazu;

    public WagonMaterialyGazowe(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, int coIleSerwis, double maxCisnieniePa, double uciekanieGazu) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, coIleSerwis);
        this.maxCisnieniePa = maxCisnieniePa;
        this.uciekanieGazu = uciekanieGazu;
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Gazowe: " +
                "maksymalne cisnienie: " + maxCisnieniePa +
                ", uciekanie gazu: " + uciekanieGazu +
                '.';
    }
}
