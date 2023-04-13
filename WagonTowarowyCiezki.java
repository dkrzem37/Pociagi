import java.util.Scanner;

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

    public static void stworzWagonTowarowyCiezki() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc wagonu (0 - 2000l): ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0, 2000,"Niepoprawna przepuszczalnosc. (0 - 2000)");

        System.out.println("Czy wagon jest przykryty? : ");
        boolean przykryty = Funkcje.wyborBoolean();

        Wagon wagon = new WagonTowarowyCiezki(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, przykryty);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return  "WagonTowarowyCiezki: " +
                super.toString() +
                "pojemnosc: " + pojemnosc +
                ", przykryty: " + przykryty +
                "  ";
    }
}
