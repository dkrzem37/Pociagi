public class WagonMaterialyToksyczne extends WagonTowarowyCiezki{
    enum MaterialObudowy{PC, PP, LPDE, HDPE};
    private MaterialObudowy material;
    private int iloscPojemnikow;

    public WagonMaterialyToksyczne(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, boolean wymagaElektr, double pojemnosc, boolean przykryty, MaterialObudowy material, int iloscPojemnikow) {
        super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, wymagaElektr, pojemnosc, przykryty);
        this.material = material;
        this.iloscPojemnikow = iloscPojemnikow;
    }

    @Override
    public String toString() {
        return super.toString() + "Wagon na Materialy Toksyczne: " +
                "material: " + material +
                ", ilosc pojemnikow: " + iloscPojemnikow +
                '.';
    }
}
