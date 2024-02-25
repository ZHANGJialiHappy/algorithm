import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;

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

    private static void getNameWithGrade(HashMap<String, Integer> nameWithGrade, String name, String grade) {
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

    private static void sortbyvalue(HashMap<String, Integer> nameWithGrade) {
        // sort by HashMap's value
        List<Map.Entry<String, Integer>> list = new ArrayList<>(nameWithGrade.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int grade1 = o1.getValue();
                int grade2 = o2.getValue();
                if (grade1 == grade2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }

        });

        // print name by sortings
        for (Map.Entry<String, Integer> eachStudent : list) {
            System.out.println(eachStudent.getKey());
        }
    }

    private static void pqsort(HashMap<String, Integer> nameWithGrade) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

            @Override
            public int compare(String name1, String name2) {
                int grade1 = nameWithGrade.get(name1);
                int grade2 = nameWithGrade.get(name2);
                if (grade1 == grade2) {
                    return name1.compareTo(name2);
                }
                return grade2 - grade1;
            }
        });
        for (Map.Entry<String, Integer> eachStudent : nameWithGrade.entrySet()) {
            pq.offer(eachStudent.getKey());
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();

        // use HashMap to sort key(students' name)
        HashMap<String, Integer> nameWithGrade = new HashMap<>();

        // convert grade into int;
        for (int i = 0; i < studentNum; i++) {
            String name = sc.next();
            String grade = sc.next();
            getNameWithGrade(nameWithGrade, name, grade);
        }

        // sortbyvalue(nameWithGrade);
        pqsort(nameWithGrade);

        sc.close();
    }
}
