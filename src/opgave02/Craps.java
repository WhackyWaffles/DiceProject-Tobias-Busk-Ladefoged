package opgave02;

import java.util.Scanner;

public class Craps {
    private static int rollCount = 0;
    private static int rollSum;
    private static int pointNumber = 0;
    private static boolean winCon = false;
    private static boolean loseCon = false;
    private static int loseCount = 0;
    private static int winCount = 0;
    private static int totalRollCount = 0;

    public static void main(String[] args) {
        printRules();
        playCraps();
    }

    private static void printRules() {
        System.out.println();
        System.out.printf("%32s", "WELCOME TO CRAPS!\n");
        System.out.println("          The Player rolls two dice.");
        System.out.println("          The first roll is called the Come Out Roll.");
        System.out.println("          If it is a 7 or 11, you WIN!");
        System.out.println("          If it is a 2, 3 or 12, you LOSE!");
        System.out.println("          If it has any other outcome (4, 5, 6, 8, 9, 10),");
        System.out.println("          this outcome becomes the Point Number.");
        System.out.println("          You Win if you roll the Point Number again.");
        System.out.println("          But now you Lose if you roll 7!");
        System.out.println();
        System.out.println("     =====================================================");
        System.out.println();
    }

    private static int[] rollDice() {
        int[] faces = new int[2];
        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);
        return faces;
    }

    private static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%35s", "THE COME OUT ROLL!");
        System.out.println();
        System.out.printf("%45s", "Press [ENTER] to Roll the dice!");
        System.out.println();
        String answer = scanner.nextLine();
        while (!answer.equals("EXIT")) {
            int[] faces = rollDice();
            rollSum = faces[0] + faces[1];
            rollCount++;
            totalRollCount++;
            System.out.println("          YOU ROLLED:     " + rollSum);
            System.out.println();

            if (rollCount == 1 && rollSum == 7) {
                winCon = true;
            } else if (rollCount == 1 && rollSum == 11) {
                winCon = true;
            } else if (rollCount == 1 && rollSum == 2) {
                loseCon = true;
            } else if (rollCount == 1 && rollSum == 3) {
                loseCon = true;
            } else if (rollCount == 1 && rollSum == 12) {
                loseCon = true;
            } else if (rollCount == 1) {
                pointNumber = rollSum;
                System.out.printf("%30s", "YOUR NUMBER IS \n");
                System.out.printf("%22s", rollSum);
                System.out.printf("\n%29s", "GET IT AGAIN!\n");
                System.out.printf("%26s", "[ENTER]\n");
            }
            if (rollForPoint(rollSum)) {
                winCon = true;
            } else if (rollCount > 1 && rollSum == 7) {
                loseCon = true;
            } else if (rollCount > 1 && rollSum != pointNumber) {
                System.out.printf("%30s", "NOT YOUR NUMBER\n");
                System.out.printf("%28s", "[ROLL AGAIN]\n");
                System.out.println();
            }

            if (winCon == true || loseCon == true) {
                printResult();
                System.out.println("          PRESS [ENTER] TO PLAY AGAIN!");
                System.out.println();
                System.out.println("          Type [EXIT] to stop playing.");
                System.out.println();
                System.out.println("     =====================================================");

            }
            answer = scanner.nextLine();
        }
        endResult();
    }

    public static boolean rollForPoint(int point) {
        boolean rollForPoint = false;
        if (rollCount > 1 && point == pointNumber) {
            rollForPoint = true;
        }
        return rollForPoint;
    }

    private static void printResult() {
        if (winCon == true) {
            System.out.println("     =====================================================");
            System.out.println();
            System.out.printf("%34s", "YOU WIN!\n");
            System.out.println();
            System.out.println("     =====================================================");
            System.out.println();
            winCount++;
        } else if (loseCon == true) {
            System.out.println("     =====================================================");
            System.out.println();
            System.out.printf("%34s", "YOU LOSE!\n");
            System.out.println();
            System.out.println("     =====================================================");
            System.out.println();
            loseCount++;
        }
        winCon = false;
        loseCon = false;
        rollCount = 0;
        pointNumber = 0;
        rollSum = 0;
    }

    private static void endResult() {
        System.out.println();
        System.out.println("          Thank you for playing!");
        System.out.println();
        System.out.println("          You won " + winCount + " times.");
        System.out.println("          You lost " + loseCount + " times.");
        System.out.println("          You rolled " + totalRollCount + " times.");
    }
}