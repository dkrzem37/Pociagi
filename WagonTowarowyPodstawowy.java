public class WagonTowarowyPodstawowy extends Wagon{
    private double pojemnosc;
    private int coIleSerwis;

    public WagonTowarowyPodstawowy(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, int coIleSerwis) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr);
        this.pojemnosc = pojemnosc;
        this.coIleSerwis = coIleSerwis;
    }

    public static void stworzWagonTowarowyPodstawowy() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc wagonu (0 - 2000l): ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0, 2000,"Niepoprawna przepuszczalnosc. (0 - 2000)");

        System.out.println("Co ile miesiecy jest potrzebny serwis? : ");
        int coIleSerwis = Funkcje.sprawdzCzyPoprawnyInt(0, 200, "Niepoprawny okres. (0 - 200)");

        Wagon wagon = new WagonTowarowyPodstawowy(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, coIleSerwis);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return "WagonTowarowyPodstawowy: " +
                super.toString() +
                "pojemnosc: " + pojemnosc +
                ", zalecane okresy miedzy serwisami: " + coIleSerwis +
                " ";
    }
}
