import java.math.BigInteger;

public class ArrayDeque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private final double maxLoadFactor = 0.75;
    private final double minLoadFactor = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }


    public void resize(int capaticy) {
        T[] arr = (T[]) new Object[capaticy];
        int index = 0;
        while ((nextLast + 1) % items.length != nextFirst) {
            arr[++index] = items[++nextLast % items.length];
        }
        nextFirst = 0;
        nextLast = size + 1;
        items = arr;
    }

    public void updateLoadRatio() {
        double ratio = size * 1.0 / items.length;
        if (ratio > maxLoadFactor) {
            resize(items.length * 2);
        }
        if (ratio < minLoadFactor) {
            if (items.length < 20) {
//                太小的时候 不需要频繁换
                return;
            }
            resize(items.length / 2);
        }
    }

    /**
     * Adds an item to the front of the Deque.
     */
    public void addFirst(T x) {
        items[nextFirst] = x;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
        updateLoadRatio();
    }

    /**
     * Adds an item to the back of the Deque.
     */
    public void addLast(T x) {
        items[nextLast] = x;
        nextLast = (nextLast + 1) % items.length;
        size++;
        updateLoadRatio();
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
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
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + " ");
        }
    }

    /**
     * : Removes and returns the item at the front of the Deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0)
            return null;
        T deleted = items[++nextFirst];
        items[nextFirst] = null;
        size--;
        return deleted;
    }

    /**
     * : Removes and returns the item at the back of the Deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T deleted = items[--nextLast];
        items[nextLast] = null;
        size--;
        return deleted;
    }

    /**
     * : Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        assert index < size : "index too large";
        return items[(nextFirst + 1 + index) % items.length];
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst(3);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(1);
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        arrayDeque.addLast(8);
        System.out.println(arrayDeque.size());
        System.out.println(arrayDeque.get(0));


    }
}