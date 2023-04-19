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

    public static void stworzCiekleMatToksyczne() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc: ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0,2000, "Zla pojemnosc. (0 - 2000)");

        System.out.println("Czy wagon jest przykryty? : ");
        boolean przykryty = Funkcje.wyborBoolean();

        System.out.println("Podaj stala parowania cieczy (0 - 100): ");
        double parowanieCieczy = Funkcje.sprawdzCzyPoprawnyDouble(0,100, "Zla stala. (0 - 100)");

        System.out.println("Podaj maksymalny czas wagonu na sloncu w godzinach (0 - 1000): ");
        int maxCzasNaSloncu = Funkcje.sprawdzCzyPoprawnyInt(0,1000, "Zly czas (0 - 1000)");

        System.out.println("Podaj grubosc warstwy ochronnej z metalu (0 - 200mm): ");
        int warstwaOchronnaMetalu = Funkcje.sprawdzCzyPoprawnyInt(0,200, "Zla grubosc (0 - 200)");

        Wagon wagon = new WagonCiekleMaterialyToksyczne(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, pojemnosc, przykryty, parowanieCieczy, maxCzasNaSloncu,warstwaOchronnaMetalu);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
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
