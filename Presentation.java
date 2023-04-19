import java.util.Scanner;

public class Presentation{
    public static void main(String[] args){
        ZapisywanieSkladowDoPliku zapis = new ZapisywanieSkladowDoPliku();
        Thread zapisywanie = new Thread(zapis);
        zapisywanie.start();
        ////////////////////

        Stacja s0 = new Stacja("s0");
        Stacja s1 = new Stacja("s1");
        Stacja s2 = new Stacja("s2");
        Stacja s3 = new Stacja("s3");
        Stacja s4 = new Stacja("s4");
        Stacja s5 = new Stacja("s5");
        Stacja s6 = new Stacja("s6");
        Stacja s7 = new Stacja("s7");
        Stacja s8 = new Stacja("s8");


        Lokomotywa lokomotywa0 = new Lokomotywa(13,13444,13,"aaa", s0, s0, s7,134);
        Lokomotywa lokomotywa1 = new Lokomotywa(13,13444,13,"aaa", s0, s6, s1,180);
        Lokomotywa lokomotywa2 = new Lokomotywa(13,13444,13,"aaa", s0, s8, s0,180);


        Wagon wagon0 = new WagonPocztowy(6,2,15666,900, "Plix", 14.5);
        Wagon wagon1 = new WagonRestauracyjny(9,2,23653, 56000, WagonRestauracyjny.Rodzaj.RESTAURACJA, 13);
        Wagon wagon2 = new WagonTowarowyCiezki(14,5,15000,13000,false, 1000, true);
        Wagon wagon3 = new WagonPasazerski(13,12,14444,14555, WagonPasazerski.Ogrzewanie.ELEKTRYCZNE, true, 23);

        Polaczenie p1 = new Polaczenie(s0,s2, 1);
        Polaczenie p2 = new Polaczenie(s1,s2, 1);
        Polaczenie p3 = new Polaczenie(s1,s5, 1);
        Polaczenie p4 = new Polaczenie(s3,s2, 1);
        Polaczenie p5 = new Polaczenie(s3,s1, 1);
        Polaczenie p6 = new Polaczenie(s6,s2, 1);
        Polaczenie p7 = new Polaczenie(s6,s5, 1);
        Polaczenie p8 = new Polaczenie(s6,s7, 1);
        Polaczenie p9 = new Polaczenie(s8,s3, 1);

        //Sklad sklad0 = new Sklad(lokomotywa0);
        //Sklad sklad1 = new Sklad(lokomotywa1);
        Sklad sklad2 = new Sklad(lokomotywa2);

        Sklad.wyswietlTraseSkladu();

        ///////////////////////

        /*Stacja.stworzStacje();//0
        Stacja.stworzStacje();//1
        Stacja.stworzStacje();//2
        Stacja.stworzStacje();//3
        Stacja.stworzStacje();//4*/
        Stacja.stworzStacje();//5
        Stacja.wyswietlWszystkieStacje();
        Stacja.usunStacje();//5
        System.out.println("//////////////////////");

        /*Polaczenie.stworzPolaczenie();//0-2
        Polaczenie.stworzPolaczenie();//2-3
        Polaczenie.stworzPolaczenie();//3-1*/
        Polaczenie.stworzPolaczenie();//1-2
        Polaczenie.wyswietlWszystkiePolaczenia();
        //Polaczenie.stworzPolaczenie();//4-0
        Polaczenie.usunPolaczenie();//4-0
        System.out.println("//////////////////////");

        /*Lokomotywa.stworzLokomotywe();//0 trasa 0-3
        Lokomotywa.stworzLokomotywe();//1 trasa 1-3*/
        Lokomotywa.stworzLokomotywe();//2
        Lokomotywa.wyswietlWszystkieLokomotywy();
        Lokomotywa.zmianaTrasy();
        Lokomotywa.wyswietlInfoOLokomotywie();
        Lokomotywa.usunLokomotywe();//2
        System.out.println("//////////////////////");

        /*Sklad.stworzSklad();//0
        Sklad.stworzSklad();//1*/
        Sklad.stworzSklad();//2
        Sklad.usunSklad();//2

        System.out.println("//////////////////////");
        WagonPasazerski.stworzWagonPasazerski();//0
        /*WagonMaterialyToksyczne.stworzMaterialyToksyczne();//1
        WagonMaterialyWybuchowe.stworzMaterialyWybuchowe();//2*/
        Wagon.wyswietlWszystkieWagony();
        Wagon.wyswietlInfoOWagonie();
        Wagon.zaladunekTowaru();
        Wagon.wyladunekTowaru();
        WagonPasazerski.zaladunekLudzi();
        WagonPasazerski.usuniecieLudzi();

        try {
            Sklad.przypisanieWagonu();//do 0 skladu
            /*Sklad.przypisanieWagonu();//do 0 skladu
            Sklad.przypisanieWagonu();//do 1 skladu*/
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Sklad.odczepienieWagonuZeSkladu();//2 ze skladu 1
        Wagon.usunWagon();//2

        Sklad.raportSkladu();
        Sklad.wyswietlTraseSkladu();

        Funkcje.sprawdzCzyPoprawnyDouble(0, 10, "Zly numer");
        Funkcje.sprawdzCzyPoprawnyInt(20, 30,"Nie");
        Wagon wagonProbny = Funkcje.zwrocIstniejacyWagon();
        Lokomotywa lokomotywaProbna = Funkcje.zwrocIstniejacaLokomotywe();
        Stacja stacjaProbna = Funkcje.zwrocIstniejacaStacje();
        Sklad skladProbny = Funkcje.zwrocIstniejacySklad();
        System.out.println(Funkcje.wyborBoolean());
        System.out.println(Funkcje.czyIstniejePolaczenie(s0,s1));
    }
}
