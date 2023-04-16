import java.util.ArrayList;
import java.util.Scanner;

public class Stacja extends Miejsce{
    private static int nrIdentyfikacyjny = 0;
    private String nazwaStacji;
    public static ArrayList<Stacja> stacje = new ArrayList<>();
    private ArrayList<Polaczenie> polaczenia = new ArrayList<>();
    private int nrIdentyfikacyjnyStacji;
    private  ArrayList<Sklad> skladyStojace = new ArrayList<>();

    public Stacja(String nazwaStacji) {
        this.nrIdentyfikacyjnyStacji = nrIdentyfikacyjny++;
        this.nazwaStacji = nazwaStacji;
        Stacja.stacje.add(this);
    }

    public static void wyswietlWszystkieStacje(){
        for(Stacja s: stacje){
            System.out.println(s);
        }
    }

    public static void stworzStacje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe stacji: ");
        String nazwa = scanner.nextLine();
        Stacja stacja = new Stacja(nazwa);
        System.out.println("Stacja stworzona. Numer id: " + stacja.getNrIdentyfikacyjnyStacji() + ".");
    }
    public static void usunStacje(){
        System.out.println("Podaj numer identyfikacyjny stacji do usuniecia: ");
        Stacja stacjaDoUsuniecia = Funkcje.zwrocIstniejacaStacje();
        int numerId = stacjaDoUsuniecia.getNrIdentyfikacyjnyStacji();
        boolean bezpieczne = true;
        for(Polaczenie p: stacjaDoUsuniecia.getPolaczenia()){
            if(p.getSkladPrzejezdzajacy() != null){
                bezpieczne = false;
                break;
            }
        }
        if(bezpieczne && stacjaDoUsuniecia.getSkladyStojace().isEmpty()) {
            for (Stacja s : Stacja.stacje) {
                Funkcje.usunPolaczeniaZawierajaceStacje(s, stacjaDoUsuniecia);
            }
            Stacja.stacje.remove(stacjaDoUsuniecia);
            System.out.println("Usunieto stacje o numerze identyfikacyjnym " + numerId);
        }else{
            System.out.println("Na stacji lub na jednym z polaczen stacji znajduje sie sklad/-y. Niemozliwe usuniecie obiektu. ");
        }
    }


    public static void wyswietlPolaczenia(){
        System.out.println("Podaj numer identyfikacyjny stacji ktorej polaczenia chcesz wyswietlic: ");
        Stacja stacja = Funkcje.zwrocIstniejacaStacje();
        for(Polaczenie p: stacja.polaczenia){
            if(stacja == p.getStacja1())
                 System.out.println("[" + p.getStacja1() + "] - [" + p.getStacja2() + "]");
            else
                System.out.println("[" + p.getStacja2() + "] - [" + p.getStacja1() + "]");
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
    public int zwrocDystansMiedzyStacjami() {
        return 0;
    }

    @Override
    public String getNazwa(){
        return nazwaStacji;
    }

    public ArrayList<Sklad> getSkladyStojace() {
        return skladyStojace;
    }

    @Override
    public String toString() {
        return "Nazwa stacji: " + nazwaStacji + '\'' + ", nr identyfikacyjny stacji: " + nrIdentyfikacyjnyStacji + '.';
    }
}
