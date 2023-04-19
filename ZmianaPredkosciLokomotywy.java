public class ZmianaPredkosciLokomotywy implements Runnable{
    private Lokomotywa lokomotywa;

    public ZmianaPredkosciLokomotywy(Lokomotywa lokomotywa) {
        this.lokomotywa = lokomotywa;
    }

    public void sprawdzaniePredkosci() throws RailroadHazard{
        if(this.lokomotywa.getPredkosc() > 200)
            throw new RailroadHazard("Przekroczenie 200 km/h", this.lokomotywa.getNalezyDoSkladu());
    }

    @Override
    public void run() {

        while(true){
            if (Thread.currentThread().isInterrupted())
                break;
            else{
                if (Math.random() < 0.5) {
                    this.lokomotywa.setPredkosc(this.lokomotywa.getPredkosc() * 103 / 100);
                    //this.lokomotywa.setPredkosc(this.lokomotywa.getPredkosc() + 10);

                    /*System.out.println("proba 103/100");
                    System.out.println(this.lokomotywa.getPredkosc());*/
                } else {
                    this.lokomotywa.setPredkosc(this.lokomotywa.getPredkosc() * 97 / 100);

                    /*System.out.println("proba 97/100");
                    System.out.println(this.lokomotywa.getPredkosc());*/
                }

                try {
                    sprawdzaniePredkosci();
                } catch (RailroadHazard e) {
                    System.out.println("Uruchomiono awaryjne zwalnianie dla skladu " + this.lokomotywa.getNalezyDoSkladu().getNrIdentyfikacyjnySkladu() + ".");
                    this.lokomotywa.setPredkosc(this.lokomotywa.getPredkosc() - 50);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }

        }

    }
}
