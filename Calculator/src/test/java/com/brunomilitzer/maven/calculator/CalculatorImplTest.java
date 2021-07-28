package com.brunomilitzer.maven.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith( Parameterized.class )
public class CalculatorImplTest {

    private final int num1;
    private final int num2;
    private final int expectedResult;

    public CalculatorImplTest( final int num1, final int num2, final int expectedResult ) {

        this.num1 = num1;
        this.num2 = num2;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Integer[]> data() {

        return Arrays.asList( new Integer[][]{ { -1, 2, 1 }, { 1, 2, 3 }, { 6, 7, 13 }, { -5, 5, 0 } } );
    }

    @Test
    public void addShouldReturnAResult() {

        final Calculator c = new CalculatorImpl();
        final int result = c.add( this.num1, this.num2 );
        assertEquals( this.expectedResult, result );
    }

}