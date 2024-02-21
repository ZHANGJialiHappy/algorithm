import java.util.Arrays;

public class FindFloor {

    public static int findFloorInCLogF(int[] floors) {
        if (floors[0] == 1) {
            return 0;
        }
        int searchFloor;
        for (searchFloor = 1; searchFloor < floors.length; searchFloor *= 2) {
            if (floors[searchFloor] == 1) {
                break;
            }
        }
        int searchFloorWithoutEgg = searchFloor / 2;

        return findFloorInLogN(floors, searchFloorWithoutEgg, searchFloor);
    }

    private static int findFloorInLogN(int[] a, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] b = new int[] { 0, 1, 1, 1, 1, 1, 1 };
        System.out.println(findFloorInCLogF(b));
    }
}
