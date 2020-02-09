package maxzaiets.Workshops;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto2 {

    public static void main(String[] args){

        System.out.println("Hello! Can you guess all of my 6 numbers?\nPlease choose numbers from 1 to 49 and do not try to put two same numbers. I WILL KNOW");

        int[] userInput = getUserNumbers();
        int[] luckyNums = randomArray();
        Arrays.sort(userInput);

        System.out.println("Here are your bets: " + Arrays.toString(userInput));
        System.out.println("And here are my numbers: " + Arrays.toString(luckyNums));

        System.out.println(check(userInput, luckyNums));
    }





    private static int[] getUserNumbers() {
        boolean isGoodNumber = false;
        int[] user = new int[6];
        int[] range = new int[49];

        for (int i = 0; i < range.length; i++) {
            range[i] = i + 1;
        }

        int turns = 1;

        while (turns != 7) {
            System.out.print("Please enter number " + turns + " : ");
            Scanner scanner = new Scanner(System.in);

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Don't try to fool me! Enter a number! Please enter number " + turns + " again: ");
            }

            int chosenNumber = scanner.nextInt();

            if (Arrays.binarySearch(range, chosenNumber) >= 0) {
                boolean test = false;
                for (int element : user) {
                    if (element != chosenNumber) {
                        test = true;
                    } else {
                        test = false;
                        break;
                    }
                }
                if (test) {
                    user[turns - 1] = chosenNumber;
                    turns++;
                } else {
                    System.out.println("Pls do not try to put the same numbers twice!");
                }
            }
        }
        return user;
    }



    private static int[] randomArray() {       //returns random array with non-repeating elements
        int[] randomTab = new int[6];
        Integer[] possible = new Integer[49];

        for (int i = 0; i < possible.length; i++) {
            possible[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(possible));    //creates new List-class object from array of ints


        for (int i = 0; i < randomTab.length; i++) {
            randomTab[i] = possible[i];       //takes first 6 numbers of randomized array and pastes it to array
        }
        Arrays.sort(randomTab);  //ascending sort
        return randomTab;
    }

    public static String check(int[] userBets, int[] randomizedArray){
        int guesses = 0;
        String message;

        for (int i = 0; i < userBets.length; i++){
            if (Arrays.binarySearch(randomizedArray, userBets[i]) >= 0){
                guesses ++;
            }
        }


        switch (guesses){
            case 3:
                message = "Well done! Well, not so well at all but not bad";
                break;
            case 4:
                message = "Wow! 4 out of 6!";
                break;
            case 5:
                message = "Brilliant! 5 out of 5! Hope you are proud of yourself";
                break;
            case 6:
                message = "Nani? How's this possible? 6 out of 6!";
                break;
            default:
                message = "Loser! Ez 4 Me!";
        }
        return message;
    }

}
