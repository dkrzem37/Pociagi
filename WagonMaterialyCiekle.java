public class WagonMaterialyCiekle  extends WagonTowarowyPodstawowy{
    private double parowanieCieczy;
    private double pojemnoscNaPaliwo;

    public WagonMaterialyCiekle(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, int coIleSerwis, double parowanieCieczy, double pojemnoscNaPaliwo) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, coIleSerwis);
        this.parowanieCieczy = parowanieCieczy;
        this.pojemnoscNaPaliwo = pojemnoscNaPaliwo;
    }

    public static void stworzMaterialyCiekle() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc: ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0,2000, "Zla pojemnosc. (0 - 2000)");

        System.out.println("Podaj sugerowany okres miedzy serwisem: ");
        int coIleSerwis = Funkcje.sprawdzCzyPoprawnyInt(0,200, "Zly czas (0 - 200)");

        System.out.println("Podaj stala parowania cieczy (0 - 100): ");
        double parowanieCieczy = Funkcje.sprawdzCzyPoprawnyDouble(0,100, "Zla stala. (0 - 100)");

        System.out.println("Podaj pojemnosc baku na paliwo (0 - 40000): ");
        double pojemnoscNaPaliwo = Funkcje.sprawdzCzyPoprawnyDouble(0,40000, "Zla pojemnosca. (0 - 40000)");

        Wagon wagon = new WagonMaterialyCiekle(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, pojemnosc, coIleSerwis, parowanieCieczy, pojemnoscNaPaliwo);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Ciekle: " +
                "parowanie cieczy: " + parowanieCieczy +
                ", pojemnosc: " + pojemnoscNaPaliwo +
                '.';
    }
}
