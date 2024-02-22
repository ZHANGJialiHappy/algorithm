import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Grade {
    private static int getOccurenceNumber(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();
        TreeMap<String, Integer> nameWithGrade = new TreeMap<>();

        // convert grade into int;
        for (int i = 0; i < studentNum; i++) {
            String name = sc.next();
            String grade = sc.next();
            int gradeinNumber = 0;
            if (grade.contains("FX")) {
                gradeinNumber = 50 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            } else if (grade.contains("A")) {
                gradeinNumber = 200 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            } else if (grade.contains("B")) {
                gradeinNumber = 170 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            } else if (grade.contains("C")) {
                gradeinNumber = 140 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            } else if (grade.contains("D")) {
                gradeinNumber = 110 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            } else if (grade.contains("E")) {
                gradeinNumber = 80 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            } else if (grade.contains("F")) {
                gradeinNumber = 20 - getOccurenceNumber(grade, '-') + getOccurenceNumber(grade, '+');
            }
            nameWithGrade.put(name, gradeinNumber);
        }

        // sort by Hashmap's value
        List<Map.Entry<String, Integer>> list = new ArrayList<>(nameWithGrade.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - (o1.getValue());
            }

        });

        // print name by sortings
        for (Map.Entry<String, Integer> eachStudent : list) {
            System.out.println(eachStudent.getKey());
        }
        sc.close();
    }
}
