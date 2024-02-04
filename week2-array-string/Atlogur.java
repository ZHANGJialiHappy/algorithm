import java.util.Scanner;

public class Atlogur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfKnights = sc.nextInt();
        int winnerCount = 1;
        int currentH = sc.nextInt();
        int currentS = sc.nextInt();

        for (int i = 2; i <= numberOfKnights; i++) {
            int competeH = sc.nextInt();
            int competeS = sc.nextInt();
            // current wins
            if ((int) Math.ceil((double) competeH / currentS) <= (int) Math.ceil((double) currentH / competeS)) {
                currentH = currentH - ((int) Math.ceil((double) competeH / currentS) - 1) * competeS;

            }
            // competitor wins
            else {
                currentH = competeH - (int) Math.ceil((double) currentH / competeS) * currentS;
                currentS = competeS;
                winnerCount = i;
            }
        }

        System.out.println(winnerCount);
        // System.out.println(currentH);
        // System.out.println(currentS);
        sc.close();
    }
}
