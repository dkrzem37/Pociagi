import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ZapisywanieSkladowDoPliku implements Runnable{


    @Override
    public void run() {
        while(true) {
            List<Sklad> sortedSklady;
            List<Wagon> sortedWagony;
            int tem = 0;
            int maxProb = 3;
            while(true) {
                try {
                    sortedSklady = new ArrayList<>(Sklad.sklady);
                    break;
                } catch (ConcurrentModificationException e) {
                    if (++tem == maxProb) throw e;
                }
            }
            Collections.sort(sortedSklady);
            try {
                PrintWriter printWriter = new PrintWriter(new FileOutputStream("C:\\Users\\danio\\IdeaProjects\\GUI_project\\src\\AppState.txt", true));
                for(Sklad s: sortedSklady) {
                    printWriter.println(s.toString());

                    while(true) {
                        try {
                            sortedWagony = new ArrayList<>(s.getWagony());
                            break;
                        } catch (ConcurrentModificationException e) {
                            if (++tem == maxProb) throw e;
                        }
                    }
                    Collections.sort(sortedWagony);

                    for(Wagon w: sortedWagony){
                        printWriter.println("                      " + w.toString());
                    }
                }
                printWriter.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");

                printWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }
}
