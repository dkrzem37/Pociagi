import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ZapisywanieSkladowDoPliku implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                PrintWriter printWriter = new PrintWriter(new FileOutputStream("C:\\Users\\danio\\IdeaProjects\\GUI_project\\src\\AppState.txt", true));
                printWriter.println("readable?");

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
