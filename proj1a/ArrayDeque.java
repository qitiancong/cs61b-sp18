public class ArrayDeque<T> {
    private T[] array;
    private  int size;
    private int nextFirst; // index of next first item in current array.
    private int nextLast;
    private int[] sequence; //keep track of the sequence of insertion,store index of underlying array.
    private int sequence_index; // keep track of where to insert into sequence.

    /** constructor for an empty List */
    public ArrayDeque() {
        this.array = (T[]) new Object[10];
        size = 0;
        this.nextFirst = 4; //start from 4th and 5th index in the array.
        this.nextLast = 5;
    }

    /** helper method. Resize underlying array to given capacity. */
    private  void resize(int capacity) {
        T[] new_array = (T[]) new Object[capacity];
        System.arraycopy(this.array, 0, new_array, capacity / 4, this.size);
        this.array = new_array;
        this.nextFirst = capacity / 4 - 1;
        this.nextLast = this.nextFirst + this.size + 1;
    }


    public void addFirst(T item) {
        //TODO
        //need to resize when array is full.
        if (this.size == this.array.length) {
            this.resize(this.size * 2);
        }
        this.array[this.nextFirst] = item;
        if (this.nextFirst == 0) {
            this.nextFirst = this.array.length - 1; //Loop to the end of array.
        } else {
            this.nextFirst -= 1;
        }
        this.size += 1;
    }

    public void addLast(T item) {
        //TODO
        //need to resize when array is full.
        if (this.size == this.array.length) {
            this.resize(this.size * 2);
        }
        this.array[this.nextLast] = item;
        if(this.nextLast == this.array.length - 1) {
            this.nextLast = 0; //Loop to the front of array.
        } else {
            this.nextLast += 1;
        }
        this.size += 1;
    }

    public boolean isEmpty() {
        //TODO
        return this.size == 0;
    }
//
    public int size() {
        //TODO
        return this.size;
    }
//
    public void printDeque() {
        //TODO
        int index = this.nextLast - 1;  //caution: if nextFirst is at the back , will have problem.
        while(this.array[index] != null) {
            System.out.print(this.array[index] + " ");
            if (index == 0) { //index reached the end
                index = this.array.length - 1; //start from the back again
            } else {
                index -= 1;
            }
        }
    }
//
//    public T removeFirst() {
//        //TODO
//    }
//
//    public T removeLast() {
//        //TODO
//    }
//
//    public T get(int index) {
//        //TODO
//    }

    public static void main (String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        s.addFirst(5);
        s.addFirst(6);
        s.addFirst(7);
//        s.addFirst(8);
//        s.addFirst(9);
//        s.addFirst(10);
//        s.addFirst(11);
//        s.addFirst(12);

        s.printDeque();
    }

}
