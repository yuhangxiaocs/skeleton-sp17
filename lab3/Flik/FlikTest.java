import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testEqual() {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        assertTrue(Flik.isSameNumber(a, b));
    }
}
