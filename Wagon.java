import java.util.ArrayList;
import java.util.Scanner;

public abstract class Wagon {
    private static int nrIdentyfikacyjny = 0;
    private boolean wymagaElektr;
    private double dlugoscWagonu, wagaWagonuITowaru, maxUdzwig, wagaTowaru, wagaWagonu;
    private int nrIdentyfikacyjnyWagonu;
    private Sklad skladPrzylaczony;
    private ArrayList<Towar> listaTowarow = new ArrayList<>();
    public static ArrayList<Wagon> wagony = new ArrayList<>();
    public static ArrayList<Wagon> wagonyWolnostojace = new ArrayList<>();

    //delete default constructor later I think
    public Wagon() {
        this.nrIdentyfikacyjnyWagonu = nrIdentyfikacyjny++;
    }

    public Wagon(double dlugoscWagonu, double maxUdzwig, double wagaWagonu) {
        this.dlugoscWagonu = dlugoscWagonu;
        this.wagaWagonuITowaru = wagaWagonu;
        this.maxUdzwig = maxUdzwig;
        this.skladPrzylaczony = null;
        this.wagaWagonu = wagaWagonu;
        this.wagaTowaru = 0;
        this.nrIdentyfikacyjnyWagonu = nrIdentyfikacyjny++;
        Wagon.wagony.add(this);
        Wagon.wagonyWolnostojace.add(this);
    }
    public static void stworzWagon(){

    }
    public static void usunWagon(){
        System.out.println("Podaj numer identyfikacyjny wagonu ktory chcialbys usunac: ");
        Wagon wagon = Funkcje.zwrocIstniejacyWagon();
        if(wagon.getSkladPrzylaczony() != null)
            wagon.getSkladPrzylaczony().getWagony().remove(wagon);

        Wagon.wagonyWolnostojace.remove(wagon);
        Wagon.wagony.remove(wagon);
    }
    public static void wyladunekTowaru() {
        System.out.println("Podaj numer identyfikacyjny wagonu z ktorego chcialbys wyladowac towar: ");
        Wagon wagon = Funkcje.zwrocIstniejacyWagon();
        if (wagon.getListaTowarow().isEmpty()) {
            System.out.println("Brak towarow do wyladowania. ");
        } else {
            System.out.println("Podaj numer identyfikacyjny towaru ktory chcesz wyladowac");
            int nrIdTowaru = Funkcje.sprawdzCzyPoprawnyInt(0, Towar.getNumerId(),"Niepoprawny numer identyfikacyjny. ");
            Towar del = null;
            boolean istnieje = false;
            for(Towar t: wagon.getListaTowarow()){
                if(t.getNumerIdTowar() == nrIdTowaru) {
                    istnieje = true;
                    del = t;
                }
            }
            if(istnieje) {
                wagon.getListaTowarow().remove(del);
                System.out.println("Usunieto towar z wagonu.");
            }else
                System.out.println("W tym wagonie nie ma takiego towaru. ");
        }
    }
    public static void zaladunekTowaru(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer identyfikacyjny wagonu do ktorego chcesz zaladowac towar: ");
        Wagon wagon = Funkcje.zwrocIstniejacyWagon();

        System.out.println("Mozna zaladowac " + (wagon.getMaxUdzwig() - wagon.getWagaTowaru()) + " kg. Podaj wage towaru (kg): ");
        double wagaDoDodania = Funkcje.sprawdzCzyPoprawnyDouble(0, wagon.getMaxUdzwig() - wagon.getWagaTowaru(), "Niepoprawna waga. ");

        if(wagon.getSkladPrzylaczony() != null && wagon.getSkladPrzylaczony().obliczWageWagonow() + wagaDoDodania > wagon.getSkladPrzylaczony().getLokomotywa().getMaxUciag()){
            System.out.println("Dodanie towaru przekroczyloby maksymalny uciag lokomotywy.");
        }else{
            System.out.println("Podaj informacje o towarze.");
            String informacja = scanner.nextLine();

            Towar towar = new Towar(informacja, wagaDoDodania);
            wagon.getListaTowarow().add(towar);

            wagon.setWagaTowaru(wagon.getWagaTowaru() + wagaDoDodania);
            wagon.setWagaWagonuITowaru(wagon.getWagaWagonuITowaru() + wagaDoDodania);
        }
    }


    public int getNrIdentyfikacyjnyWagonu() {
        return nrIdentyfikacyjnyWagonu;
    }

    public void setNrIdentyfikacyjnyWagonu(int nrIdentyfikacyjnyWagonu) {
        this.nrIdentyfikacyjnyWagonu = nrIdentyfikacyjnyWagonu;
    }

    public static int getNrIdentyfikacyjny() {
        return nrIdentyfikacyjny;
    }

    public static void setNrIdentyfikacyjny(int nrIdentyfikacyjny) {
        Wagon.nrIdentyfikacyjny = nrIdentyfikacyjny;
    }

    public boolean isWymagaElektr() {
        return wymagaElektr;
    }

    public void setWymagaElektr(boolean wymagaElektr) {
        this.wymagaElektr = wymagaElektr;
    }

    public double getWagaWagonuITowaru() {
        return wagaWagonuITowaru;
    }

    public double getMaxUdzwig() {
        return maxUdzwig;
    }

    public double getWagaTowaru() {
        return wagaTowaru;
    }

    public Sklad getSkladPrzylaczony() {
        return skladPrzylaczony;
    }

    public void setSkladPrzylaczony(Sklad skladPrzylaczony) {
        this.skladPrzylaczony = skladPrzylaczony;
    }

    public void setWagaWagonuITowaru(double wagaWagonuITowaru) {
        this.wagaWagonuITowaru = wagaWagonuITowaru;
    }

    public void setWagaTowaru(double wagaTowaru) {
        this.wagaTowaru = wagaTowaru;
    }

    public void setWagaWagonu(double wagaWagonu) {
        this.wagaWagonu = wagaWagonu;
    }

    public ArrayList<Towar> getListaTowarow() {
        return listaTowarow;
    }
}
