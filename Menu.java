import java.util.*;


public abstract class Menu {
    public static int wyborOpcjiZMenu(ArrayList<String> menu, String errorMessage) {
        int userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            for(String s: menu){
                System.out.println(s);
            }

            if(scanner.hasNextInt())
                userInput = scanner.nextInt();
            else {
                scanner.nextLine();
                userInput = -1;
                System.out.println(errorMessage);
                continue;
            }

            if(userInput < 0 || userInput > menu.size()) {
                System.out.println(errorMessage);
                userInput = -1;
                scanner.nextLine();
            }
        } while (userInput == -1);
        return userInput;
    }
    /*public static boolean wyborPoprawnejOpcji1(int najmOpcja, int najwOpcja){
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;
        if(scanner.hasNextInt())
            userInput = scanner.nextInt();

        if(userInput < najmOpcja || userInput > najwOpcja) {
            System.out.println("Wybierz jedna z opcji.");
            return false;
        }
        return true;
    }*/
    //Mozna stworzyc arraylist dla kazdego z poziomow menu i zamiast w main wrzucac do do while moglbym od razu stworzyc funkcje
    //wybor poprawnej opcji ktora bierze array z opcjami do siebie
    /*public static int wyborPoprawnejOpcji(int najmOpcja, int najwOpcja, String errorMessage){
        int userInput;
        Scanner scanner = new Scanner(System.in);
        try{
            userInput = scanner.nextInt();
        }catch(InputMismatchException e){
            scanner.nextLine();
            System.out.println(errorMessage);
            return -1;
        }
        if(userInput < najmOpcja || userInput > najwOpcja) {
            System.out.println(errorMessage);
            return -1;
        }
        return userInput;*/

        //FIX this shit, you are not scanning input
        //Actually I am, you dipshit
        /*int userInput = -1;
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt())
            userInput = scanner.nextInt();
            else
                return -1;

        if(userInput < najmOpcja || userInput > najwOpcja) {
            System.out.println("Wybierz jedna z opcji.");
            userInput = -1;
        }

        return userInput;*/
}
