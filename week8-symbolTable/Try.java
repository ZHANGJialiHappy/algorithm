import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Try {

    public static void main(String[] args) {
        // String a;
        // String b = "b";
        // String c;
        // a = b;
        // c = b;
        // System.out.println(a.equals(c));

        Map<String, Integer> hashmap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String key = sc.nextLine();
            hashmap.put(key, hashmap.getOrDefault(key, 0) + 1);
        }
        String max = "";
        hashmap.put(max, 0);
        for (String key : hashmap.keySet()) {
            if (hashmap.get(key) > hashmap.get(max)) {
                max = key;
            }
        }
        System.out.println(max + " " + hashmap.get(max));
        System.out.println(hashmap);
    }

}
