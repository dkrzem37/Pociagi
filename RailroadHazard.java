public class RailroadHazard extends Exception{
    public RailroadHazard(String errorMessage, Sklad sklad) {
        super(errorMessage);
        System.out.println("|| Przekroczono predkosc 200km/h.");
        System.out.println("|| Informacje o skladzie:");
        System.out.println("|| Numer identyfikacyjny skladu: " + sklad.getNrIdentyfikacyjnySkladu());
        System.out.println("|| Numer identyfikacyjny lokomotywy: " + sklad.getLokomotywa().getNrIdentyfikacyjnyLokomotywy());
        System.out.println("|| Stacja zrodlowa: " + sklad.getLokomotywa().getStacjaZrodlowa());
        System.out.println("|| Stacja docelowa: " + sklad.getLokomotywa().getStacjaDocelowa());
        System.out.println("|| Ilosc wagonow: " + sklad.getWagony().size());
        System.out.println("|| Laczna waga wagonow: " + sklad.obliczWageWagonow());

    }
}
