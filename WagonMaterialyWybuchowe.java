public class WagonMaterialyWybuchowe extends WagonTowarowyCiezki{
    enum Obudowa{STAL, PIASEK, NICHROM, MAGNAL};
    private Obudowa obudowaOchronna;
    private double wyczulenieNaDrgania;

    public WagonMaterialyWybuchowe(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, double pojemnosc, boolean przykryty, Obudowa obudowaOchronna, double wyczulenieNaDrgania) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, false, pojemnosc, przykryty);
        this.obudowaOchronna = obudowaOchronna;
        this.wyczulenieNaDrgania = wyczulenieNaDrgania;
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Wybuchowe{" +
                "obudowaOchronna: " + obudowaOchronna +
                ", wyczulenie na drgania: " + wyczulenieNaDrgania +
                '.';
    }
}
