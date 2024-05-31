public class ArrayDeque<T> {
    private T[] array;
    private  int size;
    private int nextFirst; // index of next first item in current array.
    private int nextLast;

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
        System.arraycopy(this.array, this.nextFirst + 1, new_array, capacity / 4, this.size);
        this.array = new_array;
        this.nextFirst = capacity / 4 - 1;
        this.nextLast = this.nextFirst + this.size + 1;
    }


    public void addFirst(T item) {
        //TODO
        //need to resize when start of array is reached. Not a circular array.
        if (this.array[0] != null) {
            this.resize(this.array.length * 2);
        }
        this.array[this.nextFirst] = item;
        this.nextFirst -= 1;
        this.size += 1;
    }

    public void addLast(T item) {
        //TODO
        //need to resize when end of array is reached. Not a circular array.
        if (this.array[this.array.length - 1] != null) {
            this.resize(this.array.length * 2);
        }
        this.array[this.nextLast] = item;
        this.nextLast += 1;
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
        int index = this.nextFirst + 1;
        while(this.array[index] != null) {
            System.out.print(this.array[index] + " ");
            index += 1;
        }
    }

    public T removeFirst() {
        //TODO
        T return_item = this.array[this.nextFirst + 1];
        this.array[this.nextFirst + 1] = null;
        this.nextFirst += 1;
        this.size -= 1;
        return return_item;
    }

    public T removeLast() {
        //TODO
        T return_item = this.array[this.nextLast - 1];
        this.array[this.nextLast - 1] = null;
        this.nextLast -= 1;
        this.size -= 1;
        return return_item;
    }

    public T get(int index) {
        //TODO
        return this.array[this.nextFirst + 1 + index];
    }

}
