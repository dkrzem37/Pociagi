import javax.management.monitor.Monitor;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Stack;

public class RuchSkladu implements Runnable {
    //private static String monitor = new String();
    private Sklad sklad;

    public RuchSkladu(Sklad sklad) {
        this.sklad = sklad;
    }

    @Override
    public void run() {
        outerloop:
        while (true) {
            //Stack<Stacja> odwrotnaTrasa = Sklad.zwrocTrase(this.sklad.getLokomotywa().getStacjaZrodlowa(), this.sklad.getLokomotywa().getStacjaDocelowa());
            Stack<Stacja> trasa = Sklad.zwrocTrase(this.sklad.getLokomotywa().getStacjaDocelowa(), this.sklad.getLokomotywa().getStacjaZrodlowa());

            int countStacji = 0;
            int dlugoscTrasy = trasa.size() - 1;

            Stacja stacja1;
            Stacja stacja2 = null;
            boolean trasaEmpty = true;
            if(!trasa.empty()) {

                while(true) {
                    int tem = 0;
                    int maxProb = 3;
                    try {
                        this.sklad.setTrasa((Stack<Stacja>) trasa.clone());
                        sklad.setDlugoscTrasy(this.obliczDlugoscTrasy(trasa));
                        break;
                    } catch (ConcurrentModificationException e) {
                        if (++tem == maxProb) throw e;
                    }
                }

                trasaEmpty = false;
                stacja2 = trasa.pop();
            }

            while (!trasa.empty()) {
                stacja1 = stacja2;
                stacja2 = trasa.pop();
                Polaczenie polaczenie = null;

                //W przypadku usuniecia przez nas polaczenia sklad czeka na stacji na ktorej sie zatrzymal
                do {
                    int tem = 0;
                    int maxProb = 3;
                    while(true) {
                        try {
                            for(Polaczenie p : Polaczenie.wszystkiePolaczenia){
                                if((p.getStacja1() == stacja1 && p.getStacja2() == stacja2) || (p.getStacja1() == stacja2 && p.getStacja2() == stacja1)) {
                                    polaczenie = p;
                                    break;
                                }
                            }
                            break;
                        } catch (ConcurrentModificationException e) {
                            if (++tem == maxProb) throw e;
                        }
                    }

                if(polaczenie == null) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        stacja1.getSkladyStojace().remove(this.sklad);
                        break outerloop;
                    }
                }

                }while(polaczenie == null);

                if(Thread.currentThread().isInterrupted()){
                    stacja1.getSkladyStojace().remove(this.sklad);
                    break outerloop;
                }
                    synchronized (polaczenie) {
                        stacja1.getSkladyStojace().remove(this.sklad);

                        sklad.getLokomotywa().setPredkosc(sklad.getLokomotywa().getSredniaPredkosc());

                        polaczenie.setSkladPrzejezdzajacy(this.sklad);
                        sklad.setMiejsce(polaczenie);
                        sklad.setDrogaMiedzyStacjami(polaczenie.getOdleglosc());
                        while (sklad.getDrogaMiedzyStacjami() > 0) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {

                            }
                            sklad.setDrogaMiedzyStacjami(sklad.getDrogaMiedzyStacjami() - this.sklad.getLokomotywa().getPredkosc() / 3600);
                        }
                        polaczenie.setSkladPrzejezdzajacy(null);
                        //usunac
                        //System.out.println("Przejazd skladu " + sklad.getNrIdentyfikacyjnySkladu() + " ze stacji " + stacja1.toString() + stacja2.toString());
                    }
                    sklad.setDrogaMiedzyStacjami(0);
                    sklad.setMiejsce(stacja2);
                    stacja2.getSkladyStojace().add(this.sklad);
                    countStacji++;
                    sklad.setProcentDrogiPokonanej((countStacji * 100) / dlugoscTrasy);
                    sklad.getLokomotywa().setPredkosc(0);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        stacja2.getSkladyStojace().remove(this.sklad);
                        break outerloop;
                    }
                    if(Thread.currentThread().isInterrupted()){
                        stacja2.getSkladyStojace().remove(this.sklad);
                        break outerloop;
                    }
            }
            if(!trasaEmpty){
                Stacja temp = sklad.getLokomotywa().getStacjaZrodlowa();
                sklad.getLokomotywa().setStacjaZrodlowa(sklad.getLokomotywa().getStacjaDocelowa());
                sklad.getLokomotywa().setStacjaDocelowa(temp);
                //System.out.println("Zamiana zrodl i docel: " + sklad.getLokomotywa().getStacjaZrodlowa() + sklad.getLokomotywa().getStacjaDocelowa());
            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    private double obliczDlugoscTrasy(Stack<Stacja> trasa){
        double dlugoscTrasy = 0;
        Stack<Stacja> kopia = (Stack<Stacja>) trasa.clone();
        Stacja stacja1;
        Stacja stacja2 = null;
        if(!kopia.isEmpty()){
            stacja2 = kopia.pop();
        }
        while(!kopia.isEmpty()){
            stacja1 = stacja2;
            stacja2 = kopia.pop();
            int tem = 0;
            int maxProb = 3;
            while(true) {
                try {
                    for(Polaczenie p : Polaczenie.wszystkiePolaczenia){
                        if((p.getStacja1() == stacja1 && p.getStacja2() == stacja2) || (p.getStacja1() == stacja2 && p.getStacja2() == stacja1)) {
                            dlugoscTrasy += p.getOdleglosc();
                            break;
                        }
                    }
                    break;
                } catch (ConcurrentModificationException e) {
                    if (++tem == maxProb) throw e;
                }
            }
        }
        return dlugoscTrasy;

    }
}
