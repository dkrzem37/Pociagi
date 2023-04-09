import java.util.ArrayList;
import java.util.Scanner;


public abstract class Funkcje {

    //Usuwa ze stacjiZawierajacejliste polaczenia ktore maja w sobie s
    public static void usunPolaczeniaZawierajaceStacje(Stacja stacjaZawierajacaListe, Stacja s){
        ArrayList<Polaczenie> delete = new ArrayList<>();

        for(Polaczenie p: stacjaZawierajacaListe.getPolaczenia()){
            if(p.getStacja1() == s || p.getStacja2() ==s){
                delete.add(p);
            }
        }
        for(Polaczenie p: delete){
            stacjaZawierajacaListe.getPolaczenia().remove(p);
        }

    }
    public static Sklad zwrocIstniejacySklad(){
        int numerIdSkladu;
        Sklad sklad;
        do {
            numerIdSkladu = Funkcje.sprawdzCzyPoprawnyInt(0, Wagon.getNrIdentyfikacyjny(), "Zly numer.");
            if ((sklad = Funkcje.zwrocSkladONumerze(numerIdSkladu)) == null)
                System.out.println("Nie ma takiego wagonu. ");
        } while (sklad == null);
        return sklad;
    }
    public static Stacja zwrocIstniejacaStacje(){
        Stacja stacja;
        do {
            int numerIdentyfikacji = Funkcje.sprawdzCzyPoprawnyInt(0, Stacja.getNrIdentyfikacyjny(), "Zly numer.");
            if ((stacja = Funkcje.zwrocStacjeONumerze(numerIdentyfikacji)) == null) {
                System.out.println("Stacja nie istnieje.");
            }
        }while(stacja == null);
        return stacja;
    }
    public static Lokomotywa zwrocIstniejacaLokomotywe(){
        int numerIdLokomotywy;
        Lokomotywa lokomotywa;
        do {
            numerIdLokomotywy = Funkcje.sprawdzCzyPoprawnyInt(0, Lokomotywa.getNrIdentyfikacyjny(), "Zly numer.");
            if ((lokomotywa = Funkcje.zwrocLokomotyweONumerze(numerIdLokomotywy)) == null)
                System.out.println("Nie ma takiej lokomotywy. ");
        }while(lokomotywa == null);
        return lokomotywa;
    }

    public static Wagon zwrocIstniejacyWagon(){
        int numerIdWagonu;
        Wagon wagon;
        do{
            numerIdWagonu = Funkcje.sprawdzCzyPoprawnyInt(0, Wagon.getNrIdentyfikacyjny(),"Zly numer.");
            if((wagon = Funkcje.zwrocWagonONumerze(numerIdWagonu)) == null)
                System.out.println("Nie ma takiego wagonu. ");
        }while(wagon == null);
        return wagon;
    }
    public static Lokomotywa zwrocLokomotyweONumerze(int nrIdentyfikacyjny){
        for(Lokomotywa l: Lokomotywa.listaLokomotyw){
            if(l.getNrIdentyfikacyjnyLokomotywy() == nrIdentyfikacyjny)
                return l;
        }
        return null;
    }
    public static Sklad zwrocSkladONumerze(int nrIdentyfikacyjny){
        for(Sklad s: Sklad.sklady){
            if(s.getNrIdentyfikacyjnySkladu() == nrIdentyfikacyjny)
                return s;
        }
        return null;
    }

    public static boolean czyWagonIstnieje(int nrIdentyfikacyjny){
        for(Wagon w: Wagon.wagony){
            if(w.getNrIdentyfikacyjnyWagonu() == nrIdentyfikacyjny)
                return true;
        }
        return false;
    }

    public static Wagon zwrocWagonONumerze(int nrIdentyfikacyjny){
        for(Wagon w: Wagon.wagony){
            if(w.getNrIdentyfikacyjnyWagonu() == nrIdentyfikacyjny)
                return w;
        }
        return null;
    }

    //Sprawdz czy stacja jest na liscie stacji na podstawie numeru identyfikacyjnego
    //Moze lepiej to zrobic pobierajac nazwe stacji??
    public static Stacja zwrocStacjeONumerze(int nrIdentyfikacyjny){
        for(Stacja s: Stacja.stacje){
            if(s.getNrIdentyfikacyjnyStacji() == nrIdentyfikacyjny)
                return s;
        }
        return null;
    }
    public static boolean czyStacjaIstnieje(int nrIdentyfikacyjny){
        for(Stacja s: Stacja.stacje){
            if(s.getNrIdentyfikacyjnyStacji() == nrIdentyfikacyjny)
                return true;
        }
        return false;
    }
    /*public static int sprawdzCzyPoprawnyInt1(int min, int max, String errorMessage) {
        int userInput = -1;
        boolean poprawny;
        do {

            Scanner scanner = new Scanner(System.in);
            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(errorMessage);
                poprawny = false;
                continue;
            }
            if (userInput < min || userInput > max) {
                System.out.println(errorMessage);
                poprawny = false;
            } else
                poprawny = true;

        } while (!poprawny);
        return userInput;
    }*/
    public static int sprawdzCzyPoprawnyInt(int min, int max, String errorMessage){
        int properInt = -1;
        boolean proper;
        Scanner scanner = new Scanner(System.in);
        do{
            if(scanner.hasNextInt()) {
                properInt = scanner.nextInt();
            }else {
                System.out.println(errorMessage);
                proper = false;
                scanner.nextLine();
                continue;
            }
            if(properInt < min || properInt > max) {
                System.out.println(errorMessage);
                proper = false;
                scanner.nextLine();
            }else
                proper = true;
        }while(!proper);
        return properInt;
    }
    public static double sprawdzCzyPoprawnyDouble(double min, double max, String errorMessage){
        double properDouble = -1;
        boolean proper;
        Scanner scanner = new Scanner(System.in);
        do{
            if(scanner.hasNextDouble()) {
                properDouble = scanner.nextDouble();
            }else {
                System.out.println(errorMessage);
                proper = false;
                scanner.nextLine();
                continue;
            }
            if(properDouble < min || properDouble > max) {
                System.out.println(errorMessage);
                proper = false;
                scanner.nextLine();
            }else
                proper = true;
        }while(!proper);
        return properDouble;
    }

    /*public static int sprawdzCzyPoprawnyInt1(int min, int max,String errorMessage){
        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer i = min; i <= max; i++){
            temp.add(i);
        }
        Integer properInt;
        Scanner scanner = new Scanner(System.in);
        do{
            properInt = scanner.nextInt();
            scanner.nextLine();
            if(!(temp.contains(properInt)))
                System.out.println(errorMessage);
        }while(!(temp.contains(properInt)));
        return properInt;
    }*/
}

