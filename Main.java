import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        /*Stacja proba0 = new Stacja("sda");
        Stacja proba1 = new Stacja("sda");
        Stacja proba2 = new Stacja("agd");
        Stacja proba3 = new Stacja("sda");
        Stacja proba4 = new Stacja("agd");
        Stacja proba5 = new Stacja("sda");
        Stacja proba6 = new Stacja("agd");
        Stacja proba7 = new Stacja("sda");
        Stacja proba8 = new Stacja("agd");
        Stacja proba9 = new Stacja("sda");
        Stacja proba10 = new Stacja("agd");
        new Polaczenie(proba1, proba2, 0.1);
        new Polaczenie(proba1, proba3, 0.1);
        new Polaczenie(proba1, proba4, 0.1);
        new Polaczenie(proba1, proba5, 0.1);
        new Polaczenie(proba1, proba6, 0.1);
        new Polaczenie(proba3, proba2, 0.1);
        new Polaczenie(proba5, proba2, 0.1);
        new Polaczenie(proba6, proba2, 0.1);
        new Polaczenie(proba7, proba2, 0.1);
        new Polaczenie(proba3, proba4, 0.1);
        new Polaczenie(proba1, proba8, 0.1);
        new Polaczenie(proba8, proba9, 0.1);
        new Polaczenie(proba9, proba10, 0.1);*/
        /*Lokomotywa lok = new Lokomotywa(134,1233,12,"fs",proba1, proba1, proba10,150);
        new Sklad(lok);
        Stack<Stacja> temp= Sklad.zwrocTrase(lok.getStacjaDocelowa(), lok.getStacjaZrodlowa());
        for(Stacja s: temp){
            System.out.print(s.getNrIdentyfikacyjnyStacji() + " + ");
        }*/
        /*Polaczenie.usunPolaczenie();
        Polaczenie.stworzPolaczenie();
        Polaczenie.usunPolaczenie();*/
        /*for(int i = 0; i< 20; i++) {
            System.out.println((Math.random() * (155- 100) ) + 100);
        }*/
        /*for(int i = 0; i< 20; i++){
            System.out.println(15 + (int)(Math.random() * ((33 - 15) + 1)));
        }*/
        //region imiona dla lokomotyw
        String[] imionaDlaLokomotyw = {"Jeniffer",
                "Rollins",
                "Kourtney",
                "Irvine",
                "Danielle",
                "Crouch",
                "Obed",
                "Little",
                "Jericho",
                "Pyle",
                "Dahlia",
                "Regalado",
                "Candice",
                "Lake",
                "Brayan",
                "Burnett",
                "Tonya",
                "Carlos",
                "Makena",
                "Monkey",
                "Barista",
                "Polo",
                "Panto",
                "Perot",
                "Randyy",
                "Franco"};
        //endregion


        /*System.out.println("wybierz boolean");
        boolean aaa = Funkcje.wyborBoolean();
        System.out.println(aaa);
        WagonPasazerski.stworzWagonPasazerski();*/

        //region tablica miast
        String[] miasta = {
                "Abilene",
                "Akron",
                "Albany",
                "Albuquerque",
                "Alexandria",
                "Allentown",
                "Amarillo",
                "Anaheim",
                "Anchorage",
                "Ann Arbor",
                "Antioch",
                "Apple Valley",
                "Appleton",
                "Arlington",
                "Arvada",
                "Asheville",
                "Athens",
                "Atlanta",
                "Atlantic City",
                "Augusta",
                "Aurora",
                "Austin",
                "Bakersfield",
                "Baltimore",
                "Barnstable",
                "Baton Rouge",
                "Beaumont",
                "Bel Air",
                "Bellevue",
                "Berkeley",
                "Bethlehem",
                "Billings",
                "Birmingham",
                "Bloomington",
                "Boise",
                "Boise City",
                "Bonita Springs",
                "Boston",
                "Boulder",
                "Bradenton",
                "Bremerton",
                "Bridgeport",
                "Brighton",
                "Brownsville",
                "Bryan",
                "Buffalo",
                "Burbank",
                "Burlington",
                "Cambridge",
                "Canton",
                "Cape Coral",
                "Carrollton",
                "Cary",
                "Cathedral City",
                "Cedar Rapids",
                "Champaign",
                "Chandler",
                "Charleston",
                "Charlotte",
                "Chattanooga",
                "Chesapeake",
                "Chicago",
                "Chula Vista",
                "Cincinnati",
                "Clarke County",
                "Clarksville",
                "Clearwater",
                "Cleveland",
                "College Station",
                "Colorado Springs",
                "Columbia",
                "Columbus",
                "Concord",
                "Coral Springs",
                "Corona",
                "Corpus Christi",
                "Costa Mesa",
                "Dallas",
                "Daly City",
                "Danbury",
                "Davenport",
                "Davidson County",
                "Dayton",
                "Daytona Beach",
                "Deltona",
                "Denton",
                "Denver",
                "Des Moines",
                "Detroit",
                "Downey",
                "Duluth",
                "Durham",
                "El Monte",
                "El Paso",
                "Elizabeth",
                "Elk Grove",
                "Elkhart",
                "Erie",
                "Escondido",
                "Eugene"};
        //endregion
        for(String s: miasta){
            new Stacja(s);
        }
        //System.out.println(Stacja.stacje.size());
        /*for(Stacja s: Stacja.stacje){
            System.out.println(s.toString());
        }*/
        //TWORZENIE POLACZEN
        for(int i = 0; i < 1500; i++){
            Stacja stacja1 = Stacja.stacje.get((int) (Math.random()* (Stacja.stacje.size())));
            Stacja stacja2;
            do{
                stacja2 = Stacja.stacje.get((int) (Math.random()* (Stacja.stacje.size())));

            }while((stacja1 == stacja2) || Funkcje.czyIstniejePolaczenie(stacja1, stacja2));
            new Polaczenie(stacja1, stacja2, Math.random());
        }
        //TWORZENIE 25 LOKOMOTYW
        for(int i = 0; i < 25; i++){
            new Lokomotywa(imionaDlaLokomotyw[i]);
        }
        Sklad[] tablicaSkladow = new Sklad[25];
        int j = 0;
        //Tworzenie skladow
        for(Lokomotywa l: Lokomotywa.listaLokomotywWolnych){
            tablicaSkladow[j] = new Sklad(l);
            j++;
        }
        /*List<Sklad> sortedSklady = new ArrayList<>(Sklad.sklady);
        for(Sklad s: sortedSklady){
            System.out.println(s.toString());
        }
        Collections.sort(sortedSklady);
        for(Sklad s: sortedSklady){
            System.out.println(s.toString());
        }*/
        //Tworzenie wagonow
        Wagon[] wagony = new Wagon[252];
        for(int i = 0; i< 250;){
            wagony[i++] = new WagonBagazowoPocztowy(13, 14, 145555, 57000, true, "POCZTA POLSKA");
            wagony[i++] = new WagonChlodniczy(10,4,40000,59000, 1000, 12, -30, WagonChlodniczy.Chlodzenie.CIECZ);
            wagony[i++] = new WagonCiekleMaterialyToksyczne(5, 2, 130000,35000, 1200, true, 134, 13,13);
            wagony[i++] = new WagonMaterialyCiekle(11.2, 3.2, 40987, 50000, 500, 12, 88,1444);
            wagony[i++] = new WagonMaterialyGazowe(11, 2.4, 14000, 23000, 1377, 9, 55,14);
            wagony[i++] = new WagonMaterialyToksyczne(13,4.5,66000,44566,800,false, WagonMaterialyToksyczne.MaterialObudowy.LPDE,3);
            wagony[i++] = new WagonMaterialyWybuchowe(20,10, 14000,10000,1780,true, WagonMaterialyWybuchowe.Obudowa.STAL,  3.3);
            wagony[i++] = new WagonPasazerski(13,12,14444,14555, WagonPasazerski.Ogrzewanie.ELEKTRYCZNE, true, 23);
            wagony[i++] = new WagonPocztowy(6,2,15666,900, "Plix", 14.5);
            wagony[i++] = new WagonRestauracyjny(9,2,23653, 56000, WagonRestauracyjny.Rodzaj.RESTAURACJA, 13);
            wagony[i++] = new WagonTowarowyCiezki(14,5,15000,13000,false, 1000, true);
            wagony[i++] = new WagonTowarowyPodstawowy(11, 5,100000, 130000,false, 1400,18);
        }
        //Przypisywanie wagonow do skladow
        int kk = 0;
        for(Sklad s: tablicaSkladow){
            int k = (int)(Math.random()*5 +5);
            for(int i = 0; i< k; i++) {
                s.getWagony().add(wagony[kk]);
                Wagon.wagonyWolnostojace.remove(wagony[kk]);
                wagony[kk].setSkladPrzylaczony(s);
                kk++;
            }
        }
        /*for(int i = 0; i< wagony.length; i++){
            System.out.println(wagony[i]);
        }*/
        /*for(Wagon w: Wagon.wagony){
            System.out.println(w);
        }*/

       /* ZapisywanieSkladowDoPliku zapis1 = new ZapisywanieSkladowDoPliku();
        Thread zapisywanie1 = new Thread(zapis1);
        zapisywanie1.start();*/

        /*Sklad.raportSkladu();
        Sklad.raportSkladu();
        Sklad.raportSkladu();
        Sklad.usunSklad();

        WagonPasazerski test1 = new WagonPasazerski(14,13,14444,133, WagonPasazerski.Ogrzewanie.POWIETRZNE,true,12);
        WagonPasazerski test2 = new WagonPasazerski(14,13,14444,5000, WagonPasazerski.Ogrzewanie.POWIETRZNE,true,12);
        WagonPasazerski test3 = new WagonPasazerski(14,13,14444,1003, WagonPasazerski.Ogrzewanie.POWIETRZNE,true,12);
        WagonPasazerski test4 = new WagonPasazerski(14,13,14444,25000, WagonPasazerski.Ogrzewanie.POWIETRZNE,true,12);
        tablicaSkladow[0].getWagony().add(test1);
        tablicaSkladow[0].getWagony().add(test2);
        tablicaSkladow[0].getWagony().add(test3);
        tablicaSkladow[0].getWagony().add(test4);






        Polaczenie.usunPolaczenie();

        tablicaSkladow[1].wyswietlProcentMiedzyStacjami();
        tablicaSkladow[2].wyswietlProcentMiedzyStacjami();
        tablicaSkladow[3].wyswietlProcentMiedzyStacjami();
        tablicaSkladow[4].wyswietlProcentMiedzyStacjami();

        tablicaSkladow[1].wyswietlProcentTrasy();
        tablicaSkladow[2].wyswietlProcentTrasy();
        tablicaSkladow[3].wyswietlProcentTrasy();
        tablicaSkladow[4].wyswietlProcentTrasy();



        Polaczenie.stworzPolaczenie();*/


        /*for(Polaczenie p : Polaczenie.wszystkiePolaczenia){
            System.out.println(p.toString());
        }
        System.out.println(Polaczenie.wszystkiePolaczenia.size());*/





        //Sklad.usunSklad();
        /*System.out.println(sklad0.getMiejsce());

        for(Stacja s: Sklad.zwrocTrase(stacja5, stacja1)){
            System.out.print(s.getNrIdentyfikacyjnyStacji() + " - ");
        }
        System.out.println();

        stacja0.wyswietlPolaczenia();*/

        /*Sklad.usunSklad();

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

        Polaczenie.usunPolaczenie();*/

        /*WagonPasazerski wagon1 = new WagonPasazerski(12.3, 4,  1056, 14444 ,WagonPasazerski.Ogrzewanie.WODNE, true, 24);
        //WagonPocztowy wagon2 = new WagonPocztowy(14.1,1500, 14555);
        WagonMaterialyGazowe wagon3 = new WagonMaterialyGazowe();
        WagonTowarowyCiezki wagon4 = new WagonTowarowyCiezki();
        for(Wagon w: Wagon.wagonyWolnostojace){
            System.out.println(w.getNrIdentyfikacyjnyWagonu());
            if(w instanceof WagonPasazerski)
                System.out.println("true");;
        }
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
        //wagony[1] = wagon2;
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
        }*/
        //////////////////////////////////////////////////
        //PROPER PROGRAM
        /////////////////////////////////////////////////

        /*ZapisywanieSkladowDoPliku zapis1 = new ZapisywanieSkladowDoPliku();
        Thread zapisywanie1 = new Thread(zapis1);
        zapisywanie1.start();*/
        //Menu 0 MENU GLOWNE
        ArrayList<String> menuGlowne = new ArrayList<>(Arrays.asList(
                "0. Zakoncz dzialanie programu.",
                "1. Stworz nowy obiekt.",
                "2. Usun obiekt.",
                "3. Zaladuj/wyladuj towar z wagonow.",
                "4. Zmien sklad.",
                "5. Wyswietl informacje."));
        //Menu 0_1 TWORZENIE OBIEKTOW
        ArrayList<String> menuTworzenieObiektow = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Stworz lokomotywe.",
                "2. Stworz wagon.",
                "3. Stworz nowa stacje.",
                "4. Stworz nowe polaczenie miedzy stacjami.",
                "5. Stworz sklad."));
        //Menu 0_2 USUWANIE OBIEKTOW
        ArrayList<String> menuUsuwanieObiektow = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Usun lokomotywe.",
                "2. Usun wagon.",
                "3. Usun stacje.",
                "4. Usun polaczenie miedzy stacjami.",
                "5. Usun sklad."));
        //Menu 0_3 ZALADUNEK/WYLADUNEK TOWARU
        ArrayList<String> menuTowaru = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Zaladuj towar.",
                "2. Wyladuj towar. "
        ));
        //Menu 0_4 ZMIANA SKLADU
        ArrayList<String> menuZmianaSkladu = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Przyczep wagon.",
                "2. Odczep wagon. "
        ));
        //Menu 0_5 WYSWIETL INFORMACJE
        ArrayList<String> menuWyswietlInfo = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Wyswietl raport skladu.",
                "2. . "
        ));
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
            userInput = Funkcje.wyborOpcjiZMenu(menuGlowne, "Wybierz jedna z opcji.");

            switch (userInput) {
                case 0: //0.0 Zakoncz dzialanie programu
                    System.exit(0);
                    break;
                case 1: //0.1 Stworz nowy obiekt
                    userInput = Funkcje.wyborOpcjiZMenu(menuTworzenieObiektow, "Wybierz jedna z opcji.");
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
                        case 1: Lokomotywa.stworzLokomotywe();
                            break;
                        case 2:
                            break;
                        case 3: Stacja.stworzStacje();
                            break;
                        case 4: Polaczenie.stworzPolaczenie();
                            break;
                        case 5: Sklad.stworzSklad();
                            break;
                    }
                    ///////koniec kodu tworzenia
                    break;
                case 2: // 0.2 Usun obiekt.
                    userInput = Funkcje.wyborOpcjiZMenu(menuUsuwanieObiektow, "Wybierz jedna z opcji.");
                    switch (userInput) {
                        case 0:
                            break;
                        case 1: Lokomotywa.usunLokomotywe();
                            break;
                        case 2: Wagon.usunWagon();
                            break;
                        case 3: Stacja.usunStacje();
                            break;
                        case 4: Polaczenie.usunPolaczenie();
                            break;
                        case 5: Sklad.usunSklad();
                            break;
                    }
                    break;
                case 3: // 0.3 Zaladuj/wyladuj towar do wagonow.
                    userInput = Funkcje.wyborOpcjiZMenu(menuTowaru, "Wybierz jedna z opcji.");
                    switch (userInput) {
                        case 0:
                            break;
                        case 1: Wagon.zaladunekTowaru();
                            break;
                        case 2: Wagon.wyladunekTowaru();
                            break;
                    }
                    break;
                case 4: // 0.4 Zmien Sklad
                    userInput = Funkcje.wyborOpcjiZMenu(menuZmianaSkladu, "Wybierz jedna z opcji.");
                    switch (userInput) {
                        case 0:
                            break;
                        case 1:
                            try {
                                Sklad.przypisanieWagonu();
                            }catch(ZbytWieleWagonow| ZbytDuzaWagaWagonow| ZbytWieleWagonowElektrycznych e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2: Sklad.odczepienieWagonuZeSkladu();
                            break;
                    }
                    break;
                case 5: // 0.5 Wyswietl informacje
                    userInput = Funkcje.wyborOpcjiZMenu(menuWyswietlInfo, "Wybierz jedna z opcji.");
                    switch (userInput) {
                        case 0:
                            break;
                        case 1:
                            Sklad.raportSkladu();
                            break;
                        case 2:
                            break;
                    }
                    break;

            }
            //???????????????????
            Scanner scanner = new Scanner(System.in);
            //userInput = scanner.nextInt();
        } while (userInput != -1);
    }
}







