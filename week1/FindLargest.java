package week1;

public class FindLargest {

    public int findLargest(int base, int N) {
        int count = 0;
        if (base > N) {
            return count;
        }
        while (N > 1) {
            N = N / base;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        FindLargest a = new FindLargest();
        System.out.println(a.findLargest(8, 9));
    }
}