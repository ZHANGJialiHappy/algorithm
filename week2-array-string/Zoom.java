import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int compressedBy = sc.nextInt();

        List<Integer> listOfNumber = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            int number = sc.nextInt();
            if (i % compressedBy == 0) {
                listOfNumber.add(number);
            }
        }
        String seperator = "";
        for (int i = 0; i < listOfNumber.size(); i++) {
            System.out.print(seperator + listOfNumber.get(i));
            seperator = " ";
        }
        sc.close();
    }
}
