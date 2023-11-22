package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator;

    String numFilepath;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = getClass().getClassLoader().getResource("numbers.txt").getPath();
    }
    @Test
    public void sumOfNumbers() throws IOException {
        int sum = calculator.calcSum(this.numFilepath);
        assertThat(sum).isEqualTo(10);
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        int multiply = calculator.calcMultiply(this.numFilepath);
        assertThat(multiply).isEqualTo(24);
    }
}
