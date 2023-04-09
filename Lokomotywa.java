import java.util.ArrayList;
import java.util.Scanner;

public
    class Lokomotywa {
    public static ArrayList<Lokomotywa> listaLokomotyw = new ArrayList<>();
    public static ArrayList<Lokomotywa> listaLokomotywWolnych = new ArrayList<>();
    private Sklad nalezyDoSkladu;
    private static int nrIdentyfikacyjny = 0;

    private int maxLiczbaWagonow, maxWagonowElektrycznych, nrIdentyfikacyjnyLokomotywy; //Czy jest potrzeba robic to za pomoca interfejsow?
    private double maxUciag, predkosc;
    private String nazwa;
    private Stacja stacjaMacierzysta, stacjaZrodlowa, stacjaDocelowa; //Stacje moglyby byc zmienione na typ enumeryczny

    public Lokomotywa(int maxLiczbaWagonow, double maxUciag, int maxWagonowElektrycznych, String nazwa, Stacja stacjaMacierzysta, Stacja stacjaZrodlowa, Stacja stacjaDocelowa, double predkosc) {
        this.maxLiczbaWagonow = maxLiczbaWagonow;
        this.maxUciag = maxUciag;
        this.maxWagonowElektrycznych = maxWagonowElektrycznych;
        this.nazwa = nazwa;
        this.stacjaMacierzysta = stacjaMacierzysta;
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.predkosc = predkosc;
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
        double predkosc = Funkcje.sprawdzCzyPoprawnyDouble(0, 400, "Niepoprawna predkosc. ");


        Lokomotywa lokomotywa = new Lokomotywa(maxLiczbaWagonow, maxUciag, maxWagonowElektrycznych, nazwa, stacjaMacierzysta, stacjaZrodlowa, stacjaDocelowa, predkosc);
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

    public Stacja getStacjaDocelowa() {
        return stacjaDocelowa;
    }

    public Sklad getNalezyDoSkladu() {
        return nalezyDoSkladu;
    }

    public void setNalezyDoSkladu(Sklad nalezyDoSkladu) {
        this.nalezyDoSkladu = nalezyDoSkladu;
    }
}
