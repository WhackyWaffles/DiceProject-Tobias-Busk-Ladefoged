package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int totalRollSum = 0;
    private static int pairsCount = 0;
    private static int highestRoll = 0;
    private static int[] eyesCounter = new int[6];

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the game, Roll-2-Die!");
        System.out.println();
        System.out.println("Successor of the Popular game Roll-A-Die!");
        System.out.println();
        System.out.println();
        printRules();
        System.out.println();

        play2Die();

        System.out.println();
        System.out.println();
        System.out.println("Thank you for playing, Roll-2-Die!");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println();
        System.out.println("Rules of Roll-2-Die!");
        System.out.println("The Player rolls TWO dice, as long as he wishes!");
        System.out.println();
        System.out.println("=====================================================");
    }

    private static void play2Die() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll-2-Die?    Yes = [ENTER] / No = [EXIT] + ENTER");
        System.out.println();
        String answer = scanner.nextLine();
        while (!answer.equals("EXIT")) {
            int[] faces = rollDice();
            System.out.println("YOU ROLLED: " + faces[0] + " AND " + faces[1]);
            System.out.println();

            updateStatistics(faces);

            System.out.print("Roll-2-Die?    Yes = [ENTER] / No = [EXIT] + ENTER");
            System.out.println();
            System.out.println();
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] faces = new int[2];
        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);
        return faces;
    }

    private static void updateStatistics(int[] faces) {
        rollCount++;
        totalRollSum += faces[0] + faces[1];
        if (faces[0] == faces[1])
            pairsCount++;
        if (highestRoll < faces[0] + faces[1]) {
            highestRoll = faces[0] + faces[1];
        }
        for (int i = 0; i < faces.length; i++) {
            eyesCounter[faces[i] - 1]++;
        }
    }

    private static void printStatistics() {
        System.out.println("\nRESULTS:");
        System.out.println("=====================================================");
        System.out.printf("\n%27s %10d\n", "Times rolled: ", rollCount);
        System.out.printf("\n%27s %10d\n", "Total value rolled: ", totalRollSum);
        System.out.printf("\n%27s %10d\n", "Number of pairs rolled: ", pairsCount);
        System.out.printf("\n%27s %10d\n", "Highest roll: ", highestRoll);
        for (int i = 0; i < 6; i++) {
            System.out.printf("\n%27s %10d", (i + 1) + "'s rolled: ", eyesCounter[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println("=====================================================");
    }
}
