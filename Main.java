import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        ZapisywanieSkladowDoPliku zapis1 = new ZapisywanieSkladowDoPliku();
        Thread zapisywanie1 = new Thread(zapis1);
        zapisywanie1.start();

        Stacja stacja0 = new Stacja("sfhvcn");
        Stacja stacja1 = new Stacja("gasa");
        Stacja stacja2 = new Stacja("adgsd");
        Stacja stacja3 = new Stacja("part");
        Stacja stacja4 = new Stacja("afaw");
        Stacja stacja5 = new Stacja("awrar");
        Stacja stacja6 = new Stacja("asfas");
        Stacja stacja7 = new Stacja("asfas");

        Polaczenie p1 = new Polaczenie(stacja1, stacja0, 14);
        Polaczenie p2 = new Polaczenie(stacja1, stacja2, 14);
        Polaczenie p3 = new Polaczenie(stacja2, stacja0, 14);
        Polaczenie p4 = new Polaczenie(stacja4, stacja0, 14);
        Polaczenie p5 = new Polaczenie(stacja4, stacja5, 14);
        Polaczenie p6 = new Polaczenie(stacja5, stacja3, 14);
        Polaczenie p7 = new Polaczenie(stacja3, stacja6, 14);

        for(Stacja s: Sklad.zwrocTrase(stacja1, stacja4)){
            System.out.print(s.getNrIdentyfikacyjnyStacji() + " - ");
        }
        System.out.println();

        stacja0.wyswietlPolaczenia();
        Lokomotywa lokomotywa0 = new Lokomotywa(133,14444,145, " fafa", stacja0,stacja1,stacja2,150);
        Sklad sklad = new Sklad(lokomotywa0);
        Sklad.usunSklad();
        Lokomotywa lokomotywa1 = new Lokomotywa(133,14444,145, " fafa", stacja0,stacja1,stacja2,150);
        Lokomotywa lokomotywa2 = new Lokomotywa(133,14444,145, " fafa", stacja0,stacja1,stacja2,150);
        for(Lokomotywa l : Lokomotywa.listaLokomotyw){
            System.out.println(l.getNrIdentyfikacyjnyLokomotywy());
        }
        System.out.println("above is a list of loco");
        Lokomotywa.usunLokomotywe();

        for(Lokomotywa l : Lokomotywa.listaLokomotyw){
            System.out.println(l.getNrIdentyfikacyjnyLokomotywy());
        }
        System.out.println("above is a list of loco");


        System.out.println(Funkcje.czyStacjaIstnieje(0));

        Stacja.usunStacje();

        stacja0.wyswietlPolaczenia();
        stacja1.wyswietlPolaczenia();
        stacja2.wyswietlPolaczenia();

        Polaczenie.usunPolaczenie();


        WagonPasazerski wagon1 = new WagonPasazerski(12.3, 1056, 14444 ,WagonPasazerski.Ogrzewanie.WODNE, true, 24);
        WagonPocztowy wagon2 = new WagonPocztowy(14.1,1500, 14555);
        WagonMaterialyGazowe wagon3 = new WagonMaterialyGazowe();
        WagonTowarowyCiezki wagon4 = new WagonTowarowyCiezki();
        Wagon.zaladunekTowaru();
        Wagon.wyladunekTowaru();
        try{
            Sklad.przypisanieWagonu();
        }catch(Exception e){
            e.printStackTrace();
        }
        Wagon.zaladunekTowaru();

        Wagon[] wagony = new Wagon[10];

        wagony[0] = wagon1;
        wagony[1] = wagon2;
        wagony[3] = wagon3;
        wagony[4] = wagon4;

        //Lokomotywa.stworzLokomotywe();

        Sklad.stworzSklad();
        try{
            Sklad.przypisanieWagonu();
        }catch(ZbytWieleWagonowElektrycznych | ZbytDuzaWagaWagonow | ZbytWieleWagonow ex){
            ex.printStackTrace();
        }
        try{
            Sklad.przypisanieWagonu();
        }catch(ZbytWieleWagonowElektrycznych | ZbytDuzaWagaWagonow | ZbytWieleWagonow ex){
            ex.printStackTrace();
        }
        try{
            Sklad.przypisanieWagonu();
        }catch(ZbytWieleWagonowElektrycznych | ZbytDuzaWagaWagonow | ZbytWieleWagonow ex){
            ex.printStackTrace();
        }
        try{
            Sklad.przypisanieWagonu();
        }catch(ZbytWieleWagonowElektrycznych | ZbytDuzaWagaWagonow | ZbytWieleWagonow ex){
            ex.printStackTrace();
        }
        for(Wagon w: wagony){
            if(w != null) {
                System.out.println(w.isWymagaElektr());
                System.out.println(w.getNrIdentyfikacyjnyWagonu());
            }
        }
        //////////////////////////////////////////////////
        //PROPER PROGRAM
        /////////////////////////////////////////////////
        //Menu 0 MENU GLOWNE
        ArrayList<String> menuGlowne = new ArrayList<>(Arrays.asList(
                "0. Zakoncz dzialanie programu.",
                "1. Stworz nowy obiekt.",
                "2. Usun obiekt.",
                "3. Zaladuj osoby/towar do wagonow.",
                "4. Zmien sklad.",
                "5. Wyswietl informacje."));
        //Menu 0_1 TWORZENIE OBIEKTOW
        ArrayList<String> menuTworzenieObiektow = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Stworz lokomotywe.",
                "2. Stworz wagon.",
                "3. Stworz nowa stacje.",
                "4. Stworz nowe polaczenie miedzy stacjami."));
        //Menu 0_2 USUWANIIE OBIEKTOW
        ArrayList<String> menuUsuwanieObiektow = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Usun lokomotywe.",
                "2. Usun wagon.",
                "3. Usun stacje.",
                "4. Usun polaczenie miedzy stacjami."));
        int userInput;
        do {
            ZapisywanieSkladowDoPliku zapis = new ZapisywanieSkladowDoPliku();
            Thread zapisywanie = new Thread(zapis);
            zapisywanie.start();

            System.out.println("WITAMY W DK RAILROADS.");
            /*
            do {
                System.out.println("0. Zakoncz dzialanie programu.");
                System.out.println("1. Stworz nowy obiekt.");
                System.out.println("2. Usun obiekt.");
                System.out.println("3. Zaladuj osoby/towar do wagonow.");
                System.out.println("4. Zmien sklad.");
                System.out.println("5. Wyswietl informacje.");

                try{
                    userInput = scanner.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Wybierz jedna z opcji.");
                    userInput = -1;
                    scanner.nextLine();
                    continue;
                }
                if(userInput < 0 || userInput > 5)
                    System.out.println("Wybierz jedna z opcji.");
            }while((userInput = Menu.wyborPoprawnejOpcji(0, 5, "Wybierz poprawna opcje: ")) == -1);*/
            userInput = Menu.wyborOpcjiZMenu(menuGlowne, "Wybierz jedna z opcji.");

            switch (userInput) {
                case 0: //0.0 Zakoncz dzialanie programu
                    System.exit(0);
                    break;
                case 1: //0.1 Stworz nowy obiekt
                    userInput = Menu.wyborOpcjiZMenu(menuTworzenieObiektow, "Wybierz jedna z opcji.");
                    /*do {
                        System.out.println("0. Wroc do menu glownego.");
                        System.out.println("1. Stworz lokomotywe.");
                        System.out.println("2. Stworz wagon.");
                        System.out.println("3. Stworz nowa stacje.");
                        System.out.println("4. Stworz nowe polaczenie miedzy stacjami.");
                    } while ((userInput = Menu.wyborPoprawnejOpcji(0, 4, "Wybierz poprawna opcje: ")) == -1);*/
                    switch (userInput) {
                        case 0:
                            break;
                        case 1:
                            Lokomotywa.stworzLokomotywe();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    ///////koniec kodu tworzenia
                    break;
                case 2: // 0.2 Usun obiekt.
                    break;
                case 3: // 0.3 Zaladuj osoby/towar do wagonow.
                    break;
                case 4: // 0.4 Zmien Sklad
                    break;
                case 5: // 0.5 Wyswietl informacje
                    break;

            }
            //???????????????????
            Scanner scanner = new Scanner(System.in);
            //userInput = scanner.nextInt();
        } while (userInput != -1);
    }
}







