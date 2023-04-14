public class Towar {
    private static int numerId = 0;
    private String informacje;
    private double waga;
    private int numerIdTowar;

    public Towar(String informacje, double waga) {
        this.informacje = informacje;
        this.waga = waga;
        this.numerIdTowar = numerId++;
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
}
