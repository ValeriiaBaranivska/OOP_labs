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
    void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("-8,0,9");
        assertEquals(0, result);
    }
    @Test
    void testMoreThan1000() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("100\n1005,11\n2023");
        assertEquals(111, result);
    }
    @Test
    void testCommaLast() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("1,\n");
        assertEquals(0, result);
    }
    @Test
    void testAll() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[a][b][c][*]\n1005aaa11b2023,12\n1cccccc2,10\n2050");
        assertEquals(36, result);
    }
    @Test
    void testAll2() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[a][b][c][*]\n1005aaa11b2023,12\n-1cccccc2,10\n2050");
        assertEquals(0, result);
    }
    @Test
    void testAll3() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[a][b][c][*]\n1005aaa11b2023,12\n1c*ccc2,10\n2050");
        assertEquals(36, result);
    }
    @Test
    void testAll4() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[a][b][c][*]\n1005aaa11b2023,12\n1c*ccc2,\n");
        assertEquals(0, result);
    }
}
