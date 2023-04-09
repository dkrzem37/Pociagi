import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Sklad{
    private static int nrIdentyfikacyjny = 0;
    public static ArrayList<Sklad> sklady = new ArrayList<>();
    private Lokomotywa lokomotywa;
    private ArrayList<Wagon> wagony;
    private int nrIdentyfikacyjnySkladu;
    private Thread zmianaPredkosci;


    public Sklad(Lokomotywa lokomotywa) {
        this.lokomotywa = lokomotywa;

        this.wagony = new ArrayList<Wagon>();
        this.nrIdentyfikacyjnySkladu = nrIdentyfikacyjny++;
        Sklad.sklady.add(this);
        lokomotywa.setNalezyDoSkladu(this);

        this.zmianaPredkosci = new Thread(new ZmianaPredkosciLokomotywy(lokomotywa));
        this.zmianaPredkosci.start();
    }
    public static void usunSklad(){
        System.out.println("Podaj numer identyfikacyjny skladu ktory chcesz usunac: ");
        Sklad sklad = Funkcje.zwrocIstniejacySklad();
        sklad.getLokomotywa().setNalezyDoSkladu(null);
        Lokomotywa.listaLokomotywWolnych.add(sklad.getLokomotywa());
        for(Wagon w: sklad.getWagony()){
            w.setSkladPrzylaczony(null);
            Wagon.wagonyWolnostojace.add(w);
        }

        sklad.getZmianaPredkosci().interrupt();
    }

    public void sprawdzaniePredkosci() throws RailroadHazard{
        if(this.getLokomotywa().getPredkosc() > 200)
            throw new RailroadHazard("Przekroczenie 200 km/h", this);
    }

    public static void stworzSklad(){
        System.out.println("Podaj numer identyfikacyjny lokomotywy ktora chcesz przypisac do skladu: ");
        int numerIdLokomotywy;
        Lokomotywa lokomotywa;
        do {
            numerIdLokomotywy = Funkcje.sprawdzCzyPoprawnyInt(0, Lokomotywa.getNrIdentyfikacyjny(), "Zly numer.");
            if ((lokomotywa = Funkcje.zwrocLokomotyweONumerze(numerIdLokomotywy)) == null)
                System.out.println("Nie ma takiej lokomotywy. ");
        }while(lokomotywa == null);

            Sklad sklad = new Sklad(lokomotywa);
            System.out.println("Numer identyfikacyjny nowego skladu to " + sklad.getNrIdentyfikacyjnySkladu() + ".");

    }
    public static void odczepienieWagonuZeSkladu(){
        System.out.println("Podaj numer identyfikacyjny skladu z ktorego chcialbys usunac wagon: ");
        Sklad sklad = Funkcje.zwrocIstniejacySklad();

        System.out.println("Podaj numer identyfikacyjny wagonu ktory chcialbys odczepic: ");
        Wagon wagon = Funkcje.zwrocIstniejacyWagon();

        if(sklad.getWagony().contains(wagon)){
            Wagon.wagonyWolnostojace.add(wagon);
            wagon.setSkladPrzylaczony(null);
            sklad.getWagony().remove(wagon);
            System.out.println("Wagon odczepiono od skladu.");
        }else{
            System.out.println("Wagon nie nalezy do skladu.");
        }

    }

    public static void przypisanieWagonu() throws ZbytWieleWagonow, ZbytDuzaWagaWagonow, ZbytWieleWagonowElektrycznych{
        int numerIdWagonu;
        Wagon wagon;
        System.out.println("Podaj numer identyfikacyjny wagonu ktory chcesz podlaczyc: ");
        do{
            numerIdWagonu = Funkcje.sprawdzCzyPoprawnyInt(0, Wagon.getNrIdentyfikacyjny(),"Zly numer.");
            if((wagon = Funkcje.zwrocWagonONumerze(numerIdWagonu)) == null)
                System.out.println("Nie ma takiego wagonu. ");
        }while(wagon == null);

        if(Wagon.wagonyWolnostojace.contains(wagon)) {
            int numerIdSkladu;
            Sklad sklad;
            System.out.println("Podaj numer identyfikacyjny skladu do ktorego przypisac: ");
            do {
                numerIdSkladu = Funkcje.sprawdzCzyPoprawnyInt(0, Wagon.getNrIdentyfikacyjny(), "Zly numer.");
                if ((sklad = Funkcje.zwrocSkladONumerze(numerIdSkladu)) == null)
                    System.out.println("Nie ma takiego wagonu. ");
            } while (sklad == null);

            if (sklad.obliczWageWagonow() + wagon.getWagaWagonuITowaru() > sklad.getLokomotywa().getMaxUciag()) {
                throw new ZbytDuzaWagaWagonow("Zbyt duza waga wagonow");
            } else if (sklad.getWagony().size() + 1 > sklad.getLokomotywa().getMaxLiczbaWagonow()) {
                throw new ZbytWieleWagonow("Zbyt wiele wagonow w skladzie.");
            } else if (sklad.ileWagonowElektrycznych() > sklad.getLokomotywa().getMaxWagonowElektrycznych()) {
                throw new ZbytWieleWagonowElektrycznych("Zbyt wiele wagonow elektrycznych.");
            } else {
                System.out.println("Na ktora pozycje? " + "(" + 0 + " - " + sklad.wagony.size() + ")");

                int pozycja = Funkcje.sprawdzCzyPoprawnyInt(0, sklad.wagony.size(), "Niepoprawny input.");
                sklad.wagony.add(pozycja, wagon);
                Wagon.wagonyWolnostojace.remove(wagon);
                wagon.setSkladPrzylaczony(sklad);
                System.out.println("Przypisywanie zakonczone sukcesem.");
            }
        }else{
            System.out.println("Wagon zajety.");
        }

    }
    public static Stack<Stacja> zwrocTrase(Stacja poczatek,Stacja koniec){
        Set<Stacja> przeszukane = new HashSet<>();
        Stack<Stacja> kolejka = new Stack<>();
        Stack<Stacja> trasa = new Stack<>();

        istniejeTrasa(poczatek,koniec, przeszukane, kolejka, trasa);
        return trasa;
    }
    public static boolean istniejeTrasa(Stacja poczatek, Stacja koniec, Set<Stacja> przeszukane, Stack<Stacja> kolejka, Stack<Stacja> trasa){

        przeszukane.add(poczatek);
        trasa.add(poczatek);
        if(poczatek == koniec){
            return true;
        }
        for (Polaczenie p : poczatek.getPolaczenia()) {
            if (poczatek == p.getStacja1()) {
                if (!przeszukane.contains(p.getStacja2()))
                    kolejka.add(p.getStacja2());
            }else {
                if (!przeszukane.contains(p.getStacja1()))
                    kolejka.add(p.getStacja1());
            }
        }
        while(!kolejka.isEmpty()) {
            if (istniejeTrasa(kolejka.pop(), koniec, przeszukane, kolejka, trasa))
                return true;
        }

        trasa.pop();
        return false;
    }

    public int getNrIdentyfikacyjnySkladu() {
        return nrIdentyfikacyjnySkladu;
    }

    public double obliczWageWagonow(){
        double wagaSuma = 0;
        for(Wagon w: this.wagony){
            wagaSuma += w.getWagaWagonuITowaru();
        }
        return wagaSuma;
    }

    public int ileWagonowElektrycznych(){
        int ile = 0;
        for(Wagon w: this.wagony){
            if(w.isWymagaElektr())
                ile++;
        }
        return ile;
    }

    public ArrayList<Wagon> getWagony() {
        return wagony;
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public Thread getZmianaPredkosci() {
        return zmianaPredkosci;
    }
}