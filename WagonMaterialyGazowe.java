public class WagonMaterialyGazowe extends WagonTowarowyPodstawowy{
    private double maxCisnieniePa;
    private double uciekanieGazu;

    public WagonMaterialyGazowe(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, int coIleSerwis, double maxCisnieniePa, double uciekanieGazu) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, coIleSerwis);
        this.maxCisnieniePa = maxCisnieniePa;
        this.uciekanieGazu = uciekanieGazu;
    }

    public static void stworzMaterialyGazowe() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc: ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0,2000, "Zla pojemnosc. (0 - 2000)");

        System.out.println("Podaj sugerowany okres miedzy serwisem: ");
        int coIleSerwis = Funkcje.sprawdzCzyPoprawnyInt(0,200, "Zly czas (0 - 200)");

        System.out.println("Podaj maksymalne cisnienie (0 - 30000 Pa): ");
        double maxCisnienie = Funkcje.sprawdzCzyPoprawnyDouble(-300,100, "Zle cisnienie. (0 - 30000)");

        System.out.println("Podaj stala uciekania gazu: ");
        double uciekanieGazu = Funkcje.sprawdzCzyPoprawnyDouble(0,1000, "Zla stala. (0 - 1000)");

        Wagon wagon = new WagonMaterialyGazowe(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, pojemnosc, coIleSerwis, maxCisnienie, uciekanieGazu);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Gazowe: " +
                "maksymalne cisnienie: " + maxCisnieniePa +
                ", uciekanie gazu: " + uciekanieGazu +
                '.';
    }
}
