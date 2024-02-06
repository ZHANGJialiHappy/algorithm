public class CirculString {
    public boolean isCircul(String a, String b) {
        char firstLetterB = b.charAt(0);
        int firstLetterOccurrences = occurences(a, firstLetterB);

        if (firstLetterOccurrences <= 0) {
            return false;
        }
        for (int i = 1; i <= firstLetterOccurrences; i++) {
            int index = a.indexOf(Character.toString(firstLetterB), i);
            String c = a.substring(index) + a.substring(0, index);
            if (c.equals(b)) {
                return true;
            }
        }
        return false;
    }

    private int occurences(String a, char c) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public boolean isCircul2(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }

    public static void main(String[] args) {
        // System.out.println(occurences("cccasc", 'c'));
        CirculString m = new CirculString();
        System.out.println(m.isCircul2("ACTGATG", "TGATGAC"));
    }

}
