class MaxHeap {
    int size;
    Comparable[] items;
    int count = 0;

    public MaxHeap(int heapSize){
        items = new Comparable[heapSize];
        size = heapSize;
    }

    public MaxHeap(Comparable[] arr){
        size = count = arr.length;
        items = arr;
    }

    public static void main(String[] args){
        MaxHeap heapOne = new MaxHeap(10);
        System.out.println("Adding 10, 20, 90 and 50 to a MaxHeap");
        heapOne.enqueueMax(10);
        heapOne.enqueueMax(20);
        heapOne.enqueueMax(90);
        heapOne.enqueueMax(50);

        for(int i=0; i<heapOne.count; i++){
            System.out.print(heapOne.items[i] + " ");
        }
        System.out.println();

        System.out.println("Dequeue " + heapOne.dequeueMax() + " from the Heap");

        for(int i=0; i<heapOne.count; i++){
            System.out.print(heapOne.items[i] + " ");
        }
        System.out.println();
    }

    public void enqueueMax(Comparable value){
        if(count == size) throw new IllegalStateException();
        items[count] = value;
        count++;
        heapifyUp(count - 1);
    }

    private void swap(int indexOne, int indexTwo){
        Comparable temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void heapifyUp(int index){
        while(hasParent(index) && parent(index).compareTo(items[index]) < 0){
            swap(getParentIndex(index), index);
        }
    }

    private int getParentIndex(int childIndex){ return (childIndex - 1) / 2; }
    private boolean hasParent(int index){ return getParentIndex(index) >= 0; }
    private Comparable parent(int index) { return items[getParentIndex(index)]; }

    public Comparable dequeueMax(){
        if(count == 0) throw new IllegalStateException();

        Comparable temp = items[0];
        items[0] = items[count - 1];
        count--;

        heapifyDown(0);
        return temp;
    }

    private void heapifyDown(int index){
        while(hasLeftChild(index) && leftChild(index).compareTo(items[index]) > 0){
            swap(getLeftChildIndex(index), index);
        }
    }

    private int getLeftChildIndex(int index){ return 2 * index + 1; }
    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) >= 0; }
    private Comparable leftChild(int index){ return items[getLeftChildIndex(index)]; }

    public Comparable findMax(){
        return items[0];
    }
}