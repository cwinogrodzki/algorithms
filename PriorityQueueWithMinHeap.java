/*
Claire Winogrodzki
A priority queue implemented with a min heap structure. Each element's priority
is determined by its numerical value- smaller elements have higher priority.
The root of the min heap will have highest priority (It is the smallest number).
This program includes enqueue and dequeue functions, and a function to remove a
specific element. The driver method creates two example priority queues and
performs operations on each.
3/16/2021
 */

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueWithMinHeap {

    List<Integer> arr; // use a dynamic array to represent the internal heap data structure

    /**
     * A default constructor
     */
    public PriorityQueueWithMinHeap() {
        arr = new ArrayList<>();
    }

    /**
     * A constructor that builds a PQ with a single element
     * @param data - used to initialize a PQ with one element
     */
    public PriorityQueueWithMinHeap(int data) {
        arr = new ArrayList<>();
        arr.add(data);
    }

    /**
     * Get element with the highest priority, i.e., the smallest number in the PQ, in O(1) time
     * @return element with the highest priority or null if the PQ is empty
     */
    public Integer peek() {
        if(!arr.isEmpty()){
            int min = arr.get(0);
        }
        return null;
    }


    /**
     * A helper method to reconstruct the min heap (hint: this will be used by enqueue, dequeue, and remove)
     * @param i - start heapifying from element at index i
     */
    public void heapify(int i) {
        //check if at least 2 elements first
        if (arr.size() >= 2) {

            //bubble up if i > 0
            if (arr.get(i) < arr.get((i - 1) / 2)) {

                while (i > 0 && arr.get((i - 1) / 2) > arr.get(i)) {
                    swap((i - 1) / 2, i);
                    //update i to parent
                    i = ((i - 1) / 2);
                }
            }

            //bubble down if i == 0
            else if (i == 0) {
                int min = i;
                int l = (2 * i) + 1;
                int r = (2 * i) + 2;

                if (l < arr.size() && arr.get(l) < arr.get(min)) {
                    min = l;
                }

                if (r < arr.size() && arr.get(r) < arr.get(min)) {
                    min = r;
                }

                if (i != min) {
                    swap(i, min);
                    //recursively heapify
                    heapify(min);
                }
            }
        }
    }


    /**
     * Add a single element to the PQ in O(Log(n)) time
     * Make sure the heap invariant is maintained after this method is called
     * @param element - element to be inserted to the PQ
     */
    public void enqueue(int element) {
        arr.add(element);
        int i = arr.size() - 1;
        heapify(i); //bubble up
    }


    /**
     * Removes the specified element in the PQ in O(n) time
     * @param element
     * @return true if the element was removed successfully and false otherwise
     */
    boolean removeElement(int element) {
        try {
            int i = arr.indexOf(element);
            arr.set(i, arr.get(arr.size() - 1)); //swap with last element
            arr.remove(arr.size() - 1); //remove last element
            heapify(i);
            if (arr.get(i) != element) return true;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Element " + element + " is invalid: can't be removed");
        }
        return false;
    }

    /**
     * Removes element with the highest priority, i.e., the smallest number in the PQ, in O(Log(n)) time
     * Make sure the heap invariant is maintained after this method is called
     * @return element with the highest priority or null if the heap is empty
     */
    public Integer dequeue() {
        if(!arr.isEmpty()){
            int min = arr.get(0);
            arr.set(0, arr.get(arr.size()-1)); //swap with last element
            arr.remove(arr.size()-1); //remove last
            heapify(0);
            heapify(arr.size()-1);
            return min;
        }

        return null;
    }

    public void swap(int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * A helper function to print out the internal array representation
     * The console output should provide a valid heap
     */
    void printHeap() {
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        PriorityQueueWithMinHeap h = new PriorityQueueWithMinHeap();
        h.enqueue(3);
        h.enqueue(4);
        h.enqueue(9);
        h.enqueue(5);
        h.enqueue(2);

        System.out.println("Min-Heap array: ");
        h.printHeap();

        h.dequeue();
        System.out.println("After dequeuing: ");
        h.printHeap();

        h.enqueue(9);
        System.out.println("After enqueuing 9: ");
        h.printHeap();

        h.removeElement(2);
        System.out.println("Dequeue 3 times: ");
        h.dequeue();
        h.printHeap();
        h.dequeue();
        h.printHeap();
        h.dequeue();
        //System.out.println("After deleting an element: ");
        h.printHeap();
        
        PriorityQueueWithMinHeap pq = new PriorityQueueWithMinHeap();
        pq.enqueue(3);
        pq.enqueue(5);
        pq.enqueue(2);
        pq.enqueue(1);
        pq.enqueue(4);
        System.out.println("\nNew min-heap");
        pq.printHeap();

        pq.removeElement(2);
        System.out.println("After removing 2:");
        pq.printHeap();

        System.out.println("Dequeue twice");
        pq.dequeue();
        pq.printHeap();
        pq.dequeue();
        pq.printHeap();
    }
}
