import java.util.Scanner;
import java.util.TreeMap;

public class Grade2 implements Comparable<Grade2> {
    private TreeMap<String, Integer> nameWithGrade = new TreeMap<>();

    @Override
    public int compareTo(Grade2 that) {
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();

        // convert grade into int;
        for (int i = 0; i < studentNum; i++) {
            String name = sc.next();
            String grade = sc.next();
        }

        sc.close();
    }
}