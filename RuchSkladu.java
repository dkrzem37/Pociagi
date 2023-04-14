import javax.management.monitor.Monitor;
import java.util.ConcurrentModificationException;
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
            //Stack<Stacja> odwrotnaTrasa = Sklad.zwrocTrase(this.sklad.getLokomotywa().getStacjaZrodlowa(), this.sklad.getLokomotywa().getStacjaDocelowa());
            Stack<Stacja> trasa = Sklad.zwrocTrase(this.sklad.getLokomotywa().getStacjaDocelowa(), this.sklad.getLokomotywa().getStacjaZrodlowa());
            int countStacji = 0;
            int dlugoscTrasy = trasa.size() - 1;
            /*while (!odwrotnaTrasa.isEmpty()) {
                trasa.push(odwrotnaTrasa.pop());
            }*/
            //usunac

                /*for (Stacja s : trasa) {
                    System.out.print(s.getNrIdentyfikacyjnyStacji() + " + ");
                }
                System.out.println();*/

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

                /*for (Polaczenie p : stacja1.getPolaczenia()) {
                    if ((p.getStacja1() == stacja1 && p.getStacja2() == stacja2) || (p.getStacja1() == stacja2 && p.getStacja2() == stacja1))
                        polaczenie = p;
                }*/

                /*for(Polaczenie p : Polaczenie.wszystkiePolaczenia){
                    if((p.getStacja1() == stacja1 && p.getStacja2() == stacja2) || (p.getStacja1() == stacja2 && p.getStacja2() == stacja1))
                        polaczenie = p;
                }*/
                //W przypadku usuniecia przez nas polaczenia sklad zaczyna kursowac miedzy stacja najdalsza do jakiej dojechal na trasie a stacja zrodlowa
                do {
                    int tem = 0;
                    int maxProb = 3;
                    while(true) {
                        try {
                            for(Polaczenie p : Polaczenie.wszystkiePolaczenia){
                                if((p.getStacja1() == stacja1 && p.getStacja2() == stacja2) || (p.getStacja1() == stacja2 && p.getStacja2() == stacja1))
                                    polaczenie = p;
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

                    }
                }

                }while(polaczenie == null);


                    synchronized (polaczenie) {
                        //System.out.println("now");

                    /*while (!(polaczenie.getSkladPrzejezdzajacy() == null)) {
                        try {
                            System.out.println(this.sklad.getNrIdentyfikacyjnySkladu() + " waiting on " + polaczenie.getSkladPrzejezdzajacy());
                            wait();
                        } catch (InterruptedException e) {

                        }
                    }*/
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
                    countStacji++;
                    sklad.setProcentDrogiPokonanej((countStacji * 100) / dlugoscTrasy);
                    sklad.getLokomotywa().setPredkosc(0);

                    //polaczenie.notify();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {

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
}
