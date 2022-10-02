/**
 * Author: Dana Zhang
 * Date: 1/27/2020
 */
abstract class AbstractSorter {
    public abstract void sort(int[] arr);
    public void runSorter(int[] arr) {
        System.out.format("Before %s: ", this.getClass().getSimpleName());
        printArray(arr);
        System.out.format("After %s: ", this.getClass().getSimpleName());
        sort(arr);
        printArray(arr);
    }
    private void printArray(int[] arr)
    {
        for (int e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
