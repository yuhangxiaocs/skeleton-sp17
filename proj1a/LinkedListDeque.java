public class LinkedListDeque<T> {

    // 链表中节点定义
    private class Node {
        private T val;
        private Node pre;
        private Node next;

        public Node() {
            val = (T) new Object();
            pre = next = null;
        }

        public Node(T x) {
            val = x;
            pre = next = null;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    // 属性
    private int size;
    private Node first;
    private Node last;


    public LinkedListDeque() {
        first = new Node();
        last = new Node();

        first.next = last;
        last.pre = first;

        size = 0;
    }

    public LinkedListDeque(T x) {
        this();
        addFirst(x);
    }

    /**
     * Adds an item to the front of the Deque.
     */
    public void addFirst(T x) {
        Node node = new Node(x);

        node.next = first.next;
        first.next.pre = node;
        node.pre = first;
        first.next = node;

        size++;
    }

    /**
     * Adds an item to the back of the Deque.
     */
    public void addLast(T x) {
        Node node = new Node(x);
        last.pre.next = node;
        node.pre = last.pre;
        node.next = last;
        last.pre = node;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0 && first.next == last;
    }

    /**
     * : Returns the number of items in the Deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the Deque from first to last, separated by a space.
     */
    public void printDeque() {
        Node p = first;

        while (p.next != last) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the Deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (first.next == last) {
            return null;
        }
        T x = first.next.val;
        first.next = first.next.next;
        size--;
        return x;
    }

    /**
     * Removes and returns the item at the back of the Deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = last.pre.val;
        last.pre.pre.next = last;
        size--;
        return x;
    }

    /**
     * : Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        Node p = first;
        int i = 0;
        while (p != last && i <= index) {
            p = p.next;
            i++;
        }

        return p.val;
    }

    private T getRecursive(Node node, int index) {
        if (index == 0) {
            return node.val;
        }
        return getRecursive(node.next, index - 1);
    }

    public T getRecursive(int index) {
        return getRecursive(first.next, index);
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();

        System.out.println(list.size);

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.printDeque();
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        System.out.println(list.size());
        System.out.println(list.get(5));
        System.out.println(list.getRecursive(5));

    }
}