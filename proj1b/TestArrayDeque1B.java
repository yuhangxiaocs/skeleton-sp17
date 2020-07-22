import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDeque1B {
    @Test
    public void testRandom() {
        ArrayDequeSolution<Integer> target = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> arr = new StudentArrayDeque<>();
        OperationSequence operationSequence = new OperationSequence();
        try {
            for (int i = 0; i < 1000; i++) {
                int type = StdRandom.uniform(0, 4);
                switch (type) {
                    case 0: {
                        target.addFirst(i);
                        arr.addFirst(i);
                        operationSequence.addOperation(new DequeOperation("addFirst", i));
                        break;
                    }
                    case 1: {
                        target.addLast(i);
                        arr.addLast(i);
                        operationSequence.addOperation(new DequeOperation("addLast", i));
                        break;
                    }
                    case 2:
                        if (arr.isEmpty() || target.isEmpty()) {
                            operationSequence.addOperation(new DequeOperation("size"));
                            assertEquals(target.size(), arr.size());
                            break;
                        }
                        operationSequence.addOperation(new DequeOperation("removeFirst"));

                        Integer a = target.removeFirst();
                        Integer b = arr.removeFirst();
                        assertEquals(a, b);
                        break;
                    case 3:
                        if (arr.isEmpty() || target.isEmpty()) {
                            operationSequence.addOperation(new DequeOperation("size"));
                            assertEquals(target.size(), arr.size());
                            break;
                        }
                        operationSequence.addOperation(new DequeOperation("removeLast"));

                        a = target.removeLast();
                        b = arr.removeLast();
                        assertEquals(a, b);
                        break;
                }

                assertEquals(target.size(), arr.size());

            }

        } catch (AssertionError e) {
            System.out.println("error");
            System.out.println(operationSequence);

        }
    }
}
