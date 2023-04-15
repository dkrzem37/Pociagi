public class WagonMaterialyWybuchowe extends WagonTowarowyCiezki{
    enum Obudowa{STAL, PIASEK, NICHROM, MAGNAL};
    private Obudowa obudowaOchronna;
    private double wyczulenieNaDrgania;

    public WagonMaterialyWybuchowe(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, boolean przykryty, Obudowa obudowaOchronna, double wyczulenieNaDrgania) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, przykryty);
        this.obudowaOchronna = obudowaOchronna;
        this.wyczulenieNaDrgania = wyczulenieNaDrgania;
    }

    public static void stworzMaterialyWybuchowe() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Podaj pojemnosc: ");
        double pojemnosc = Funkcje.sprawdzCzyPoprawnyDouble(0,2000, "Zla pojemnosc. (0 - 2000)");

        System.out.println("Czy wagon jest przykryty? : ");
        boolean przykryty = Funkcje.wyborBoolean();

        System.out.println("Wybierz obudowe: ");
        System.out.println("1. Stal. ");
        System.out.println("2. Piasek. ");
        System.out.println("3. Nichrom. ");
        System.out.println("4. Magnal. ");
        int wybor = Funkcje.sprawdzCzyPoprawnyInt(1, 4, "Wybierz poprawna opcje. ");
        WagonMaterialyWybuchowe.Obudowa obudowa = switch (wybor) {
            case 1 -> Obudowa.STAL;
            case 2 -> Obudowa.PIASEK;
            case 3 -> Obudowa.NICHROM;
            case 4 -> Obudowa.MAGNAL;
            default -> Obudowa.STAL;
        };
        System.out.println("Podaj wyczulenie na drgania: ");
        double wyczulenieNaDrgania = Funkcje.sprawdzCzyPoprawnyDouble(0,2000, "Zle wyczulenie. (0 - 2000)");
        Wagon wagon = new WagonMaterialyWybuchowe(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, pojemnosc, przykryty, obudowa, wyczulenieNaDrgania);
        System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Wybuchowe{" +
                "obudowaOchronna: " + obudowaOchronna +
                ", wyczulenie na drgania: " + wyczulenieNaDrgania +
                '.';
    }
}
