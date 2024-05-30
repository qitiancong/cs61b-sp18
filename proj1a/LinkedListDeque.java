public class LinkedListDeque<T> {
    //use circular LL in lecture 5 slides
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        /** constructor */
        public Node(T item, Node prev,Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    /** create empty List */
    public LinkedListDeque() {
        this.sentinel = new Node(null,null,null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    /** create List with 1 item of type T */
    public LinkedListDeque(T item){
        this.sentinel = new Node(null,null,null);
        this.sentinel.next = new Node(item,this.sentinel,this.sentinel);
        this.sentinel.next.prev = this.sentinel;
        this.sentinel.next.next=this.sentinel;
        this.sentinel.prev = this.sentinel.next;
        this.size += 1;
    }

    /**Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        this.sentinel.next = new Node(item,this.sentinel,this.sentinel.prev);
        this.sentinel.prev.prev = this.sentinel.next;
    }
    /** main method to test functions, delete later */
    public static void main (String[] args) {
        LinkedListDeque<String> L1 = new LinkedListDeque<>("abcd");
        L1.addFirst("efg");
    }


}
