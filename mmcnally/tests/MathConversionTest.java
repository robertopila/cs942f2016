import com.mcnally.MathConversion;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class MathConversionTest {

    private class ConversionArgsAndExpected {
        private String number;
        private int base;
        private int expected;

        public ConversionArgsAndExpected(String n, int b, int e) {
            this.number = n;
            this.base = b;
            this.expected = e;
        }

        public String getNumber() {
            return number;
        }

        public int getBase() {
            return base;
        }

        public int getExpected() {
            return expected;
        }
    }

    @Test
    public void testConversionFromHex() {
        ArrayList<ConversionArgsAndExpected> tests = new ArrayList<>();
        tests.add(new ConversionArgsAndExpected("1", 16, 1));
        tests.add(new ConversionArgsAndExpected("2", 16, 2));
        tests.add(new ConversionArgsAndExpected("3", 16, 3));
        tests.add(new ConversionArgsAndExpected("4", 16, 4));
        tests.add(new ConversionArgsAndExpected("5", 16, 5));
        tests.add(new ConversionArgsAndExpected("6", 16, 6));
        tests.add(new ConversionArgsAndExpected("7", 16, 7));
        tests.add(new ConversionArgsAndExpected("8", 16, 8));
        tests.add(new ConversionArgsAndExpected("9", 16, 9));
        tests.add(new ConversionArgsAndExpected("A", 16, 10));
        tests.add(new ConversionArgsAndExpected("B", 16, 11));
        tests.add(new ConversionArgsAndExpected("C", 16, 12));
        tests.add(new ConversionArgsAndExpected("D", 16, 13));
        tests.add(new ConversionArgsAndExpected("E", 16, 14));
        tests.add(new ConversionArgsAndExpected("F", 16, 15));
        tests.add(new ConversionArgsAndExpected("10", 16, 16));
        tests.add(new ConversionArgsAndExpected("100", 16, 256)); 
        tests.add(new ConversionArgsAndExpected("101", 16, 257));

        for (ConversionArgsAndExpected test : tests) {
            assertTrue(
		        MathConversion.toDecimal(test.getNumber(), test.getBase()) 
			        == test.getExpected());
        }
    }
    

    @Test
    public void testConversionFromOCtal() {
        ArrayList<ConversionArgsAndExpected> tests = new ArrayList<>();
        tests.add(new ConversionArgsAndExpected("1", 8, 1));
        tests.add(new ConversionArgsAndExpected("2", 8, 2));
        tests.add(new ConversionArgsAndExpected("3", 8, 3));
        tests.add(new ConversionArgsAndExpected("4", 8, 4));
        tests.add(new ConversionArgsAndExpected("5", 8, 5));
        tests.add(new ConversionArgsAndExpected("6", 8, 6));
        tests.add(new ConversionArgsAndExpected("7", 8, 7));
        tests.add(new ConversionArgsAndExpected("10", 8, 8));
        tests.add(new ConversionArgsAndExpected("11", 8, 9));
        tests.add(new ConversionArgsAndExpected("100", 8, 64));
        tests.add(new ConversionArgsAndExpected("101", 8, 65));

        for (ConversionArgsAndExpected test : tests) {
            assertTrue(
		        MathConversion.toDecimal(test.getNumber(), test.getBase()) 
			        == test.getExpected());
        }
    }
}
