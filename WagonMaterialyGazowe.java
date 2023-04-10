public class WagonMaterialyGazowe extends WagonTowarowyPodstawowy{
    private double maxCisnieniePa;
    private double uciekanieGazu;

    public WagonMaterialyGazowe(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, int coIleSerwis, double maxCisnieniePa, double uciekanieGazu) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, coIleSerwis);
        this.maxCisnieniePa = maxCisnieniePa;
        this.uciekanieGazu = uciekanieGazu;
    }
}
