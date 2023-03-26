package com.example.demojunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void initTest() {
        this.calculator = new Calculator();
    }

    @Test
    void demoTestMethod() {
        assertTrue(true, "kiểm tra condition nếu false thì thông báo message này");
    }


    @Test
    @DisplayName("replace name method to this string")
    void sumTest() {
        assertEquals(calculator.sum(10, 20), 30);
    }

    @RepeatedTest(5) /* test method 5 times*/
    void multiplierTest() {
        assertEquals(Calculator.multiplier(10, 20), 200);
    }

    @Test
    void handlerException() {
        assertAll(() -> assertEquals(Calculator.multiplier(10, 20), 200),
                () -> assertEquals(calculator.sum(10, 20), 30));
        assertThrows(RuntimeException.class, () -> Calculator.multiplier(10000, 20));
    }

    @Test
    void examLambda() {
    }

    @Test
    void timeOutTest() {
        assertTimeout(Duration.ZERO, () -> Calculator.multiplier(10, 20));
    }

    //    dynamic test
    @TestFactory
    Stream<DynamicTest> testDifferentMultiplyOperations() {
        int[][] data = new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
                assertEquals(expected, Calculator.multiplier(m1, m2));
            });
        });
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void testWithStringParameter(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, Calculator.multiplier(m1, m2));
    }

    private static int[][] data() {
        return new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
    }
}
