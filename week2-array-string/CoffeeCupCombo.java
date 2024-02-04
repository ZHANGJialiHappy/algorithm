import java.util.Scanner;

public class CoffeeCupCombo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCourse = Integer.parseInt(sc.nextLine());
        String codeForCourse = sc.nextLine();

        if (codeForCourse.length() != numberOfCourse) {
            System.out.println("the String length should be " + numberOfCourse);
        }

        int result = 0;

        if (numberOfCourse == 1) {
            if (codeForCourse.equals("1")) {
                result++;
            }
            sc.close();
            System.out.println(result);
            return;
        }

        StringBuilder codeForCaffee = new StringBuilder(codeForCourse);
        for (int i = 0; i < numberOfCourse - 2; i++) {
            if (codeForCourse.charAt(i) == '1') {
                codeForCaffee.setCharAt(i + 1, '1');
                codeForCaffee.setCharAt(i + 2, '1');
            }
        }

        if (codeForCourse.charAt(numberOfCourse - 2) == '1') {
            codeForCaffee.setCharAt(numberOfCourse - 1, '1');
        }
        sc.close();

        for (int i = 0; i < codeForCaffee.length(); i++) {
            if (codeForCaffee.charAt(i) == '1') {
                result++;
            }
        }
        System.out.println(result);

    }
}
