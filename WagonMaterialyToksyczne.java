public class WagonMaterialyToksyczne extends WagonTowarowyCiezki{
    enum MaterialObudowy{PC, PP, LPDE, HDPE};
    private MaterialObudowy material;
    private int iloscPojemnikow;

    public WagonMaterialyToksyczne(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, boolean przykryty, MaterialObudowy material, int iloscPojemnikow) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, przykryty);
        this.material = material;
        this.iloscPojemnikow = iloscPojemnikow;
    }

    public static void stworzMaterialyToksyczne() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc: ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0,2000, "Zla pojemnosc. (0 - 2000)");

        System.out.println("Czy wagon jest przykryty? : ");
        boolean przykryty = Funkcje.wyborBoolean();

        System.out.println("Wybierz material obudowy: ");
        System.out.println("1. PC. ");
        System.out.println("2. PP. ");
        System.out.println("3. LPDE. ");
        System.out.println("4. HDPE. ");
        int wybor = Funkcje.sprawdzCzyPoprawnyInt(1, 4, "Wybierz poprawna opcje. ");
        WagonMaterialyToksyczne.MaterialObudowy materialObudowy = switch (wybor) {
            case 1 -> MaterialObudowy.PC;
            case 2 -> MaterialObudowy.PP;
            case 3 -> MaterialObudowy.LPDE;
            case 4 -> MaterialObudowy.HDPE;
            default -> MaterialObudowy.PC;
        };
        System.out.println("Podaj ilosc pojemnikow (0 - 25) : ");
        int iloscPojemnikow = Funkcje.sprawdzCzyPoprawnyInt(0,25, "Zla ilosc. )");
        Wagon wagon = new WagonMaterialyToksyczne(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, pojemnosc, przykryty, materialObudowy, iloscPojemnikow);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Toksyczne: " +
                "material: " + material +
                ", ilosc pojemnikow: " + iloscPojemnikow +
                '.';
    }
}
