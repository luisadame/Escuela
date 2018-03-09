import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class getAVG extends StudentTest {

    @Test
    void testGetAvg() {
        Student k = new Student();
        k.setAVG(7.0);
        assertEquals(7.0, k.getAVG());
        assertNotEquals(7.1, k.getAVG());
    }
}
