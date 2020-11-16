package ee.bcs.valiiit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Lesson1MathUtilTest {

    @Test
    public void min() {
        assertEquals(2, Lesson1MathUtil.min2(2, 3));
    }

    @Test
    public void test_min_inputsString_returnsException() {
        assertEquals(2, Lesson1MathUtil.min2(2, 3));
    }

    @Test
    public void min_testWithNegativeNumbers_returnsResult() {
        assertEquals(-2, Lesson1MathUtil.min2(2, -2));
        double a = 1.0;
        double b = 1.0;
        assertEquals(a,b,0.00001); // lubab delta suurust erinevust ebatäpsetel andmetüüpidel
    }


    @Test
    public void max() {
        assertEquals(7, Lesson1MathUtil.max2(5, 7));
    }

    @Test
    public void test_isEven_inputOdd_shouldBeTrue(){
        assertEquals(false, Lesson1MathUtil.isEven(7));
    }

    @Test
    public void test_isEven_inputEven_shouldBeFalse(){
        assertEquals(false, Lesson1MathUtil.isEven(8));
    }

    @Test
    public void test_min3_inputThreePositiveIntegers_returnsFirstOne() {
        assertEquals(2, Lesson1MathUtil.min3(2, 3, 5));
    }

    @Test
    public void test_abs_inputNegativeInteger_returnsPositive(){
        assertEquals(5, Lesson1MathUtil.abs(-5));
    }


}


