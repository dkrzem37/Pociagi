public class WagonPasazerski extends Wagon{
    private static final int wagaCzlowieka = 80;
    enum Ogrzewanie{GAZOWE, POWIETRZNE, WODNE, PAROWE, ELEKTRYCZNE};
    private Ogrzewanie ogrzewanie;
    private boolean isToaleta;
    private int liczbaMiejscSiedz, wolneMiejsca;

    public WagonPasazerski(double dlugoscWagonu, double wagaWagonu, double maxUdzwig, Ogrzewanie ogrzewanie, boolean isToaleta, int liczbaMiejscSiedz) {
        super(dlugoscWagonu, maxUdzwig, wagaWagonu);
        super.setWymagaElektr(true);
        this.ogrzewanie = ogrzewanie;
        this.isToaleta = isToaleta;
        this.liczbaMiejscSiedz = liczbaMiejscSiedz;
        this.wolneMiejsca = liczbaMiejscSiedz;
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
        System.out.println("Podaj numer identyfikacyjny wagonu do ktorego chcesz zaladowac towar: ");
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

    public int getWolneMiejsca() {
        return wolneMiejsca;
    }

    public int getLiczbaMiejscSiedz() {
        return liczbaMiejscSiedz;
    }

    public void setWolneMiejsca(int wolneMiejsca) {
        this.wolneMiejsca = wolneMiejsca;
    }
}
