public class WagonTowarowyCiezki extends Wagon{
    private double pojemnosc;
    private boolean przykryty;

    public WagonTowarowyCiezki() {

    }

    public WagonTowarowyCiezki(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, boolean przykryty) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr);
        this.pojemnosc = pojemnosc;
        this.przykryty = przykryty;
    }
}
