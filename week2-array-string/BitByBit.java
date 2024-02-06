import java.util.Scanner;

public class BitByBit {

    public static char or(char a, char b) {
        if (a == '1' || b == '1') {
            return '1';
        }

        if (a == '?' || b == '?') {
            return '?';
        }

        return '0';

    }

    public static char and(char a, char b) {
        if (a == '0' || b == '0') {
            return '0';
        }
        if (a == '?' || b == '?') {
            return '?';
        }
        return '1';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            char[] microprocessor = { '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?',
                    '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?' };

            int numberOfOperation = sc.nextInt();

            if (numberOfOperation == 0) {
                sc.close();
                return;
            }

            for (int i = 0; i < numberOfOperation; i++) {
                String op = sc.next();
                if (op.equals("CLEAR")) {
                    int indexI = sc.nextInt();
                    microprocessor[indexI] = '0';
                }
                if (op.equals("SET")) {
                    int indexI = sc.nextInt();
                    microprocessor[indexI] = '1';
                }
                if (op.equals("OR")) {
                    int indexI = sc.nextInt();
                    int indexJ = sc.nextInt();
                    microprocessor[indexI] = or(microprocessor[indexI], microprocessor[indexJ]);

                }
                if (op.equals("AND")) {
                    int indexI = sc.nextInt();
                    int indexJ = sc.nextInt();
                    microprocessor[indexI] = and(microprocessor[indexI], microprocessor[indexJ]);

                }

            }
            System.out.println(new StringBuilder(new String(microprocessor)).reverse());

        }

        sc.close();

    }
}
