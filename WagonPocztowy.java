public class WagonPocztowy extends Wagon{

    public WagonPocztowy(double dlugoscWagonu, double wagaWagonu, double maxUdzwig) {
        super(dlugoscWagonu, wagaWagonu, maxUdzwig);
        super.setWymagaElektr(true);
    }
}
