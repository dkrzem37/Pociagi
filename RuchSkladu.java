import javax.management.monitor.Monitor;
import java.util.Stack;

public class RuchSkladu implements Runnable {
    private static String monitor = new String();
    private Sklad sklad;

    public RuchSkladu(Sklad sklad) {
        this.sklad = sklad;
    }

    @Override
    public void run() {
        while (true) {
            Stack<Stacja> odwrotnaTrasa = Sklad.zwrocTrase(this.sklad.getLokomotywa().getStacjaZrodlowa(), this.sklad.getLokomotywa().getStacjaDocelowa());
            Stack<Stacja> trasa = new Stack<>();
            while (!odwrotnaTrasa.isEmpty()) {
                trasa.push(odwrotnaTrasa.pop());
            }
            //usunac
            for(Stacja s : trasa){
                System.out.print(s.getNrIdentyfikacyjnyStacji() + " + ");
            }
            Stacja stacja1;
            Stacja stacja2 = null;
            boolean trasaEmpty = true;
            if(!trasa.empty()) {
                trasaEmpty = false;
                stacja2 = trasa.pop();
            }

            while (!trasa.empty()) {
                stacja1 = stacja2;
                stacja2 = trasa.pop();
                Polaczenie polaczenie = null;

                for (Polaczenie p : stacja1.getPolaczenia()) {
                    if ((p.getStacja1() == stacja1 && p.getStacja2() == stacja2) || (p.getStacja1() == stacja2 && p.getStacja2() == stacja1))
                        polaczenie = p;
                }


                synchronized (polaczenie) {

                    while (!(polaczenie.getSkladPrzejezdzajacy() == null)) {
                        try {
                            wait();
                        } catch (InterruptedException e) {

                        }
                    }

                        polaczenie.setSkladPrzejezdzajacy(this.sklad);
                        sklad.setMiejsce(polaczenie);
                        while (sklad.getDrogaMiedzyStacjami() < polaczenie.getOdleglosc()) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {

                            }
                            sklad.setDrogaMiedzyStacjami(sklad.getDrogaMiedzyStacjami() + this.sklad.getLokomotywa().getPredkosc() / 3600);
                        }
                        polaczenie.setSkladPrzejezdzajacy(null);
                        sklad.setDrogaMiedzyStacjami(0);
                        sklad.setMiejsce(stacja2);
                        polaczenie.notify();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {

                        }
                }
                System.out.println(stacja1.toString() + stacja2.toString());

            }
            if(!trasaEmpty){
                Stacja temp = sklad.getLokomotywa().getStacjaZrodlowa();
                sklad.getLokomotywa().setStacjaZrodlowa(sklad.getLokomotywa().getStacjaDocelowa());
                sklad.getLokomotywa().setStacjaDocelowa(temp);
                System.out.println("Zamiana zrodl i docel: " + sklad.getLokomotywa().getStacjaZrodlowa() + sklad.getLokomotywa().getStacjaDocelowa());
            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
