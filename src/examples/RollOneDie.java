package examples;

import java.util.Scanner;

public class RollOneDie {
    private static int rollCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game, Roll-A-Die!");
        printRules();
        System.out.println();

        playOneDie();

        System.out.println();
        System.out.println("Thank you for playing, Roll-A-Die!");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Roll-A-Die!");
        System.out.println("The Player rolls a die, as long as he wishes!");
        System.out.println("=====================================================");
    }

    private static void playOneDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll-A-Die? ('yes/no') ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int face = rollDie();
            System.out.println("You rolled: " + face);
            System.out.println();

            updateStatistics();

            System.out.print("Roll-A-Die? ('yes/no') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Number of times rolled:", rollCount);
    }

}
