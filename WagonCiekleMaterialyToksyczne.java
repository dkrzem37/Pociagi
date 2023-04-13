public class WagonCiekleMaterialyToksyczne extends WagonTowarowyCiezki{
    private double parowanieCieczy;
    private int maxCzasNaSloncu;
    private int warstwaOchronnaMetalu;

    public WagonCiekleMaterialyToksyczne(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, boolean przykryty, double parowanieCieczy, int maxCzasNaSloncu, int warstwaOchronnaMetalu) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, przykryty);
        this.parowanieCieczy = parowanieCieczy;
        this.maxCzasNaSloncu = maxCzasNaSloncu;
        this.warstwaOchronnaMetalu = warstwaOchronnaMetalu;
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Ciekle Materialy Toksyczne: " +
                "parowanie cieczy=" + parowanieCieczy +
                ", maksymalny czas na sloncu: " + maxCzasNaSloncu +
                ", warstwa ochronna metalu: " + warstwaOchronnaMetalu +
                '.';
    }
}
