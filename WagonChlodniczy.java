import java.util.Scanner;

public class WagonChlodniczy extends WagonTowarowyPodstawowy{
    private double minTemp;
    enum Chlodzenie{WIATRAK, ELEKTRYCZNIE, CIECZ}
    private Chlodzenie systemChlodzacy;
    public WagonChlodniczy() {
        setWymagaElektr(true);
    }

    public WagonChlodniczy(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, int coIleSerwis, double minTemp, Chlodzenie systemChlodzacy) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, coIleSerwis);
        this.minTemp = minTemp;
        this.systemChlodzacy = systemChlodzacy;
    }

    public static void stworzWagonBagazowoPocztowy() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];
        boolean wymagaElektr = false;
        System.out.println("Podaj minimalna temperature. ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0,1000, "Zla pojemnosc. (0 - 1000)");

        System.out.println("Podaj minimalna temperature. ");
        int coIleSerwis = Funkcje.sprawdzCzyPoprawnyInt(0,200, "Zly numer (0 - 200)");

        System.out.println("Podaj minimalna temperature. ");
        double minTemp = Funkcje.sprawdzCzyPoprawnyDouble(-300,100, "Zla temperatura. (-300 - 100)");

        System.out.println("Wybierz chlodzenie: ");
        System.out.println("1. Wiatrak. ");
        System.out.println("2. Elektrycznie. ");
        System.out.println("3. Ciecz. ");
        int wybor = Funkcje.sprawdzCzyPoprawnyInt(1, 3, "Wybierz poprawna opcje. ");
        Chlodzenie chlodzenie = switch (wybor) {
            case 1 -> Chlodzenie.WIATRAK;
            case 2 -> Chlodzenie.ELEKTRYCZNIE;
            case 3 -> Chlodzenie.CIECZ;
            default -> Chlodzenie.WIATRAK;
        };
        Wagon wagon = new WagonChlodniczy(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, coIleSerwis, minTemp, chlodzenie);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }
}
