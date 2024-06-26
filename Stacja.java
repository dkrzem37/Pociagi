import java.util.ArrayList;
import java.util.Scanner;

public class Stacja extends Miejsce{
    private static int nrIdentyfikacyjny = 0;
    private String nazwaStacji;
    public static ArrayList<Stacja> stacje = new ArrayList<>();
    private ArrayList<Polaczenie> polaczenia = new ArrayList<>();
    private int nrIdentyfikacyjnyStacji;

    public Stacja(String nazwaStacji) {
        this.nrIdentyfikacyjnyStacji = nrIdentyfikacyjny++;
        this.nazwaStacji = nazwaStacji;
        Stacja.stacje.add(this);
    }

    public static void stworzStacje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe stacji: ");
        String nazwa = scanner.nextLine();
        Stacja stacja = new Stacja(nazwa);
        System.out.println("Stacja stworzona.");
    }
    public static void usunStacje(){
        System.out.println("Podaj numer identyfikacyjny stacji do usuniecia: ");
        Stacja stacjaDoUsuniecia = Funkcje.zwrocIstniejacaStacje();
        int numerId = stacjaDoUsuniecia.getNrIdentyfikacyjnyStacji();
        for(Stacja s: Stacja.stacje){
            Funkcje.usunPolaczeniaZawierajaceStacje(s, stacjaDoUsuniecia);
        }
        Stacja.stacje.remove(stacjaDoUsuniecia);
        System.out.println("Usunieto stacje o numerze identyfikacyjnym " + numerId);
    }


    public void wyswietlPolaczenia(){
        for(Polaczenie p: this.polaczenia){
            System.out.println(p.getStacja1().getNrIdentyfikacyjnyStacji() + " dochodzi do " + p.getStacja2().getNrIdentyfikacyjnyStacji());
        }
    }

    public int getNrIdentyfikacyjnyStacji() {
        return nrIdentyfikacyjnyStacji;
    }

    public void setNrIdentyfikacyjnyStacji(int nrIdentyfikacyjnyStacji) {
        this.nrIdentyfikacyjnyStacji = nrIdentyfikacyjnyStacji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stacja stacja = (Stacja) o;
        return nrIdentyfikacyjnyStacji == stacja.nrIdentyfikacyjnyStacji;
    }

    public static int getNrIdentyfikacyjny() {
        return nrIdentyfikacyjny;
    }

    public ArrayList<Polaczenie> getPolaczenia() {
        return polaczenia;
    }

    public String getNazwaStacji() {
        return nazwaStacji;
    }
    @Override
    public String getNazwa(){
        return nazwaStacji;
    }

    @Override
    public String toString() {
        return "Nazwa stacji: " + nazwaStacji + '\'' + ", nr identyfikacyjny stacji: " + nrIdentyfikacyjnyStacji + '.';
    }
}
