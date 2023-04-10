public class WagonTowarowyPodstawowy extends Wagon{
    private double pojemnosc;
    private int coIleSerwis;
    public WagonTowarowyPodstawowy() {
        super.setWymagaElektr(false);
    }

    public WagonTowarowyPodstawowy(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, int coIleSerwis) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr);
        this.pojemnosc = pojemnosc;
        this.coIleSerwis = coIleSerwis;
    }
}
