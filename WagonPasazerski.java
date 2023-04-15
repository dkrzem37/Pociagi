import java.util.Scanner;

public class WagonPasazerski extends Wagon{
    private static final int wagaCzlowieka = 80;
    enum Ogrzewanie{GAZOWE, POWIETRZNE, WODNE, PAROWE, ELEKTRYCZNE};
    private Ogrzewanie ogrzewanie;
    private boolean isToaleta;
    private int liczbaMiejscSiedz, wolneMiejsca;

    public WagonPasazerski(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, Ogrzewanie ogrzewanie, boolean isToaleta, int liczbaMiejscSiedz) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, true);
        this.ogrzewanie = ogrzewanie;
        this.isToaleta = isToaleta;
        this.liczbaMiejscSiedz = liczbaMiejscSiedz;
        this.wolneMiejsca = liczbaMiejscSiedz;
    }

    public static void stworzWagonPasazerski() {
        double[] temp = Wagon.stworzWagon();
        double dlugoscWagonu = temp[0];
        double wysokoscWagonu = temp[1];
        double maxUdzwig = temp[2];
        double wagaWagonu = temp[3];

        System.out.println("Wybierz rodzaj ogrzewania: ");

        System.out.println("1. Gazowe. ");
        System.out.println("2. Powietrzne. ");
        System.out.println("3. Wodne. ");
        System.out.println("4. Parowe. ");
        System.out.println("5. Elektryczne. ");
        int wybor = Funkcje.sprawdzCzyPoprawnyInt(1, 5, "Wybierz poprawna opcje. ");
        Ogrzewanie ogrzewanie = switch (wybor) {
            case 1 -> Ogrzewanie.GAZOWE;
            case 2 -> Ogrzewanie.POWIETRZNE;
            case 3 -> Ogrzewanie.WODNE;
            case 4 -> Ogrzewanie.PAROWE;
            case 5 -> Ogrzewanie.ELEKTRYCZNE;
            default -> Ogrzewanie.ELEKTRYCZNE;
        };

        System.out.println("Czy wagon ma toalete? ");
        boolean isToaleta = Funkcje.wyborBoolean();
        System.out.println("Podaj liczbe miejsc siedzacych: ");
        int liczbaMiejscSiedz = Funkcje.sprawdzCzyPoprawnyInt(0, 100, "Niepoprawna liczba. (0 - 100) ");

        Wagon wagon = new WagonPasazerski(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, ogrzewanie, isToaleta, liczbaMiejscSiedz);
        System.out.println("Utworzono wagon o numerze id " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
    }


    public static void zaladunekLudzi(){
        System.out.println("Podaj numer identyfikacyjny wagonu do ktorego chcesz zaladowac towar: ");
        Wagon wagon = Funkcje.zwrocIstniejacyWagon();
        if(wagon instanceof WagonPasazerski){
            if(((WagonPasazerski) wagon).getWolneMiejsca() > 0) {
                System.out.println("Liczba dostepnych miejsc wynosi " + ((WagonPasazerski) wagon).getWolneMiejsca() + " Ile ludzi chcialbys zaladowac? ");
                int iloscLudzi = Funkcje.sprawdzCzyPoprawnyInt(0, ((WagonPasazerski) wagon).getWolneMiejsca(), "Niepoprawna ilosc ludzi.");
                if(wagon.getSkladPrzylaczony() != null && wagon.getSkladPrzylaczony().obliczWageWagonow() + iloscLudzi * wagaCzlowieka > wagon.getSkladPrzylaczony().getLokomotywa().getMaxUciag()){
                    System.out.println("Dodanie tyle ludzi przekroczyloby maksymalny uciag lokomotywy.");
                }else {
                    wagon.setWagaTowaru(wagon.getWagaTowaru() + iloscLudzi * wagaCzlowieka);
                    wagon.setWagaWagonuITowaru(wagon.getWagaWagonuITowaru() + iloscLudzi * wagaCzlowieka);
                    ((WagonPasazerski) wagon).setWolneMiejsca(((WagonPasazerski) wagon).getWolneMiejsca() - iloscLudzi);
                    System.out.println("Operacja zakonczona sukcesem. ");
                }
            }else{
                System.out.println("Brak wolnych miejsc");
            }
        }else{
            System.out.println("Wagon nie jest wagonem pasazerskim. ");
        }
    }
    public static void usuniecieLudzi(){
        System.out.println("Podaj numer identyfikacyjny wagonu z ktorego chcesz usunac ludzi: ");
        Wagon wagon = Funkcje.zwrocIstniejacyWagon();
        if(wagon instanceof WagonPasazerski){
            if(((WagonPasazerski) wagon).getLiczbaMiejscSiedz() - ((WagonPasazerski) wagon).getWolneMiejsca() > 0){
                System.out.println("Na pokladzie jest " + (((WagonPasazerski) wagon).getLiczbaMiejscSiedz() - ((WagonPasazerski) wagon).getWolneMiejsca()) +" pasazerow. Ilu ludzi chcialbys usunac? ");
                int iloscLudzi = Funkcje.sprawdzCzyPoprawnyInt(0, ((WagonPasazerski) wagon).getLiczbaMiejscSiedz() - ((WagonPasazerski) wagon).getWolneMiejsca(), "Niepoprawna ilosc ludzi.");
                ((WagonPasazerski) wagon).setWolneMiejsca(((WagonPasazerski) wagon).getWolneMiejsca() + iloscLudzi);
                wagon.setWagaTowaru(wagon.getWagaTowaru() - wagaCzlowieka * iloscLudzi);
                wagon.setWagaWagonuITowaru(wagon.getWagaWagonuITowaru() - wagaCzlowieka * iloscLudzi);
                System.out.println("Operacja zakonczona sukcesem. ");
            }else{
                System.out.println("Brak pasazerow na pokladzie.");
            }
        }else{
            System.out.println("Wagon nie jest wagonem pasazerskim. ");
        }

    }
    @Override
    public void ileLudzi(){
        System.out.println("     W wagonie (nr id " + this.getNrIdentyfikacyjnyWagonu() + ") znajduje sie " + (liczbaMiejscSiedz - wolneMiejsca)  + " ludzi.");
    }


    public int getWolneMiejsca() {
        return wolneMiejsca;
    }

    public int getLiczbaMiejscSiedz() {
        return liczbaMiejscSiedz;
    }

    public void setWolneMiejsca(int wolneMiejsca) {
        this.wolneMiejsca = wolneMiejsca;
    }


    /*private String info() {
        return "WagonPasazerski:" +
                "numer identyfikacyjny: " + getNrIdentyfikacyjnyWagonu() +
                ",ogrzewanie: " + ogrzewanie +
                ", Toaleta: " + (isToaleta ? "tak" : "nie") +
                ", liczbaMiejscSiedz=" + liczbaMiejscSiedz +
                ", wolne miejsca: " + wolneMiejsca +
                "wymagaElektr=" + isWymagaElektr() +
                ", dlugoscWagonu=" + getDlugoscWagonu() +
                ", wysokoscWagonu=" + getWysokoscWagonu() +
                ", wagaWagonuITowaru=" + getWagaWagonuITowaru() +
                ", maxUdzwig=" + getMaxUdzwig() +
                ", wagaTowaru=" + getWagaTowaru() +
                ", wagaWagonu=" + getWagaWagonu() +
                '}';
    }*/

    @Override
    public String toString() {
        return "Wagon Pasazerski:" + super.toString() +
                "ogrzewanie: " + ogrzewanie +
                ", czy jest toaleta: " + (isToaleta ? "tak" : "nie") +
                ", liczba miejsc siedzacych: " + liczbaMiejscSiedz +
                ", wolne miejsca: " + wolneMiejsca +
                '.';
    }
}
