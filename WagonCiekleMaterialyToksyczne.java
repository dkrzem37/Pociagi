public class WagonCiekleMaterialyToksyczne extends WagonTowarowyCiezki{
    private double parowanieCieczy;
    private double pojemnosc;
    private int maxCzasNaSloncu;
    private int warstwaOchronnaMetalu;

    public WagonCiekleMaterialyToksyczne(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, boolean przykryty, double parowanieCieczy, double pojemnosc1, int maxCzasNaSloncu, int warstwaOchronnaMetalu) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, przykryty);
        this.parowanieCieczy = parowanieCieczy;
        this.pojemnosc = pojemnosc1;
        this.maxCzasNaSloncu = maxCzasNaSloncu;
        this.warstwaOchronnaMetalu = warstwaOchronnaMetalu;
    }
}
