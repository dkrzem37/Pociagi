public class WagonRestauracyjny extends Wagon{
    enum Rodzaj{BAR, RESTAURACJA}
    private Rodzaj rodzaj;
    private int iloscStolikow;


    public WagonRestauracyjny(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, Rodzaj rodzaj, int iloscStolikow) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, true);
        this.rodzaj = rodzaj;
        this.iloscStolikow = iloscStolikow;
    }

    public static void stworzRestauracyjny() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Wybierz rodzaj: ");
        System.out.println("1. Bar. ");
        System.out.println("2. Restauracja. ");
        int wybor = Funkcje.sprawdzCzyPoprawnyInt(1, 2, "Wybierz poprawna opcje. ");
        WagonRestauracyjny.Rodzaj rodzaj = switch (wybor) {
            case 1 -> Rodzaj.BAR;
            case 2 -> Rodzaj.RESTAURACJA;
            default -> Rodzaj.BAR;
        };
        System.out.println("Podaj ilosc stolikow: ");
        int iloscStolikow = Funkcje.sprawdzCzyPoprawnyInt(0,20, "Zlilosc stolikow. (0 - 20)");
        Wagon wagon = new WagonRestauracyjny(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, rodzaj, iloscStolikow);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return "WagonRestauracyjny: " + super.toString() +
                "rodzaj: " + rodzaj +
                ", iloscStolikow: " + iloscStolikow +
                '.';
    }
}
