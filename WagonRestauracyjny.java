public class WagonRestauracyjny extends Wagon{
    enum Rodzaj{BAR, RESTAURACJA}
    private Rodzaj rodzaj;
    private int iloscStolikow;


    public WagonRestauracyjny(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, Rodzaj rodzaj, int iloscStolikow) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, true);
        this.rodzaj = rodzaj;
        this.iloscStolikow = iloscStolikow;
    }

    @Override
    public String toString() {
        return "WagonRestauracyjny: " + super.toString() +
                "rodzaj: " + rodzaj +
                ", iloscStolikow: " + iloscStolikow +
                '.';
    }
}
