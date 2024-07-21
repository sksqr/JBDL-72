package com.example.L14_UTandITdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        Integer a = 8;
        Integer b = 2;
        Integer expected = 10;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }

    @Test
    public void testAddNegative(){
        Integer a = -8;
        Integer b = -2;
        Integer expected = -10;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }
    @Test
    public void testMultiply(){
        Integer a = 8;
        Integer b = 2;
        Integer expected = 16;
        assertThat(calculator.multiply(a,b)).isEqualTo(expected);
    }

    @Test
    public void testMultiplyNegative(){
        Integer a = -8;
        Integer b = -2;
        Integer expected = -16;
        assertThat(calculator.multiply(a,b)).isNotEqualTo(expected);
    }

}
