package com.brunomilitzer.maven.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorImplTest {

    @Test
    public void addShouldReturnAResult() {

        final Calculator c = new CalculatorImpl();
        final int result = c.add( 10, 20 );
        assertEquals( 30, result );
    }

}