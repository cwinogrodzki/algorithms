/**
Claire Winogrodzki
Binary Search Algorithm
This program uses an iterative version and a recursive version of a binary search
to scan a pre-sorted array for a given value.
 */

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 4, 10, 40};
        int x = 10;
        for(int i = 0; i < arr.length; i ++){ System.out.print(arr[i] + " ");}
        System.out.println("\nSearch for: " + x);

        //run iterative
        int result = binarySearch(arr, x);
        System.out.println("Iterative binary search: ");
        if (result == -1)
            System.out.println("Element not found in array");
        else
            System.out.println("Element found at " + "index " + result);

        // run recursive version
        result = binarySearch(arr, 0, arr.length, x);
        System.out.println("Recursive binary search: ");
        if (result == -1)
            System.out.println("Element not found in array");
        else
            System.out.println("Element found at " + "index " + result);
    }


    /**
     * Recursive binary search
     * @param arr - a given sorted array
     * @param left - left/beginning index of the array/subarray
     * @param right - right/ending index of the array/subarray
     * @param target - target element to search for in the array
     * @return index of the first occurrence of target; -1 if not found
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return binarySearch(arr, left, mid - 1, target);
            }
            return binarySearch(arr, mid + 1, right, target);
        }
        return -1;
    }


    /**
     * Iterative binary search
     * @param arr - a given sorted array
     * @param target - target element to search for in the array
     * @return index of the first occurrence of target; -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length -1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(arr[mid] == target){
                return mid;}
            if(arr[mid] > target){
                r = mid - 1;}
            else{
                l = mid + 1;}
        }
        return -1;
    }

}