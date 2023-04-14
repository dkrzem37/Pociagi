import java.util.ArrayList;
import java.util.Scanner;

public
    class Lokomotywa {
    public static ArrayList<Lokomotywa> listaLokomotyw = new ArrayList<>();
    public static ArrayList<Lokomotywa> listaLokomotywWolnych = new ArrayList<>();
    private Sklad nalezyDoSkladu;
    private static int nrIdentyfikacyjny = 0;

    private int maxLiczbaWagonow, maxWagonowElektrycznych, nrIdentyfikacyjnyLokomotywy; //Czy jest potrzeba robic to za pomoca interfejsow?
    private double maxUciag, predkosc, sredniaPredkosc;
    private String nazwa;
    private Stacja stacjaMacierzysta, stacjaZrodlowa, stacjaDocelowa; //Stacje moglyby byc zmienione na typ enumeryczny
    //Konstruktor tylko na potrzeby symulacji
    public Lokomotywa(String s){
        this.maxLiczbaWagonow = 15 + (int)(Math.random() * ((33 - 15) + 1));
        this.maxUciag = (Math.random() * 3000000 + 1000000);
        this.maxWagonowElektrycznych = 14 + (int)(Math.random() * ((26 - 14) + 1));
        this.nazwa = s;
        Stacja stacja1 = Stacja.stacje.get((int) (Math.random()* (Stacja.stacje.size())));
        Stacja stacja2 = Stacja.stacje.get((int) (Math.random()* (Stacja.stacje.size())));
        Stacja stacja3;
        do{

            stacja3 = Stacja.stacje.get((int) (Math.random()* (Stacja.stacje.size())));

        }while(stacja2 == stacja3);
        this.stacjaMacierzysta = stacja1;
        this.stacjaZrodlowa = stacja2;
        this.stacjaDocelowa = stacja3;
        this.predkosc = 0;
        this.sredniaPredkosc = (Math.random() * (155 - 100) + 100);
        this.nalezyDoSkladu = null;
        this.nrIdentyfikacyjnyLokomotywy = nrIdentyfikacyjny++;
        listaLokomotyw.add(this);
        listaLokomotywWolnych.add(this);

    }

    public Lokomotywa(int maxLiczbaWagonow, double maxUciag, int maxWagonowElektrycznych, String nazwa, Stacja stacjaMacierzysta, Stacja stacjaZrodlowa, Stacja stacjaDocelowa, double sredniaPredkosc) {
        this.maxLiczbaWagonow = maxLiczbaWagonow;
        this.maxUciag = maxUciag;
        this.maxWagonowElektrycznych = maxWagonowElektrycznych;
        this.nazwa = nazwa;
        this.stacjaMacierzysta = stacjaMacierzysta;
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.predkosc = 0;
        this.sredniaPredkosc = sredniaPredkosc;
        this.nalezyDoSkladu = null;
        this.nrIdentyfikacyjnyLokomotywy = nrIdentyfikacyjny++;
        listaLokomotyw.add(this);
        listaLokomotywWolnych.add(this);
    }

    public static void stworzLokomotywe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj maksymalna liczbe wagonow: ");
        int maxLiczbaWagonow = Funkcje.sprawdzCzyPoprawnyInt(0,300, "Niepoprawna liczba wagonow.");

        System.out.println("Podaj maksymalny uciag lokomotywy (w kilogramach): ");
        double maxUciag = Funkcje.sprawdzCzyPoprawnyDouble(0, 30000000, "Niepoprawny uciag. ");

        System.out.println("Podaj maksymalna liczbe wagonow elektrycznych: ");
        int maxWagonowElektrycznych = Funkcje.sprawdzCzyPoprawnyInt(0, 150, "Niepoprawna liczba wagonow elektrycznych. ");

        System.out.println("Podaj nazwe lokomotywy: ");
        String nazwa = scanner.nextLine();

        System.out.println("Podaj numer identyfikacji stacji macierzystej: ");
        int numerIdentyfikacjiMacierzystej;
        Stacja stacjaMacierzysta = null;
        do{
            numerIdentyfikacjiMacierzystej = Funkcje.sprawdzCzyPoprawnyInt(0, Stacja.getNrIdentyfikacyjny(),"Zly numer.");
            if(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiMacierzystej)))
                System.out.println("Stacja nie istnieje.");
            else
                stacjaMacierzysta = Funkcje.zwrocStacjeONumerze(numerIdentyfikacjiMacierzystej);
        }while(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiMacierzystej)));

        System.out.println("Podaj numer identyfikacji stacji zrodlowej: ");
        int numerIdentyfikacjiZrodlowej;
        Stacja stacjaZrodlowa = null;
        do{
            numerIdentyfikacjiZrodlowej = Funkcje.sprawdzCzyPoprawnyInt(0, Stacja.getNrIdentyfikacyjny(),"Zly numer.");
            if(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiZrodlowej)))
                System.out.println("Stacja nie istnieje.");
            else
                stacjaZrodlowa = Funkcje.zwrocStacjeONumerze(numerIdentyfikacjiZrodlowej);
        }while(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiZrodlowej)));

        System.out.println("Podaj numer identyfikacji stacji docelowej: ");
        int numerIdentyfikacjiDocelowej;
        Stacja stacjaDocelowa = null;
        do{
            numerIdentyfikacjiDocelowej = Funkcje.sprawdzCzyPoprawnyInt(0, Stacja.getNrIdentyfikacyjny(),"Zly numer.");
            if(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiDocelowej)))
                System.out.println("Stacja nie istnieje.");
            else
                stacjaDocelowa = Funkcje.zwrocStacjeONumerze(numerIdentyfikacjiDocelowej);
        }while(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiDocelowej)));

        System.out.println("Podaj predkosc lokomotywy (w km/h): ");
        double sredniaPredkosc = Funkcje.sprawdzCzyPoprawnyDouble(0, 400, "Niepoprawna predkosc. ");


        Lokomotywa lokomotywa = new Lokomotywa(maxLiczbaWagonow, maxUciag, maxWagonowElektrycznych, nazwa, stacjaMacierzysta, stacjaZrodlowa, stacjaDocelowa, sredniaPredkosc);
        System.out.println("Operacja zakonczona sukcesem. Numer identyfikacyjny nowej lokomotywy to " + lokomotywa.getNrIdentyfikacyjnyLokomotywy() + ".");

    }
    public static void usunLokomotywe(){

        System.out.println("Podaj numer identyfikacyjny lokomotywy do usuniecia: ");
        Lokomotywa lokomotywa = Funkcje.zwrocIstniejacaLokomotywe();
        if(lokomotywa.getNalezyDoSkladu() != null){
            System.out.println("Lokomotywa nalezy do skladu z id " + lokomotywa.getNalezyDoSkladu().getNrIdentyfikacyjnySkladu() + ". Najpierw usun ten sklad aby usunac lokomotywe.");
        }else{
            Lokomotywa.listaLokomotywWolnych.remove(lokomotywa);
            Lokomotywa.listaLokomotyw.remove(lokomotywa);
            System.out.println("Operacja zakonczona sukcesem.");
        }
    }

    @Override
    public String toString() {
        return "Lokomotywa: " +
                "nalezyDoSkladu=" + (nalezyDoSkladu == null ? "brak" : nalezyDoSkladu.getNrIdentyfikacyjnySkladu()) +
                ", maxLiczbaWagonow=" + maxLiczbaWagonow +
                ", maxWagonowElektrycznych=" + maxWagonowElektrycznych +
                ", nrIdentyfikacyjnyLokomotywy=" + nrIdentyfikacyjnyLokomotywy +
                ", maxUciag=" + maxUciag +
                ", predkosc=" + predkosc +
                ", sredniaPredkosc=" + sredniaPredkosc +
                ", nazwa='" + nazwa + '\'' +
                ", stacjaMacierzysta=" + stacjaMacierzysta.getNazwaStacji() +
                ", stacjaZrodlowa=" + stacjaZrodlowa.getNazwaStacji() +
                ", stacjaDocelowa=" + stacjaDocelowa.getNazwaStacji() +
                '}';
    }

    public int getMaxLiczbaWagonow() {
        return maxLiczbaWagonow;
    }

    public static int getNrIdentyfikacyjny() {
        return nrIdentyfikacyjny;
    }

    public int getMaxWagonowElektrycznych() {
        return maxWagonowElektrycznych;
    }

    public int getNrIdentyfikacyjnyLokomotywy() {
        return nrIdentyfikacyjnyLokomotywy;
    }

    public double getMaxUciag() {
        return maxUciag;
    }

    public double getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(double predkosc) {
        this.predkosc = predkosc;
    }

    public Stacja getStacjaZrodlowa() {
        return stacjaZrodlowa;
    }

    public Stacja getStacjaMacierzysta() {
        return stacjaMacierzysta;
    }

    public Stacja getStacjaDocelowa() {
        return stacjaDocelowa;
    }

    public void setStacjaZrodlowa(Stacja stacjaZrodlowa) {
        this.stacjaZrodlowa = stacjaZrodlowa;
    }

    public void setStacjaDocelowa(Stacja stacjaDocelowa) {
        this.stacjaDocelowa = stacjaDocelowa;
    }

    public Sklad getNalezyDoSkladu() {
        return nalezyDoSkladu;
    }

    public void setNalezyDoSkladu(Sklad nalezyDoSkladu) {
        this.nalezyDoSkladu = nalezyDoSkladu;
    }

    public double getSredniaPredkosc() {
        return sredniaPredkosc;
    }

    public String getNazwa() {
        return nazwa;
    }
}
