import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.list static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.list(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.list(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.list(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.list method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.list().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.list(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.list(1, 2, 3), L);
        assertEquals(IntList.list(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.list(1, 2, 3);
        IntList B = IntList.list(4, 5, 6);
        IntList exp = IntList.list(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.list(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.list(1, 2, 3);
        IntList B = IntList.list(4, 5, 6);
        IntList exp = IntList.list(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.list(1, 2, 3), A);
    }

    @Test(timeout = 1000)
    public void testReverse() {
        IntList A = IntList.list(1, 2, 3);
        IntList exp = IntList.list(3, 2, 1);
        assertEquals(exp, IntList.reverse(A));
        assertEquals(null, IntList.reverse(null));
    }
    /** If you're running this from the command line, you'll need
     * to add a main method. See ArithmeticTest.java for an
     * example. */

}
