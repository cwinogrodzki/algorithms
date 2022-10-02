/**
 Claire Winogrodzki
 Sorting Algorithms
 This is a collection of sorting algorithm classes, including Bubble Sort,
 Selection Sort, Insertion Sort, Merge Sort, Heap Sort, and Quick Sort.
 They are extensions of the AbstractSorter class. This program will run each
 algorithm by sorting an array, and will print the array before and after sorting.
 */
public class Sorter {

    static class BubbleSort extends AbstractSorter {
        public void sort(int[] arr) {
            boolean swapped;
            int n = arr.length;
            for(int i = 0; i <= n-1; i++){
                swapped = false;
                for(int j = 1; j <= n-i-1; j++){
                    if(arr[j - 1] > arr[j]){
                        //swap
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        swapped = true;
                    }
                }
                if(!swapped) break;
            }
        }
    }

    static class SelectionSort extends AbstractSorter {
        public void sort(int[] arr) {
            int n = arr.length;
            for(int i = 0; i <= n - 1; i++){
                int minFirst = i;

                for(int j = i+1; j <= n - 1; j++){
                    if(arr[j] < arr[minFirst]) minFirst = j;
                }
                //swap
                int temp = arr[i];
                arr[i] = arr[minFirst];
                arr[minFirst] = temp;
            }
        }
    }

    static class InsertionSort extends AbstractSorter {
        public void sort(int[] arr) {
            int n = arr.length;
            for(int i = 1; i <= n - 1; i++){
                int key = arr[i];
                int j = i-1;
                while(j >= 0 && arr[j] > key){
                    arr[j + 1] = arr[j];
                    j = j-1;
                }
                arr[j + 1] = key;
            }
        }
    }

    static class MergeSort extends AbstractSorter {
        public void sort(int[] arr){
            int start = 0;
            int end = arr.length - 1;
            mergeSort(arr, start, end);
        }

        public void mergeSort(int[] arr, int start, int end){
            if(start < end) {
                int mid = (start + end) / 2;
                mergeSort(arr, start, mid); //sort left array
                mergeSort(arr, mid + 1, end); //sort right array
                merge(arr, start, mid, end); //merge left and right
            }
        }

        public void merge(int[] arr, int start, int mid, int end){
            int temp[] = new int[end - start + 1]; //temp array
            int i = start, j = mid + 1, k = 0; //pointers

            //traverse left and right and add smaller value to temp
            while(i <= mid && j <= end){
                if(arr[i] <= arr[j]){
                    temp[k] = arr[i];
                    k ++; i++;
                }
                else{
                    temp[k] = arr[j];
                    k++; j++;
                }
            }

            //add elements from left array
            while(i <= mid){
                temp[k] = arr[i];
                k ++; i++;
            }

            //add elements from right array
            while(j <= end){
                temp[k] = arr[j];
                k++; j++;
            }

            //replace original with temp
            for(i = start; i <= end; i+= 1){
                arr[i] = temp[i - start];
            }
        }
    }

    static class HeapSort extends AbstractSorter {
        public void sort(int[] arr) {
            heapsort(arr);
        }

        /**
         * The main heap sort algorithm that builds a max heap and recursively sorts the root of heap
         * @param arr - the array to be sorted
         */
        void heapsort(int[] arr)
        {
            int n = arr.length;
            for(int i = (n/2)-1; i >= 0; i--){ //build the heap
                heapify(arr, n, i);
            }
            for(int i = n-1; i >= 0; i--){ //remove and replace root
                //swap(arr[0], arr[i])
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
                //print each iteration
                /*for(int j = 0; j < arr.length; j++){
                    System.out.print(arr[j]);
                }
                System.out.println();*/
            }
        }

        /**
         * A helper method that recursively constructs a given heap to a valid heap
         * @param arr - the array representation of the heap
         * @param n - size of the array
         * @param i - index of the root of the sub-heap
         */
        void heapify(int[] arr, int n, int i)
        {
            int largest = i;
            int l = (2*i) + 1;
            int r = (2*i) + 2;
            if(l<n && arr[l] > arr[largest]){
                largest = l;
            }
            if(r < n && arr[r] > arr[largest]){
                largest = r;
            }
            if(largest != i){
                //swap(arr[i], arr[largest])
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(arr, n, largest); //recursive
            }
        }
    }

    static class QuickSort extends AbstractSorter {

        public void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        /**
         * A divide-and-conquer algorithm for recursively sorting an array into partitions defined by a pivot
         * @param arr - array to be sorted
         * @param start - index of the first element of the array or sublist
         * @param end - index of the last element of the array or sublist
         */
        void sort(int[] arr, int start, int end)
        {
            if(start < end){
                int pivot = partition(arr, start, end);
                sort(arr, start, pivot-1);
                sort(arr, pivot+1, end);
            }
        }

        /**
         * A helper method for partitioning the array into two sublists around a pivot
         * @param arr - array to be sorted
         * @param start - starting (left) index of the array/sublist
         * @param end - ending (right) index of the array/sublist
         * @return index of the pivot that separates the partitions
         */
        int partition(int[] arr, int start, int end)
        {
            int pivot = arr[end];
            int i = start-1; //i = smaller pointer

            //compare all elements to pointer
            for(int j = start; j < end; j++){ //j = larger pointer
                if(arr[j] <= pivot){
                    //swap greater with smaller
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            //put pivot in correct position
            int temp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = temp;
            return i+1; //returns pivot
        }
    }


    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {8, 4, 5, 3, 2, 7, 1, 0, 10, 9};

        AbstractSorter insertionSort = new InsertionSort();
        insertionSort.runSorter(arr1);

        int[] arr2 = {10, 9, 8, 4, 5, 3, 2, 7, 1};

        AbstractSorter selectionSort = new SelectionSort();
        selectionSort.runSorter(arr2);

        int[] arr3 = {9, 2, 8, 10, 4, 5, 3, 2, 7, 1};

        AbstractSorter bubbleSort = new BubbleSort();
        bubbleSort.runSorter(arr3);

        int[] arr4 = {9, 2, 8, 10, 4, 5, 3, 2, 7, 1};

        AbstractSorter mergeSort = new MergeSort();
        mergeSort.runSorter(arr4);

        int[] arr5 = {33, 1000, 1000, 0, -1, 4, 79};

        AbstractSorter heapSort = new HeapSort();
        heapSort.runSorter(arr5);

        int[] arr6 = {34, 34, 5, 14, 2, 0, 100, 8, 10, 19};

        AbstractSorter quickSort = new QuickSort();
        quickSort.runSorter(arr6);

    }
}

