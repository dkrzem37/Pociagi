import java.util.*;

public class Polaczenie extends Miejsce{
    private Stacja stacja1, stacja2;
    private double odleglosc;
    private Sklad skladPrzejezdzajacy;
    //private Stack<Sklad> skladyCzekajace = new Stack<>();
    public static HashSet<Polaczenie> wszystkiePolaczenia = new HashSet<>();

    public Polaczenie(Stacja stacja1, Stacja stacja2, double odleglosc) {
        this.stacja1 = stacja1;
        this.stacja2 = stacja2;
        this.odleglosc = odleglosc;
        this.skladPrzejezdzajacy = null;
        stacja1.getPolaczenia().add(this);
        stacja2.getPolaczenia().add(this);
        Polaczenie.wszystkiePolaczenia.add(this);
    }

    public static void stworzPolaczenie(){
        System.out.println("Podaj stacje numer 1: ");
        Stacja stacja1 = Funkcje.zwrocIstniejacaStacje();
        /*null;
        System.out.println("Podaj numer Identyfikacyjny pierwszej stacji: ");
        int numerIdentyfikacjiA = Funkcje.sprawdzCzyPoprawnyInt(0, Stacja.getNrIdentyfikacyjny(),"Zly numer.");
        if(!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiA))) {
            System.out.println("Stacja nie istnieje.");
        }
        else
            stacja1 = Funkcje.zwrocStacjeONumerze(numerIdentyfikacjiA);
        if(stacja1 != null) {
            Stacja stacja2 = null;
            System.out.println("Podaj numer Identyfikacyjny drugiej stacji: ");
            int numerIdentyfikacjiB = Funkcje.sprawdzCzyPoprawnyInt(0, Stacja.getNrIdentyfikacyjny(), "Zly numer.");
            if (!(Funkcje.czyStacjaIstnieje(numerIdentyfikacjiB)))
                System.out.println("Stacja nie istnieje.");
            else
                stacja2 = Funkcje.zwrocStacjeONumerze(numerIdentyfikacjiB);
            if (stacja2 != null) {*/
        System.out.println("Podaj stacje numer 2: ");
        Stacja stacja2 = Funkcje.zwrocIstniejacaStacje();
        boolean czyIstnieje = false;
        for (Polaczenie p : stacja1.getPolaczenia()) {
            if (((p.getStacja1() == stacja1) && (p.getStacja2() == stacja2)) || ((p.getStacja1() == stacja2) && (p.getStacja2() == stacja1)))
                czyIstnieje = true;
        }
        if(czyIstnieje){
            System.out.println("Istnieje takie polaczenie.");
        }
        else{
            double odleglosc;
            System.out.println("Podaj odleglosc: ");
            odleglosc = Funkcje.sprawdzCzyPoprawnyDouble(0.0, 10000.0, "Zla odleglosc.");

            new Polaczenie(stacja1, stacja2, odleglosc);
            System.out.println("Stworzono polaczenie.");
        }
    }

    public static void usunPolaczenie(){
        System.out.println("Podaj stacje numer 1: ");
        Stacja stacja1 = Funkcje.zwrocIstniejacaStacje();
        System.out.println("Podaj stacje numer 2: ");
        Stacja stacja2 = Funkcje.zwrocIstniejacaStacje();

        Polaczenie polaczenieDoUsuniecia = null;
        for (Polaczenie p : stacja1.getPolaczenia()) {
            if (((p.getStacja1() == stacja1) && (p.getStacja2() == stacja2)) || ((p.getStacja1() == stacja2) && (p.getStacja2() == stacja1)))
                polaczenieDoUsuniecia = p;

        }
        if(polaczenieDoUsuniecia != null){
            stacja1.getPolaczenia().remove(polaczenieDoUsuniecia);
            stacja2.getPolaczenia().remove(polaczenieDoUsuniecia);
            Polaczenie.wszystkiePolaczenia.remove(polaczenieDoUsuniecia);
            System.out.println("Polaczenie usunieto");
        }
        else{
            System.out.println("Takie polaczenie nie istnieje. ");
        }
    }

    public Stacja getStacja1() {
        return stacja1;
    }

    public Stacja getStacja2() {
        return stacja2;
    }

    public Sklad getSkladPrzejezdzajacy() {
        return skladPrzejezdzajacy;
    }

    public void setSkladPrzejezdzajacy(Sklad skladPrzejezdzajacy) {
        this.skladPrzejezdzajacy = skladPrzejezdzajacy;
    }

    /*public Stack<Sklad> getSkladyCzekajace() {
        return skladyCzekajace;
    }*/

    public double getOdleglosc() {
        return odleglosc;
    }
    @Override
    public String getNazwa(){
        return "polaczenie miedzy " + this.stacja1.getNazwa() + " oraz " + this.stacja2.getNazwa();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polaczenie that = (Polaczenie) o;
        return (stacja1.equals(that.stacja1) && stacja2.equals(that.stacja2)) || (stacja1.equals(that.stacja2) && stacja2.equals(that.stacja1));
    }

    @Override
    public String toString() {
        return "Polaczenie: " +
                "stacja1=" + stacja1 +
                ", stacja2=" + stacja2 +
                ", odleglosc=" + odleglosc +
                ", skladPrzejezdzajacy=" + skladPrzejezdzajacy;
    }
}
