package maxzaiets.Workshops;

import java.util.*;

public class Lotto {

    public static void main(String[] args) {
        int[] numbers = new int[49];

        int[] winningNumbers = new int[6]; //array holding 6 random numbers
        int[] userNumber = new int[6]; //array holding the input
        Scanner theNumbers = new Scanner(System.in);

        int guesses;
        int counter = 0;
        int i;

        //generate 6 random numbers
        for (i = 0; i < winningNumbers.length; i++) {
            int randomNums = new Random().nextInt(49) + 1;
            winningNumbers[i] = randomNums;
        }

        System.out.println("Enter the 6 numbers");


        for (i = 0; i < userNumber.length; i++) {
            guesses = theNumbers.nextInt();
            userNumber[i] = guesses;
            //here iterating through table of random ints and checking whether user guessed
            if (winningNumbers[i] == userNumber[i]) {
                counter += 1;
            }
        }

        if (counter == 3) {
            System.out.println("Well done! 3 out of 6!");
        } else if (counter == 4){
            System.out.println("Wow! Nicely done! 4 out of 6!");
        } else if (counter == 5){
            System.out.println("Gotta catch them all! 5 out of 6");
        } else if (counter == 6){
            System.out.println("6/6. Impossible. Please stop cheating");
        } else {
            System.out.println("Haha! Loser!");
        }

    }
}

