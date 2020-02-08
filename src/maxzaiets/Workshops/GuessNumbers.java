package maxzaiets.Workshops;

import java.util.Random;
import java.util.Scanner;

public class GuessNumbers {

    public static void main(String[] args) {

        int randomNumber = getRandomNumber();
        int userNumber;

        do {
            userNumber = getUserNumber();
            resolveUserNumber(userNumber, randomNumber);
        } while (!shouldStop(userNumber, randomNumber));
    }


    private static boolean shouldStop(int userNumber, int randomNumber) {
        return userNumber == randomNumber;
    }


    private static void resolveUserNumber(int userNumber, int randomNumber) {
        if (userNumber > randomNumber) {
            System.out.println("Za dużo");
        } else if (userNumber < randomNumber) {
            System.out.println("Za mało");
        } else {
            System.out.println("Zgadłeś! To: " + randomNumber);
        }
    }

    private static int getUserNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę od 1 do 1000: ");
        // TODO: W przyszłości zmienić na pętlę, aby
        //       użytkownik musiał podać liczbę
        return scanner.nextInt();
    }

    private static int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(1000) + 1;
    }
}
