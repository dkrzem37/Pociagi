public class WagonMaterialyWybuchowe extends WagonTowarowyCiezki{
    enum Obudowa{STAL, PIASEK, NICHROM, MAGNAL};
    private Obudowa obudowaOchronna;
    private double wyczulenieNaDrgania;

    public WagonMaterialyWybuchowe(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, boolean przykryty, Obudowa obudowaOchronna, double wyczulenieNaDrgania) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, przykryty);
        this.obudowaOchronna = obudowaOchronna;
        this.wyczulenieNaDrgania = wyczulenieNaDrgania;
    }
}
