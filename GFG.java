import java.util.Scanner;

public class GFG {

    public static void

            guesstheNumber()

    {

        Scanner sc = new Scanner(System.in);

        int num = 1 + (int) (100

                * Math.random());

        int S = 6;

        int i, guess;

        System.out.println(

                "A number is chosen"

                        + " between 1 to 120."

                        + "Guess the number"

                        + " within 6 trials.");

        for (i = 0; i < S; i++) {

            System.out.println(

                    "Guess the number:");

            guess = sc.nextInt();

            if (num == guess) {

                System.out.println(

                        "Congratulations!"

                                + " You have guessed the number correctly.");

                break;

            }

            else if (num > guess

                    && i != S - 1) {

                System.out.println(

                        "The number is "

                                + "greater than " + guess);

            }

            else if (num < guess

                    && i != S - 1) {

                System.out.println(

                        "The number is"

                                + " less than " + guess);

            }

        }

        if (i == S) {

            System.out.println(

                    "You have exhausted"

                            + " S trials.");

            System.out.println(

                    "The number was " + num);

        }

    }

    public static void

    main(String arg[])

    {
 

        

        guesstheNumber();

    }
}
