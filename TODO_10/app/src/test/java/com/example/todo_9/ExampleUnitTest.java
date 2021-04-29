package com.example.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void setup(){
        mCalculator = new Calculator();
    }
    @Test
    public void addTwoNumbers(){
        double result = mCalculator.Add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void addTwoNegative(){
        double result = mCalculator.Add(-1d, -2d);
        assertThat(result, is(equalTo(-3d)));
    }
    @Test
    public void addTwoNumbersFloat(){
        double result = mCalculator.Add(1.111f,1.111d);
        assertThat(result, is(closeTo(2.222,0.01)));
    }
    @Test
    public void subTwoNumbers() {
        double result = mCalculator.Subtract(4d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void subWorksWithNegativeResults() {
        double result = mCalculator.Subtract(-2d,2d);
        assertThat(result, is(equalTo(-4d)));
    }
    @Test
    public void mulTwoNumbers() {
        double result = mCalculator.Multiply(2d, 2d);
        assertThat(result, is(4d));
    }
    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.Multiply(2d,0d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbers() {
        double result = mCalculator.Divide(8d, 4d);
        assertThat(result, is(2d));
    }
    @Test
    public void divTwoNumbersZero() {
        double result = mCalculator.Divide(4d, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}