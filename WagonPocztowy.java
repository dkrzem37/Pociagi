import java.util.Scanner;

public class WagonPocztowy extends Wagon{
   private String organOdpowiedzialny;
   private double przepuszczalnoscWilgoci;

   public WagonPocztowy(double dlugoscWagonu, double wysokoscWagonu, double maxUdzwig, double wagaWagonu, String organOdpowiedzialny, double przepuszczalnoscWilgoci) {
      super(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, true);
      this.organOdpowiedzialny = organOdpowiedzialny;
      this.przepuszczalnoscWilgoci = przepuszczalnoscWilgoci;
   }

   public static void stworzWagonPocztowy() {
      double[] temp = Wagon.stworzWagon();
      double dlugoscWagonu = temp[0];
      double wysokoscWagonu = temp[1];
      double maxUdzwig = temp[2];
      double wagaWagonu = temp[3];
      Scanner scanner = new Scanner(System.in);
      System.out.println("Podaj organ opowiedzialny za poczte: ");
      String organOdpowiedzialny = scanner.nextLine();

      System.out.println("Podaj przepuszczalnosc wagonu (0 - 1000): ");
      double przepuszczalnosc = Funkcje.sprawdzCzyPoprawnyDouble(0, 1000,"Niepoprawna przepuszczalnosc. (0 - 1000)");

      Wagon wagon = new WagonPocztowy(dlugoscWagonu, wysokoscWagonu, maxUdzwig, wagaWagonu, organOdpowiedzialny, przepuszczalnosc);
      System.out.println("Stworzono wagon o numerze identyfikacyjnym " + wagon.getNrIdentyfikacyjnyWagonu() + ".");
   }

   @Override
   public String toString() {
      return "Wagon Pocztowy:" + super.toString() +
              "organ odpowiedzialny za poczte: " + organOdpowiedzialny +
              ", przepuszczalnosc wilgoci: " + przepuszczalnoscWilgoci +
              '.';
   }
}
