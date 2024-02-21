public class compareTwoArrays {
    public static void compareTwoArraysMethod(int[] array1, int[] array2) {
        int array1Index = 0;
        int array2Index = 0;
        Integer matchValue = null;

        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                array1Index++;
            } else if (array2[array2Index] < array1[array1Index]) {
                array2Index++;
            } else {
                if (matchValue == null || matchValue != array1[array1Index]) {
                    matchValue = array1[array1Index];
                    System.out.println(array1[array1Index] + " ");
                }
                array1Index++;
                array2Index++;
            }

        }
    }

    public static void main(String[] args) {
        int[] array1 = { 0, 1, 2, 2, 5, 6, 6, 8, 25, 25 };
        int[] array2 = { -2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25 };
        compareTwoArraysMethod(array1, array2);

    }
}
