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
        if (searchFloor >= floors.length) {
            searchFloor = floors.length - 1;
        }

        return findFloorInLogN(floors, searchFloorWithoutEgg, searchFloor);
    }

    private static int findFloorInLogN(int[] a, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < 1) {
                lo = mid + 1;
            } else if (a[mid] > 1) {
                hi = mid - 1;
            } else {
                if (lo == hi) {
                    return lo;
                }
                hi = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] b = new int[] { 0, 0, 0 };
        System.out.println(findFloorInCLogF(b));
    }
}
