import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("");
        assertEquals(0, result);
    }
    @Test
    void testOneNumber() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("1");
        assertEquals(1, result);
    }
    @Test
    void testTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("1,2");
        assertEquals(3, result);
    }
    @Test
    void testMoreThanTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.Add("1,2,3"));
    }
}
