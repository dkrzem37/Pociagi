import java.util.ArrayList;

public class Towar {
    private static int numerId = 0;
    private String informacje;
    private double waga;
    private int numerIdTowar;
    public static ArrayList<Towar> listaTowarow = new ArrayList<>();

    public Towar(String informacje, double waga) {
        this.informacje = informacje;
        this.waga = waga;
        this.numerIdTowar = numerId++;
        listaTowarow.add(this);
    }

    public static void wyswietlWszystkieTowary(){
        for(Towar t: listaTowarow){
            System.out.println(t);
        }
    }

    public int getNumerIdTowar() {
        return numerIdTowar;
    }

    public static int getNumerId() {
        return numerId;
    }

    public String getInformacje() {
        return informacje;
    }

    public double getWaga() {
        return waga;
    }

    @Override
    public String toString() {
        return "Towar: " +
                "informacje: " + informacje +
                ", waga: " + waga +
                ", numerIdTowar: " + numerIdTowar +
                ".";
    }
}
