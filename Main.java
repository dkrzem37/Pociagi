import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //!!! W PROGRAMIE JEZDZA SKLADY, NIE LOKOMOTYWY

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

        //region tablica miast
        //Lista miast ze strony https://jordonmeyer.com/text-list-of-us-cities/
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
        for(Lokomotywa l: Lokomotywa.listaLokomotyw){
            tablicaSkladow[j] = new Sklad(l);
            j++;
        }

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

        //////////////////////////////////////////////////
        //////START
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
                "5. Wyswietl informacje.",
                "6. Zaladuj/usun ludzi.",
                "7. Zmien trase lokomotywy. "));
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
                "2. Wyswietl wszystkie stacje. ",
                "3. Wyswietl wszystkie lokomotywy. ",
                "4. Wyswietl wszystkie polaczenia. ",
                "5. Wyswietl wszystkie wagony. ",
                "6. Wyswietl wolnostojace wagony. ",
                "7. Wyswietl wolnostojace lokomotywy. ",
                "8. Wyswietl polaczenia stacji. ",
                "9. Wyswietl wszystkie przewozone towary. ",
                "10. Wyswietl informacje o wagonie. ",
                "11. Wyswietl informacje o lokomotywie. ",
                "12. Wyswietl trase skladu. "
        ));
        //Menu 0_6 ZALADUJ/USUN LUDZI
        ArrayList<String> menuZaladunekLudzi = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Zaladuj ludzi do wagonu.",
                "2. Usun ludzi z wagonu. "
        ));
        //Menu 1_2 STWORZ WAGON
        ArrayList<String> menuStworzWagon = new ArrayList<>(Arrays.asList(
                "0. Wroc do menu glownego.",
                "1. Wagon bagazowo-pocztowy.",
                "2. Wagon chlodniczy. ",
                "3. Wagon na ciekle materialy toksyczne.",
                "4. Wagon na materialy ciekle.",
                "5. Wagon na materialy gazowe.",
                "6. Wagon na materialy toksyczne.",
                "7. Wagon na materialy wybuchowe.",
                "8. Wagon pasazerski.",
                "9. Wagon pocztowy. ",
                "10. Wagon restauracyjny.",
                "11. Wagon towarowy ciezki.",
                "12. Wagon towarowy podstawowy."
        ));
        int userInput;
        ZapisywanieSkladowDoPliku zapis = new ZapisywanieSkladowDoPliku();
        Thread zapisywanie = new Thread(zapis);
        zapisywanie.start();
        do {
            System.out.println("WITAMY W DK RAILROADS.");

            userInput = Funkcje.wyborOpcjiZMenu(menuGlowne, "Wybierz jedna z opcji.");

            switch (userInput) {
                case 0: //0.0 Zakoncz dzialanie programu
                    System.exit(0);
                    break;
                case 1: //0.1 Stworz nowy obiekt
                    userInput = Funkcje.wyborOpcjiZMenu(menuTworzenieObiektow, "Wybierz jedna z opcji.");
                    switch (userInput) {
                        case 0:
                            break;
                        case 1: Lokomotywa.stworzLokomotywe();
                            break;
                        case 2: // 1.2 Tworzenie wagonow
                            userInput = Funkcje.wyborOpcjiZMenu(menuStworzWagon, "Wybierz jedna z opcji.");
                            switch (userInput) {
                                case 0:
                                    break;
                                case 1: WagonBagazowoPocztowy.stworzWagonBagazowoPocztowy();
                                    break;
                                case 2: WagonChlodniczy.stworzChlodniczy();
                                    break;
                                case 3: WagonCiekleMaterialyToksyczne.stworzCiekleMatToksyczne();
                                    break;
                                case 4: WagonMaterialyCiekle.stworzMaterialyCiekle();
                                    break;
                                case 5: WagonMaterialyGazowe.stworzMaterialyGazowe();
                                    break;
                                case 6: WagonMaterialyToksyczne.stworzMaterialyToksyczne();
                                    break;
                                case 7: WagonMaterialyWybuchowe.stworzMaterialyWybuchowe();
                                    break;
                                case 8: WagonPasazerski.stworzWagonPasazerski();
                                    break;
                                case 9: WagonPocztowy.stworzWagonPocztowy();
                                    break;
                                case 10: WagonRestauracyjny.stworzRestauracyjny();
                                    break;
                                case 11: WagonTowarowyCiezki.stworzWagonTowarowyCiezki();
                                    break;
                                case 12: WagonTowarowyPodstawowy.stworzWagonTowarowyPodstawowy();
                                    break;
                            }
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
                        case 1: Sklad.raportSkladu();
                            break;
                        case 2: Stacja.wyswietlWszystkieStacje();
                            break;
                        case 3: Lokomotywa.wyswietlWszystkieLokomotywy();
                            break;
                        case 4: Polaczenie.wyswietlWszystkiePolaczenia();
                            break;
                        case 5: Wagon.wyswietlWszystkieWagony();
                            break;
                        case 6: Wagon.wyswietlWszystkieWolneWagony();
                            break;
                        case 7: Lokomotywa.wyswietlWszystkieWolneLokomotywy();
                            break;
                        case 8: Stacja.wyswietlPolaczenia();
                            break;
                        case 9: Towar.wyswietlWszystkieTowary();
                            break;
                        case 10: Wagon.wyswietlInfoOWagonie();
                            break;
                        case 11: Lokomotywa.wyswietlInfoOLokomotywie();
                            break;
                        case 12: Sklad.wyswietlTraseSkladu();
                            break;
                    }
                    break;
                case 6: // 0.6 Zaladuj/usun ludzi
                    userInput = Funkcje.wyborOpcjiZMenu(menuZaladunekLudzi, "Wybierz jedna z opcji.");
                    switch (userInput) {
                        case 0:
                            break;
                        case 1: WagonPasazerski.zaladunekLudzi();
                            break;
                        case 2: WagonPasazerski.usuniecieLudzi();
                            break;
                    }
                    break;
                case 7: // 0.7 Zmiana trasy lokomotywy
                    Lokomotywa.zmianaTrasy();
                    break;
            }
            //???????????????????
            Scanner scanner = new Scanner(System.in);
            //userInput = scanner.nextInt();
        } while (userInput != -1);
    }
}







