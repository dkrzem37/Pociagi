import java.util.*;

public class Sklad implements Comparable<Sklad>{
    private static int nrIdentyfikacyjny = 0;
    public static ArrayList<Sklad> sklady = new ArrayList<>();
    private Lokomotywa lokomotywa;
    private ArrayList<Wagon> wagony;
    private int nrIdentyfikacyjnySkladu, procentDrogiPokonanej;
    private double drogaMiedzyStacjami, dlugoscTrasy;
    private Thread zmianaPredkosci, ruchSkladu;
    private Miejsce miejsce;
    private  Stack<Stacja> Trasa = new Stack<>();

    public Sklad(Lokomotywa lokomotywa) {
        this.lokomotywa = lokomotywa;
        this.miejsce = lokomotywa.getStacjaZrodlowa();
        lokomotywa.setPredkosc(lokomotywa.getSredniaPredkosc());
        this.dlugoscTrasy = 0;

        this.wagony = new ArrayList<Wagon>();
        this.nrIdentyfikacyjnySkladu = nrIdentyfikacyjny++;
        Sklad.sklady.add(this);
        lokomotywa.setNalezyDoSkladu(this);
        Lokomotywa.listaLokomotywWolnych.remove(lokomotywa);

        this.zmianaPredkosci = new Thread(new ZmianaPredkosciLokomotywy(lokomotywa));
        this.zmianaPredkosci.start();
        this.ruchSkladu = new Thread(new RuchSkladu(this));
        this.ruchSkladu.start();
    }

    public static void wyswietlTraseSkladu(){
        System.out.println("Podaj numer identyfikacyjny skladu ktorego trase chcesz wyswietlic: ");
        Sklad sklad = Funkcje.zwrocIstniejacySklad();
        if(!sklad.getTrasa().isEmpty()){
            Stack<Stacja> odwroconaTrasa= new Stack<>();
            while(!sklad.getTrasa().isEmpty()){
                odwroconaTrasa.push(sklad.getTrasa().pop());
            }
            System.out.println("Dlugosc trasy wynosi " + sklad.getDlugoscTrasy() + " km.");
            for(Stacja s: odwroconaTrasa){
                System.out.print("[(" + s.getNrIdentyfikacyjnyStacji() + ") " + s.getNazwaStacji() + "]" +" ");
            }
            System.out.println();
        }else{
            System.out.println("Brak trasy.");
        }
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
        sklady.remove(sklad);
        sklad.getRuchSkladu().interrupt();
        sklad.getZmianaPredkosci().interrupt();
        System.out.println("Sklad usunieto.");
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
                numerIdSkladu = Funkcje.sprawdzCzyPoprawnyInt(0, Sklad.getNrIdentyfikacyjny(), "Zly numer.");
                if ((sklad = Funkcje.zwrocSkladONumerze(numerIdSkladu)) == null)
                    System.out.println("Nie ma takiego skladu. ");
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

    public static Stack<Stacja> zwrocTrase(Stacja zrodlowa,Stacja docelowa){
        Set<Stacja> przeszukane = new HashSet<>();
        Stack<Stacja> trasa = new Stack<>();

        istniejeTrasa(zrodlowa,docelowa, przeszukane, trasa);
        return trasa;
    }
    public static boolean istniejeTrasa(Stacja zrodlowa, Stacja docelowa, Set<Stacja> przeszukane, Stack<Stacja> trasa){
        przeszukane.add(zrodlowa);
        trasa.add(zrodlowa);
        if(zrodlowa == docelowa){
            return true;
        }
        Stacja kolejna = null;

        for (Polaczenie p : zrodlowa.getPolaczenia()) {
            if (zrodlowa == p.getStacja1() && !przeszukane.contains(p.getStacja2())) {
                    kolejna = p.getStacja2();
            }else if (!przeszukane.contains(p.getStacja1())){
                kolejna = p.getStacja1();
            }
            if(kolejna != null) {
                if (istniejeTrasa(kolejna, docelowa, przeszukane, trasa))
                    return true;
            }
        }

        trasa.pop();
        return false;
    }

    public void wyswietlProcentMiedzyStacjami(){
        if(miejsce instanceof Stacja)
            System.out.println("Sklad znajduje sie na stacji " + miejsce.getNazwa());
        if(miejsce instanceof Polaczenie)
            System.out.println("Sklad pokonal " + miejsce.zwrocDystansMiedzyStacjami() + "% drogi miedzy stacjami na polaczeniu [" + ((Polaczenie) miejsce).getStacja1().getNazwaStacji() +"] - [" + ((Polaczenie) miejsce).getStacja2().getNazwaStacji() + "]");
    }
    public void wyswietlProcentTrasy(){
        System.out.println("Pokonano " + this.procentDrogiPokonanej + "% drogi na trasie  [" + this.lokomotywa.getStacjaZrodlowa() + "] - [" + this.lokomotywa.getStacjaDocelowa() + "]");
    }

    public static void raportSkladu(){
        System.out.println("Podaj numer identyfikacyjny skladu ktorego raport ma zostac wyswietlony: ");
        int numerIdSkladu;
        Sklad sklad;
        do {
            numerIdSkladu = Funkcje.sprawdzCzyPoprawnyInt(0, Sklad.getNrIdentyfikacyjny(), "Zly numer.");
            if ((sklad = Funkcje.zwrocSkladONumerze(numerIdSkladu)) == null)
                System.out.println("Nie ma takiego skladu. ");
        } while (sklad == null);
        //Trasa lepiej jako osobna opcja
        /*Stack<Stacja> odwroconaTrasa= new Stack<>();
        while(!sklad.getTrasa().isEmpty()){
            odwroconaTrasa.push(sklad.getTrasa().pop());
        }*/

        System.out.println(sklad);
        /*for(Stacja s: odwroconaTrasa){
            System.out.print("[(" + s.getNrIdentyfikacyjnyStacji() + ") " + s.getNazwaStacji() + "]" +" ");
        }*/
        System.out.println();
        System.out.print("     -" );
        sklad.wyswietlProcentTrasy();
        System.out.print("     -");
        sklad.wyswietlProcentMiedzyStacjami();


        System.out.println();
        for(Wagon w: sklad.getWagony()){
            w.ileLudzi();
            w.wyswietlTowary();
            System.out.println("     -----");
        }
    }


    public int getNrIdentyfikacyjnySkladu() {
        return nrIdentyfikacyjnySkladu;
    }

    public static int getNrIdentyfikacyjny() {
        return nrIdentyfikacyjny;
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

    public double getDlugoscTrasy() {
        return dlugoscTrasy;
    }

    public void setDlugoscTrasy(double dlugoscTrasy) {
        this.dlugoscTrasy = dlugoscTrasy;
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public Thread getZmianaPredkosci() {
        return zmianaPredkosci;
    }

    public double getDrogaMiedzyStacjami() {
        return drogaMiedzyStacjami;
    }

    public void setDrogaMiedzyStacjami(double drogaMiedzyStacjami) {
        this.drogaMiedzyStacjami = drogaMiedzyStacjami;
    }

    public Miejsce getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(Miejsce miejsce) {
        this.miejsce = miejsce;
    }

    public Thread getRuchSkladu() {
        return ruchSkladu;
    }

    public int getProcentDrogiPokonanej() {
        return procentDrogiPokonanej;
    }

    public void setProcentDrogiPokonanej(int procentDrogiPokonanej) {
        this.procentDrogiPokonanej = procentDrogiPokonanej;
    }

    public Stack<Stacja> getTrasa() {
        return Trasa;
    }

    public void setTrasa(Stack<Stacja> trasa) {
        Trasa = trasa;
    }


    @Override
    public int compareTo(Sklad o) {
        if(this.getDrogaMiedzyStacjami() - o.getDrogaMiedzyStacjami() > 0){
            return -1;
        }else if(this.getDrogaMiedzyStacjami() - o.getDrogaMiedzyStacjami() < 0){
            return 1;
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Sklad o numerze identyfikacyjnym " + nrIdentyfikacyjnySkladu +
                ": lokomotywa : " + lokomotywa.getNazwa() +
                ", aktualne miejsce : " + miejsce.getNazwa() +
                ", droga pozostala do stacji : " + this.drogaMiedzyStacjami +
                "km.";
    }
}
