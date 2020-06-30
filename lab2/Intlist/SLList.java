public class SLList<T> {
    private StuffNode sentinel;
    private int size;

    // nested class
    // 如果other class 不需要访问这个内部类 设置成private
    // 如果内部类不需要"look outside" 设置成static
    private class StuffNode {
        public T item;
        public StuffNode next;

        public StuffNode(T i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    // 可以方便的创建空list
    public SLList() {
        sentinel = new StuffNode(new T(), null);
        size = 0;
    }

    public SLList(T x) {
        this();
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    // 添加首元素
    public void addFirst(T x) {
        sentinel = new StuffNode(x, sentinel.next);
        size += 1;
    }

    // 获取首元素
    public T getFirst() {
        return sentinel.next.item;
    }

    public void addLast(T x) {
        StuffNode p = sentinel;
        size += 1;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    public int size() {
        return size;
    }

    public T getLast() {
        StuffNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }


    public static void main(String[] args) {

    }


    // public static void main(String[] args) {
    // 	SLList L = new SLList(5);
    // 	L.addLast(6);
    // 	L.addLast(7);
    // 	System.out.println(L.getFirst());
    // 	System.out.println(L.getLast());
    // 	System.out.println(L.size());
    // }
}

/**
 * public int sizeIteration(){
 * IntNode p = first;
 * int totalSize = 0;
 * while (p != null){
 * totalSize += 1;
 * p = p.next;
 * }
 * return totalSize;
 * }
 * <p>
 * // 直接递归不行 所以需要这个helper函数
 * private static int size(IntNode p){
 * return p.next == null ? 1 : 1 + size(p.next);
 * }
 * public int size(){
 * return size(first);
 * }
 */