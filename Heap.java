/**
 * Heaps are data structures that operates like a tree except that 
 * the parent elements of a particular tree have values that are smaller or greater than any of its children
 * 
 * The children having values greater than the parent is called a MAX heap
 * The children having values lesser than the parent is called a MIN heap
 * 
 * The following is an example of a Min heap which upon reversing gives the max heap
 */
import java.util.Arrays;

class Heap {
    private int capacity = 10;
    private int size = 0;
    int [] items;

    public Heap(){
        items = new int[capacity];
    }

    public Heap(int[] arr){
        size = capacity = arr.length;
        items = arr;
        buildHeapToBottomUp();
    }

    public static void main(String[] args){
        Heap heap_one = new Heap();

        double startTime = System.nanoTime();
        heap_one.add(10);
        heap_one.add(15);
        heap_one.add(20);
        heap_one.add(17);
        heap_one.add(25);
        double endTime = System.nanoTime();

        System.out.println("Heap addition took " + (endTime - startTime) + " ms");

        for(int i = 0; i < 10; i++){
            System.out.print(heap_one.items[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Testing for array to heap");
        int[] arr = {70, 29, 68, 65, 32, 19, 16, 13, 26, 31};
        
        System.out.println("Original array");
        for(int i = 0; i < 10; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        startTime = System.nanoTime();
        Heap heap_two = new Heap(arr);
        endTime = System.nanoTime();
        System.out.println("Creating the heap took " + (endTime - startTime) + " ms");

        System.out.println("Final heap");
        for(int i = 0; i < 10; i++){
            System.out.print(heap_two.items[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Creating a sorted array");
        int[] arr2 = {13, 7, 5, 21, 45, 2, 17, 3, 11};
        Heap sortedHeap = new Heap(arr2);
        for(int i=0; i<arr2.length; i++){
            System.out.print(sortedHeap.poll() + " ");
        }
        System.out.println();
    }

    private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex){ return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex){ return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size; }
    private boolean hasParent(int index){ return getParentIndex(index) >= 0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if(size >= capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyDown(int index){
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void buildHeapToBottomUp(){
        /**
         * Start at the level containing the last non-leaf node i.e array[n/2]
         * Make the subtree rooted at the last non-leaf node into a heap by heapifyDown()
         * Move in current level from right to left
         */
        for(int i = (size / 2) - 1; i >= 0; i--){
            heapifyDown(i);
        }
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public int peek(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if(size == 0) throw new IllegalStateException();
        // What poll does is to remove the smallest value in this case the top parent of the heap which is at index 0
        // Normally, this could be done by shifting all elements to the left of the array but this is not efficient
        // instead we replace element at index 0 with the last element i.e element at size - 1
        int item = items[0];
        items[0] = items[size - 1];

        // then decrement the size
        size--;

        // call a heapifyDown() to control the heap size to decrease the capacity if capacity / 2 < size
        heapifyDown(0);
        return item;
    }
}