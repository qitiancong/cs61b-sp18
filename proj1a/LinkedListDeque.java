public class LinkedListDeque<T> {
    //use circular LL in lecture 5 slides
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        /** constructor */
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    /** create empty List */
    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

//    /** create List with 1 item of type T */
//    public LinkedListDeque(T item) {
//        this.sentinel = new Node(null, null, null);
//        this.sentinel.next = new Node(item, this.sentinel, this.sentinel);
//        this.sentinel.next.prev = this.sentinel;
//        this.sentinel.next.next = this.sentinel;
//        this.sentinel.prev = this.sentinel.next;
//        this.size += 1;
//    }

    /**Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        this.sentinel.next = new Node(item,this.sentinel,this.sentinel.next);
        this.sentinel.next.next.prev = this.sentinel.next;
        this.size += 1;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        if (this.isEmpty()) {
            this.addFirst(item);
        } else {
            this.sentinel.prev.next = new Node(item,this.sentinel.prev,this.sentinel);
            this.sentinel.prev = this.sentinel.prev.next;
            this.size += 1;
        }
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Returns the number of items in the deque.*/
    public int size() {
        return this.size;
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else if (this.size() == 1) {
            T result = this.sentinel.next.item;
            this.sentinel.next = this.sentinel;
            this.sentinel.prev = this.sentinel;
            this.size -= 1;
            return result;
        } else {
            T result = this.sentinel.next.item;
            this.sentinel.next.next.prev = null;
            this.sentinel.next.prev = null;
            this.sentinel.next = this.sentinel.next.next;
            this.sentinel.next.prev = this.sentinel;
            this.size -= 1;
            return result;
        }

    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        if (this.size < 2) {
            return this.removeFirst(); //same procedure as removeFirst for length = 0 and 1;
        } else {
            T return_item = this.sentinel.prev.item;
            this.sentinel.prev.prev.next = this.sentinel;
            this.sentinel.prev = this.sentinel.prev.prev;
            this.size -= 1;
            return return_item;
        }
    }

    /** Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (this.size == 0) { //List of size has no item
            return null;
        } else {
            Node p = this.sentinel.next; //pointer for 0th Node
            int i = 0;
            while(i != index) {
                p = p.next;
                i += 1;
            }
            return p.item;
        }
    }

    /** recursive get using helper function */
    private T getItemAtIndex(int index, int count, Node p) {
        if (index == count) {
            return p.item;
        }
        return this.getItemAtIndex(index, count + 1, p.next);
    }
    public T getRecursive(int index) {
        if (this.size == 0 || index >= this.size || index < 0) {
            return null;
        }
        int count = 0;
        Node p = this.sentinel.next;
        return this.getItemAtIndex(index,count,p);
    }


     /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        if (this.size == 0) {
            System.out.println("Deque is empty");
        } else {
            Node p = this.sentinel.next;
            while (p != this.sentinel) { //p has not reached last Node yet
                System.out.print(p.item + " ");
                p = p.next;
            }
        }
    }
}
