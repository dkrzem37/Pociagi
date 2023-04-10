import java.util.Scanner;

public class WagonBagazowoPocztowy extends Wagon{
    private boolean mozliwoscPrzewozuZwierzat;
    private String firmaOdpowiedzialna;

    public WagonBagazowoPocztowy(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, boolean mozliwoscPrzewozuZwierzat, String firmaOdpowiedzialna) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr);
        this.mozliwoscPrzewozuZwierzat = mozliwoscPrzewozuZwierzat;
        this.firmaOdpowiedzialna = firmaOdpowiedzialna;
    }

    public static void stworzWagonBagazowoPocztowy() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];
        boolean wymagaElektr = false;
        System.out.println("Czy istnieje mozliwosc przewozu zwierzat? ");
        boolean mozliwoscPrzewozuZwierzat = Funkcje.wyborBoolean();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe firmy odpowiedzialnej za poczte: ");
        String firmaOdp = scanner.nextLine();

        Wagon wagon = new WagonBagazowoPocztowy(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, mozliwoscPrzewozuZwierzat, firmaOdp);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }
}
