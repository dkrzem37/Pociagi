import java.util.Scanner;

public class Presentation{
    public static void main(String[] args){

        Stacja.stworzStacje();//0
        Stacja.stworzStacje();//1
        Stacja.stworzStacje();//2
        Stacja.stworzStacje();//3
        Stacja.stworzStacje();//4
        Stacja.stworzStacje();//5
        Stacja.wyswietlWszystkieStacje();
        Stacja.usunStacje();//5
        System.out.println("//////////////////////");

        Polaczenie.stworzPolaczenie();//0-2
        Polaczenie.stworzPolaczenie();//2-3
        Polaczenie.stworzPolaczenie();//3-1
        Polaczenie.stworzPolaczenie();//1-2
        Polaczenie.wyswietlWszystkiePolaczenia();
        Polaczenie.stworzPolaczenie();//4-0
        Polaczenie.usunPolaczenie();//4-0
        System.out.println("//////////////////////");

        Lokomotywa.stworzLokomotywe();//0 trasa 0-3
        Lokomotywa.stworzLokomotywe();//1 trasa 1-3
        Lokomotywa.stworzLokomotywe();//2
        Lokomotywa.wyswietlWszystkieLokomotywy();
        Lokomotywa.zmianaTrasy();
        Lokomotywa.wyswietlInfoOLokomotywie();
        Lokomotywa.usunLokomotywe();//2
        System.out.println("//////////////////////");

        Sklad.stworzSklad();//0
        Sklad.stworzSklad();//1
        Sklad.stworzSklad();//2
        Sklad.usunSklad();//2

        System.out.println("//////////////////////");
        WagonPasazerski.stworzWagonPasazerski();//0
        WagonMaterialyToksyczne.stworzMaterialyToksyczne();//1
        WagonMaterialyWybuchowe.stworzMaterialyWybuchowe();//2
        Wagon.wyswietlWszystkieWagony();
        Wagon.wyswietlInfoOWagonie();
        Wagon.zaladunekTowaru();
        Wagon.wyladunekTowaru();
        WagonPasazerski.zaladunekLudzi();
        WagonPasazerski.usuniecieLudzi();

        try {
            Sklad.przypisanieWagonu();//do 0 skladu
            Sklad.przypisanieWagonu();//do 0 skladu
            Sklad.przypisanieWagonu();//do 1 skladu
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Sklad.odczepienieWagonuZeSkladu();//2 ze skladu 1
        Wagon.usunWagon();//2

        Sklad.raportSkladu();
    }
}
