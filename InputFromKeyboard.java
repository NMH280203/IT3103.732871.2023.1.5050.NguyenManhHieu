
//Nguyen Manh Hieu 20215050
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); // new scanner
        //String strName ; int iAge ; double dHeight;

        System.out.println("What's your name?");
        String strName = keyboard.nextLine(); //input name
        System.out.println("How old are you");
        int iAge = keyboard.nextInt();  // input age
        System.out.println("How tall are you(cm)?");
        double dHeight = keyboard.nextDouble(); //input height

        System.out.println("Mr. " + strName + ", " + iAge + "years old."
                        + "Your height is "+ dHeight+".");
        keyboard.close();
    }
}

